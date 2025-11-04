//modified version of Library App
public class LibraryApp{
    public static void main(String[] args) {
        Library library = new Library();

        LibrarianController controller = new LibrarianController(library);

        System.out.println("----Library Management System----\n");

        System.out.println("Adding sample books to library...");
        library.addBook(new Book("Dune", "Frank Herbert"));
        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(new Book("Moby Dick", "Herman Melville"));

        System.out.println("\nAdding members to library...");
        library.addMember(new Member("M001", "Alice"));
        library.addMember(new Member("M002", "Bob"));

        System.out.println("\nCurrent catalog:");
        for(Book book : library.getCatalog()) {
            System.out.println(book);
        }

        System.out.println("\nAlice borrows Dune:");
        System.out.println(controller.borrowBook("Alice", "Dune"));

        System.out.println("\nCatalog after Alice borrows a book:");
        for(Book book : library.getCatalog()) {
            System.out.println(book);
        }
        System.out.println("\nAlice returns Dune:");
        System.out.println(controller.returnBook("Alice", "Dune"));
        System.out.println("\nBob borrows Dune:");
        System.out.println(controller.borrowBook("Bob", "Dune"));

        System.out.println("\nRemoving Moby Dick from library...");
        library.removeBook("Moby Dick");

        System.out.println("\nLookup member 'Alice': "+ library.findMemberByName("Alice"));
        System.out.println("\nLookup book '1984': " + library.findBookByTitle("1984"));

        System.out.println("\nFinal catalog:");
        for(Book book : library.getCatalog()) {
            System.out.println(book);
        }
        System.out.println("\n----------------");
    }

}
