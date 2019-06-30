import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.util.ArrayList;

//Servant class -> the class that creates an object being used/called by client side
//Server class used to register the servant class with RMIRegistry
public class AccountManagementImpl extends UnicastRemoteObject implements AccountManagementRemote {
    private Account account;
    public AccountManagementImpl(String account_name) throws RemoteException {
        super();
        this.account = new Account(account_name);
    }
    public Account getAccount()
    {
        System.out.println("Account object");
        return this.account;
    }
    @Override
    public ArrayList<AccountEntry> search_entry_by_amount(double amount) {
        return this.account.search_by_amount(amount);
    }

    @Override
    public void addAccountEntry(String name, String date, double amount) {
        this.account.addAccountEntry(name, date, amount);
    }

    @Override
    public ArrayList<AccountEntry> get_all_account_entries() {
        return this.account.getAccount_entries();
    }

    @Override
    public String get_account_name() {
        return this.account.getAccount_name();
    }
}
