
import java.util.ArrayList;
import java.util.List;
public class Library {

	//  GRASP Principles: Creator, Controller
	//	Manage the catalog of books and members.
	//	Track which books are borrowed and available


	// Attributes:
	// private catalog (list of Book)
	// private members (list of Members)

	// DONE: implement functionality of Member class
    private List<Book> catalog;
    private List<Member> members;

    public Library() {
        catalog = new ArrayList<>();
        members = new ArrayList<>();
    }
    public void addBook(Book book) {
        if (book != null) {
            catalog.add(book);
        }
    }

    public void addMember(Member member) {
        if (member != null) {
            members.add(member);
        }
    }

    public boolean removeBook(String title) {
        Book b = findBookByTitle(title);
        if (b != null) {
            catalog.remove(b);
            return true;
        }
        return false;
    }

    public boolean removeMember(String name) {
        Member m = findMemberByName(name);
        if (m != null) {
            members.remove(m);
            return true;
        }
        return false;
    }

    public Book findBookByTitle(String title) {
        for (Book book : catalog) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    public Member findMemberByName(String name) {
        for (Member member : members) {
            if(member.getName().equalsIgnoreCase(name)){
                return member;
            }
        }
        return null;
    }

    public List<Book> getCatalog() {
        return new ArrayList<>(catalog);
    }
    public List<Book> getCatalogSnapshot(){
        return getCatalog();
    }

    public List<Book> availableBooks() {
        List<Book> available = new ArrayList<>();
        for (Book book : catalog) {
            if(book.isAvailable()){
                available.add(book);
            }
        }
        return available;
    }
}
