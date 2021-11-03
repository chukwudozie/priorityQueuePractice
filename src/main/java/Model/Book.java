package Model;

public class Book {
    private static int bookId;
    private String bookTitle;
    private  String bookAuthor;
    private int numberOfBooks;
    private boolean isAvailable;

    public Book(String bookTitle, String bookAuthor, int numberOfBooks) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.numberOfBooks = numberOfBooks;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
