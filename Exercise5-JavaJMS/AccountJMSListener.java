import javax.jms.*;
import java.util.ArrayList;

public class AccountJMSListener implements MessageListener {
    Account account;
    QueueSender queueSender;
    Session session;
    AccountJMSListener(Account account, QueueSender queueSender, Session session)
    {
        this.account = account;
        this.queueSender = queueSender;
        this.session = session;
    }

    @Override
    public void onMessage(Message message) {
        //For sending back the result to client
        TextMessage m = (TextMessage) message;

        try{
            if(m instanceof TextMessage) {
                System.out.println("following message is received:" + m.getText());
                String[] info = m.getText().split(",");
                String methodNumber = info[0];
                // for method 1
                if (methodNumber.compareTo("1") == 0) // if method number equals 1
                {
                    String accName = info[1];
                    String amount = info[2];
                    String date = info[3];
                    (this.account).addAccountEntry(accName, date, Double.parseDouble(amount));
                    System.out.println("New Entry with amount: " + accName + ", date: " + date + ", accName: " + amount
                            + " \nsuccessfully added to Account object\n");
                }

                else if (methodNumber.compareTo("2") == 0) {

                    System.out.println("Query for list of account entriers");

                    ArrayList<String> accountNames = new ArrayList<String>();
                    for (int i = 0; i < (this.account).getAccount_entries().size(); i++) {
                        accountNames.add((this.account).getAccount_entries().get(i).toString());
                    }
                    String listString = "\n";

                    for (String s : accountNames) {

                        listString += s + "\n";
                    }

                    System.out.println(listString);
                    TextMessage msg = this.session.createTextMessage();
                    msg.setText(listString);
                    this.queueSender.send(msg);
                } else {
                    System.out.println("No supported operations available. Please select the 1 or 2");
                }
            }
        }catch(JMSException e){System.out.println(e);}

    }
}
