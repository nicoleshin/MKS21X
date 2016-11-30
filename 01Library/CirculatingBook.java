public class CirculatingBook extends LibraryBook {
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String author, String title, String isbn, String c) {
        super(author, title, isbn, c);
        currentHolder = dueDate = null;
    }

    public void checkout(String patron, String due) {
    }

    public void returned() {
    }

    public String circulationStatus() {
        if (dueDate == null) {
            return "Book available on shelves";
        } else {
            return currentHolder + ", due on " + dueDate;
        }
    }

    public String toString() {
        String s = super.toString();
        if (dueDate == null) {
            return s;
        } else {
            return s + "; Holder: " + currentHolder + "; Due: " + dueDate;
        }
    }
}
