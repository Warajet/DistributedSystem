import javax.jms.*;
import javax.naming.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Scanner;

public class AccountJMSClient {
    public static void main(String argv[]) throws Exception {
        Hashtable<String, String> properties = new Hashtable<String, String>();
        properties.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        properties.put(Context.PROVIDER_URL, "tcp://localhost:61616");

        Context context = new InitialContext(properties);

        QueueConnectionFactory connFactory =
                (QueueConnectionFactory)context.lookup("ConnectionFactory");

        QueueConnection conn = connFactory.createQueueConnection();
        QueueSession session = conn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

        //For the query to Server
        Queue client_send_queue = (Queue) context.lookup("dynamicQueues/queue1");

        //For getting back the result from Server
        Queue client_receive_queue = (Queue) context.lookup("dynamicQueues/queue2");

        QueueSender sender = session.createSender(client_send_queue);

        QueueReceiver receiver = session.createReceiver(client_receive_queue);

        //Start the connection
        conn.start();

        Scanner user_inp = new Scanner(System.in);

        //Operation and options goes here
        System.out.println("Please select the following action");
        System.out.println("(1) Add new account entry");
        System.out.println("(2) Query account name of all account entries");

        while (true) {
            int input = user_inp.nextInt();
            if (input > 0 && input <= 2) {
                TextMessage msg = session.createTextMessage();
                    if (input == 1) {   //In this case, acts as a sender
                        Scanner name_inp = new Scanner(System.in);
                        Scanner amount = new Scanner(System.in);
                        System.out.println("Please insert the new account entry information: ");
                        System.out.println("Please enter the name: ");
                        String account_entry_name = name_inp.nextLine();
                        System.out.println("Please enter the amount: ");
                        double account_entry_amount = amount.nextDouble();

                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String current_date = simpleDateFormat.format(new Date());

                        msg.setText("1," + account_entry_name + "," + Double.toString(account_entry_amount) + "," + current_date);
                        System.out.println("Sending Message: "+msg.getText());
                        sender.send(msg);
                        System.out.println("Message successfully sent.");
                        break;
                    }
                    if(input == 2)
                    {
                        msg.setText("2");
                        sender.send(msg);
                        System.out.println("Message successfully sent.");

                        //In this case acts as the receiver to display the list of entries
                        Message m = receiver.receive();
                        System.out.println("Get Account Entries");

                        if(m instanceof TextMessage) {
                            TextMessage txt = (TextMessage) m;
                            System.out.println("Message Received: "+txt.getText());
                        }
                        break;
                    }
                }
                else {
                    System.out.println("No supported operations available");
                    continue;
                }
            }
        session.close();
        conn.close();
    }
}
