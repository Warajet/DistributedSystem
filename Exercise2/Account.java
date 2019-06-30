import java.util.ArrayList;

public class Account {
    private String account_name;
    private ArrayList<AccountEntry> account_entries;

    Account(String name)
    {
        this.account_name = name;
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
        return tmp;
    }

    public ArrayList<AccountEntry> getAccount_entries() {
        return this.account_entries;
    }

    public void display_all_entries()
    {
        for (AccountEntry entry: this.account_entries) {
            System.out.println(entry.toString());
        }
    }

    public void addAccountEntry(AccountEntry account_entry)
    {
        this.account_entries.add(account_entry);
    }

    public String getAccount_name()
    {
        return this.account_name;
    }

}

class AccountEntry{
    private double amount;
    private String date;
    private String account_name;
    AccountEntry(String account_name, String date, double amount)
    {
        this.account_name = account_name;
        this.date = date;
        this.amount = amount;
    }

    public String getDate()
    {
        return this.date;
    }
    public String getAccount_name()
    {
        return this.account_name;
    }
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Account name: " + this.account_name + "Date: " + this.date + " amount: " + String.format("%.2f", this.amount);
    }
}
