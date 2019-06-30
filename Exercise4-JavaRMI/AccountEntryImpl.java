import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AccountEntryImpl extends UnicastRemoteObject implements AccountEntryRemote {
    private AccountEntry accountEntry;
    public AccountEntryImpl(String account_name, String date, double amount) throws RemoteException {
        super();
        this.accountEntry = new AccountEntry(account_name, date, amount);
    }
    @Override
    public String getName() throws RemoteException {
        return this.accountEntry.getAccount_name();
    }

    @Override
    public double getPrice() throws RemoteException {
        return this.accountEntry.getAmount();
    }

    @Override
    public void setPrice(double price) throws RemoteException {
        this.accountEntry.setAmount(price);
    }
}
