public abstract class LibraryBook extends Book implements Comparable<LibraryBook> {
    private String callNumber;

    public LibraryBook(String author, String title, String isbn, String c) {
        super(author, title, isbn);
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

    public int compareTo(LibraryBook other) {
        return callNumber.compareTo(other.callNumber);
    }

    public String toString() {
        return super.toString() + "; Circulation Status: " + circulationStatus();
    }
}
