import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface AccountManagementRemote extends Remote {
    public ArrayList<AccountEntry> search_entry_by_amount(double amount) throws RemoteException;
    public void addAccountEntry(String name, String date, double amount) throws RemoteException;
    public ArrayList<AccountEntry> get_all_account_entries() throws RemoteException;
    public String get_account_name() throws RemoteException;
    public Account getAccount() throws RemoteException;

}
