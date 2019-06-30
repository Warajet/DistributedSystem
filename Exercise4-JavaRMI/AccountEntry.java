import java.io.Serializable;

class AccountEntry implements Serializable {
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
        return "Account name: " + this.account_name + " Date: " + this.date + " amount: " + String.format("%.2f EUR", this.amount);
    }
}