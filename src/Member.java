import java.util.ArrayList;
import java.util.List;

public class Member {

    // GRASP Principle: Information Expert and Low Coupling
    // Can borrow and return books.

    private String memberId;
    private String name;
    private List<Book> borrowedBooks;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return new ArrayList<>(borrowedBooks);
    }

    public boolean borrowBook(Book book) {
        if (book != null && book.isAvailable()) {
            borrowedBooks.add(book);
            book.borrowed();
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        if (book != null && borrowedBooks.remove(book)) {
            book.returned();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return name + " (" + memberId + "), Books borrowed: " + borrowedBooks.size();
    }
}
