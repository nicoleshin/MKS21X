public abstract class LibraryBook extends Book implements Comparable<LibraryBook> {
    private String callNumber;

    public LibraryBook(String author, String title, String isbn, String c) {
        setAuthor(author);
        setTitle(title);
        setISBN(isbn);
        callNumber = c;
    }

    abstract void checkout(String patron, String due);
    abstract void returned();
    abstract String circulationStatus();

    public String getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(String s) {
        callNumber = s;
    }

    public int compareTo(LibraryBook o) {
        return 0;
    }

    public String toString() {
        return super.toString() + "; Circulation Status: " + circulationStatus();
    }
}
