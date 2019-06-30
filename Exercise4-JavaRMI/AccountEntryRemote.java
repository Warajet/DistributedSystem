import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AccountEntryRemote extends Remote {
    public String getName() throws RemoteException;
    public double getPrice() throws RemoteException;
    public void setPrice(double price) throws RemoteException;
}
