public class LbraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display Books");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Display Issued Books");
            System.out.println("7. Display Library Size");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    break;
                case 2:
                    System.out.print("Enter title of book to remove: ");
                    String titleToRemove = scanner.nextLine();
                    library.removeBook(titleToRemove);
                    break;
                case 3:
                    library.displayBooks();
                    break;
                case 4:
                    System.out.print("Enter your name: ");
                    String user = scanner.nextLine();
                    System.out.print("Enter title of book to issue: ");
                    String bookToIssue = scanner.nextLine();
                    library.issueBook(user, bookToIssue);
                    break;
                case 5:
                    System.out.print("Enter your name: ");
                    user = scanner.nextLine();
                    System.out.print("Enter title of book to return: ");
                    String bookToReturn = scanner.nextLine();
                    library.returnBook(user, bookToReturn);
                    break;
                case 6:
                    library.displayIssuedBooks();
                    break;
                case 7:
                    library.displayLibrarySize();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }
        }
    }
}
