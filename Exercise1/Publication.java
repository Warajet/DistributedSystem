public class Publication {
    private String title, language;
    private double price;
    public Publication()
    {
        this.title = "";
        this.language = "";
        this.price = 0;
    }
    public Publication(String title, String language,double price)
    {
        this.title = title;
        this.language = language;
        this.price = price;
    }
    @Override
    public String toString() {
        return "Title: " + this.title + " \nLanguage: " + this.language + " \nPrice: " + String.format("%.2f", this.price)  + " EUR";
    }
}
