public class ReferenceBook extends LibraryBook {
    private String collection;
    public ReferenceBook(String author, String title, String isbn, String callNumber, String c) {
        super(author, title, isbn, callNumber);
        collection = c;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String c) {
        collection = c;
    }

    public void checkout(String patron, String due) {
        throw new UnsupportedOperationException("Cannot check out a reference book");
    }

    public void returned() {
        throw new UnsupportedOperationException("Reference book could not have been checked out -- return impossible");
    }

    public String circulationStatus() {
        return "Non-circulating reference book";
    }
}
