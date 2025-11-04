public class LibrarianController {

    // GRASP Principle: Controller
    // Handles user requests like borrowing and returning books.
    // Delegates tasks to the appropriate objects.

    // Done: implement functionality of Member class
    private Library library;

    public LibrarianController(Library library) {
        this.library = library;
    }

    public String borrowBook(String memberName, String bookTitle) {
        Member member = library.findMemberByName(memberName);
        Book book = library.findBookByTitle(bookTitle);

        if(member == null) {
            return "Borrow failed: Member not found.";
        }
        if(book == null) {
            return "Borrow failed: Book not found.";
        }
        if(!book.isAvailable()) {
            return "Reject request: Book is not available.";
        }

        boolean success = member.borrowBook(book);
        return success ? "Borrow successful." : "Borrow failed.";
    }

    public String returnBook(String memberName, String bookTitle) {
        Member member = library.findMemberByName(memberName);
        Book book = library.findBookByTitle(bookTitle);

        if(member ==null) return "Return failed: member not found.";
        if(book ==null) return "Return failed: book not found.";

        boolean success = member.returnBook(book);
        return success ? "Return successful." : "Return failed: member does not have this book.";
    }

    public String lookupBook(String title) {
        Book book = library.findBookByTitle(title);
        return (book == null) ? "Book not found." : book.toString();
    }

    public String lookUpMember(String name) {
        Member member = library.findMemberByName(name);
        return (member == null) ? "Member not found." : member.toString();
    }

    public String displayCatalog() {
        StringBuilder sb = new StringBuilder("Catalog:\n");
        for(Book b:library.getCatalogSnapshot()) {
            sb.append(" - ").append(b).append("\n");
        }
        return sb.toString();
    }
}