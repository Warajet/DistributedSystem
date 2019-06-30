import javax.jms.*;
import javax.naming.*;
import java.awt.desktop.SystemEventListener;
import java.util.Hashtable;
import java.util.Scanner;

public class AccountJMSServer {

    public static void main(String argv[]) throws Exception {

        Hashtable<String, String> properties = new Hashtable<String, String>();
        properties.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        properties.put(Context.PROVIDER_URL, "tcp://localhost:61616");

        Context context = new InitialContext(properties);

        QueueConnectionFactory connFactory =
                (QueueConnectionFactory)context.lookup("ConnectionFactory");

        QueueConnection conn = connFactory.createQueueConnection();

        //Start the connection
        conn.start();

        QueueSession session = conn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

        //For accepting query from client
        Queue server_receive_queue = (Queue) context.lookup("dynamicQueues/queue1");

        //For sending back the result to client
        Queue server_send_queue = (Queue) context.lookup("dynamicQueues/queue2");

        QueueReceiver receiver = session.createReceiver(server_receive_queue);

        QueueSender sender = session.createSender(server_send_queue);

        Account account = new Account("Warakorn Jetlohasiri");

        AccountJMSListener message_listener = new AccountJMSListener(account, sender, session);
        receiver.setMessageListener(message_listener);

        System.out.println("Server is ready, waiting for query");
        System.out.println("press Ctrl+c to shutdown...\n");

        Scanner sc = new Scanner(System.in);

        if(sc.hasNext() || sc.hasNextLine())
        {
            System.out.println("System receives unknown message. Terminate");
            session.close();
            conn.close();
            System.exit(0);
        }
    }
}
