package zad1;

public class Book {
    private String ISBN;
    private String title;
    private String year;
    private String price;

    public Book(String ISBN, String title, String year, String price) {
        this.ISBN = ISBN;
        this.title = title;
        this.year = year;
        this.price = price;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return ISBN + " "+ title+" "+year+" "+price;
    }
}
