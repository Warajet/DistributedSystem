import java.net.*;
import java.io.*;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TCPAccountManagementClient {
    public static void main (String args[]) {
        try{
            int serverPort = 5555;
            Socket s = new Socket ("localhost", serverPort);
            ObjectOutputStream out = new ObjectOutputStream ( s.getOutputStream());
            ObjectInputStream in = new ObjectInputStream ( s.getInputStream());

            Message message = new Message();

            Scanner user_inp = new Scanner(System.in);

            //Operation and options goes here
            System.out.println("Please select the following action");
            System.out.println("(1) Add new account entry");
            System.out.println("(2) Query account name of all account entries");

            while(true) {
                int input = user_inp.nextInt();
                if (input > 0 && input <= 2) {
                    if (input == 1) {
                        Scanner name_inp = new Scanner(System.in);
                        Scanner amount = new Scanner(System.in);
                        System.out.println("Please insert the new account entry information: ");
                        System.out.println("Please enter the name: ");
                        String account_entry_name = name_inp.nextLine();
                        System.out.println("Please enter the amount: ");
                        double account_entry_amount = amount.nextDouble();

                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String current_date = simpleDateFormat.format(new Date());

                        message.setOperation("AddEntry");
                        String fields = account_entry_name + "," + current_date + "," + Double.toString(account_entry_amount);
                        message.setFields(fields);

                    }
                    if (input == 2) {
                        System.out.println("Get Account Entries");

                        message.setOperation("getAccountEntry");

                    }
                    out.writeObject(message);

                    Message data = (Message) in.readObject();

                    String output = data.getMessage();
                    String operation = data.getOperation();

                    System.out.println("Operation: " + operation);
                    System.out.println(output);
                    break;
                }

                else
                {
                    System.out.println("Plase select the valid action(1-2)");
                    continue;
                }
            }


            s.close();

        }catch (UnknownHostException e){
            System.out.println(" Socket:"+ e.getMessage());
        }catch (EOFException e){ System.out.println(" EOF:"+ e.getMessage());
        }catch (IOException e){ System.out.println(" IO:"+ e.getMessage());} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }// main
}


