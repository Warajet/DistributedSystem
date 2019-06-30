import java.net.*;
import java.io.*;

public class TCPAccountManagementServer {
    public static void main(String args[]) {
        try {
            System.out.println("The Server is running");
            int serverPort = 5555;
            ServerSocket listenSocket = new ServerSocket(serverPort);

            Account account_on_server = new Account("AJay Black Knight");

            while (true) {
                Socket clientSocket = listenSocket.accept();
                System.out.println("New Connection");
                AccountManagementConnection c = new AccountManagementConnection(clientSocket, account_on_server);
            }
        } catch (IOException e) {
            System.out.println(" Listen :" + e.getMessage());
        }
    }// main
}

class AccountManagementConnection extends Thread{
    Account account;

    ObjectInputStream in;
    ObjectOutputStream out;
    Socket clientSocket;

    public AccountManagementConnection (Socket aClientSocket, Account account) {
        try {
            clientSocket = aClientSocket;

            this.account = account;

            out = new ObjectOutputStream ( clientSocket.getOutputStream() );
            in = new ObjectInputStream ( clientSocket.getInputStream() );

            this.start();

        }
        catch( IOException e) {System. out. println(" Connection:"+ e.getMessage());}
    }

    public void run(){
        try {
            Message data = (Message) in.readObject();
            String operation = data.getOperation();
            System.out.println("Operation: " + operation);

            String field = data.getFields();
            String[] fields = data.getFields().split(",");
            System.out.println("Fields: " + field);

            if(operation.equals("AddEntry") == true)
            {
                (this.account).addAccountEntry(fields[0], fields[1], Double.parseDouble(fields[2]));
                data.setText("Add Entry Successfully");
            }

            if(operation.equals("getAccountEntry") == true)
            {
                data.setText((this.account).display_all_entries());
            }

            out.writeObject(data);

            System.out.println("Sent Message successfully ");
            clientSocket.close();
        }
        catch( EOFException e) {
            System.out.println(" EOF:"+ e.getMessage()); }
        catch( IOException e) {System.out.println(" IO:"+ e.getMessage());} catch (ClassNotFoundException e) { e.printStackTrace(); }
    }
}