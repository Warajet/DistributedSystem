import java.rmi.Naming;

public class AccountManagementServer {
    public static void main(String[] args){
        try {
            AccountManagementImpl accountServer = new AccountManagementImpl("Tim Cook");
            Naming.rebind("AccountManagementServer",accountServer);
            System.out.println("Server starts");
        }catch(Exception e)
        {
            System.out.println("AccountManagementServerImpl: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
