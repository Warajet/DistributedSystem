import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AccountManagementClient {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        AccountManagementRemote account_server = (AccountManagementRemote) Naming.lookup("rmi://"+"localhost"+"/AccountManagementServer");

        Scanner user_inp = new Scanner(System.in);

        //Operation and options goes here
        System.out.println("Please select the following action");
        System.out.println("(1) Add new account entry");
        System.out.println("(2) Query account name of all account entries");
        System.out.println("(3) Search Account Entry by amount");
        System.out.println("(4) Get Account name");

        while (true) {
            int input = user_inp.nextInt();
            if (input > 0 && input <= 4) {
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
                    account_server.addAccountEntry(account_entry_name, current_date, account_entry_amount);

                }
                if (input == 2) {
                    System.out.println("Get Account Entries");
                    ArrayList<AccountEntry> entries = account_server.get_all_account_entries();
                    if(entries.size() == 0)
                    {
                        System.out.println("No Account Entries");
                    }
                    else if(entries.size() > 0) {
                        for (AccountEntry a : entries) {
                            System.out.println(a.toString() + "\n");
                        }
                    }
                }
                if (input == 3) {
                    System.out.println("Search entry by amount");
                    Scanner amount_inp = new Scanner(System.in);
                    System.out.println("Please specify the amount: ");
                    double account_entry_amount = amount_inp.nextDouble();
                    ArrayList<AccountEntry> entries_by_amount = account_server.search_entry_by_amount(account_entry_amount);
                    if(entries_by_amount.size() == 0 )
                    {
                        System.out.println("Amount do not match any entries");
                    }
                    else if(entries_by_amount.size() > 0){
                        for (AccountEntry a : entries_by_amount) {
                            System.out.println(a.toString() + "\n");
                        }
                    }
                }
                if(input == 4)
                {
                    System.out.println("Display Account name");
                    System.out.println(account_server.get_account_name());
                }
                break;
            } else {
                System.out.println("Plase select the valid action(1-2)");
                continue;
            }
        }
    }
}
