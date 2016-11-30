public class Book {
    private String author;
    private String title;
    private String isbn;

    public Book() {
        author = title = isbn = "";
    }

    public Book(String a, String t, String i) {
        author = a;
        title = t;
        isbn = i;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return isbn;
    }

    public void setAuthor(String a) {
        author = a;
    }

    public void setTitle(String t) {
        title = t;
    }

    public void setISBN(String i) {
        isbn = i;
    }

    public String toString() {
        return isbn + ": " + title + " by " + author;
    }
}
