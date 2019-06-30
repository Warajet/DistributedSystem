import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable{
    private String account_name;
    private ArrayList<AccountEntry> account_entries;

    Account(String name)
    {
        this.account_name = name;
        this.account_entries = new ArrayList<AccountEntry>();
    }

    public ArrayList<AccountEntry> search_by_amount(double amount)
    {
        ArrayList<AccountEntry> tmp = new ArrayList<AccountEntry>();
        for (AccountEntry entry: this.account_entries) {
            if(entry.getAmount() == amount)
            {
                tmp.add(entry);
            }
        }
        if(tmp.size() == 0)
        {
            System.out.println("no such amount");
        }
        return tmp;
    }

    public ArrayList<AccountEntry> getAccount_entries() {
        return this.account_entries;
    }

    public String display_all_entries()
    {
        String entries = "";
        for (AccountEntry entry: this.account_entries) {
            entries += entry.toString() + "\n";
        }
        return entries;
    }

    public void addAccountEntry(String name, String date, double amount)
    {
        AccountEntry entry = new AccountEntry(name, date, amount);

        (this.account_entries).add(entry);
    }

    public String getAccount_name()
    {
        return this.account_name;
    }

}
