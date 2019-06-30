public class Book extends Publication {
    protected String author, ISBN;

    public Book(String title, String language, double price, String author, String ISBN)
    {
        super(title, language, price);
        this.author = author;
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAuthor: " + this.author + "\nISBN: " + this.ISBN;
    }
}
