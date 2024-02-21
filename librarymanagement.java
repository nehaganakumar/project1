import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private LocalDateTime addedDateTime;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.addedDateTime = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getAddedDateTime() {
        return addedDateTime;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Added Date & Time: " + addedDateTime;
    }
}

class Library {
    private ArrayList<Book> books;
    private Map<String, ArrayList<Book>> issuedBooks;
    private Map<String, Integer> issuedBooksCount;

    public Library() {
        this.books = new ArrayList<>();
        this.issuedBooks = new HashMap<>();
        this.issuedBooksCount = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void removeBook(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title)) {
                Book removedBook = books.remove(i);
                System.out.println("Book removed successfully.");
                // Update issued books record if book was issued
                for (String user : issuedBooks.keySet()) {
                    ArrayList<Book> userBooks = issuedBooks.get(user);
                    if (userBooks.contains(removedBook)) {
                        userBooks.remove(removedBook);
                        issuedBooks.put(user, userBooks);
                    }
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void issueBook(String user, String title) {
        if (!issuedBooks.containsKey(user)) {
            issuedBooks.put(user, new ArrayList<>());
            issuedBooksCount.put(user, 0);
        }
        if (issuedBooksCount.get(user) >= 5) {
            System.out.println("You have already issued 5 books. Cannot issue more.");
            return;
        }
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                issuedBooks.get(user).add(book);
                issuedBooksCount.put(user, issuedBooksCount.get(user) + 1);
                System.out.println("Book issued successfully to " + user + ".");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(String user, String title) {
        if (!issuedBooks.containsKey(user)) {
            System.out.println("User " + user + " has not issued any books.");
            return;
        }
        ArrayList<Book> userBooks = issuedBooks.get(user);
        for (int i = 0; i < userBooks.size(); i++) {
            if (userBooks.get(i).getTitle().equals(title)) {
                Book returnedBook = userBooks.remove(i);
                System.out.println("Book returned successfully by " + user + ".");
                issuedBooksCount.put(user, issuedBooksCount.get(user) - 1);
                // Add returned book back to the library
                books.add(returnedBook);
                return;
            }
        }
        System.out.println("Book not found in the issued books of " + user + ".");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("Books in the library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayIssuedBooks() {
        if (issuedBooks.isEmpty()) {
            System.out.println("No books have been issued.");
            return;
        }
        System.out.println("Books issued:");
        for (String user : issuedBooks.keySet()) {
            System.out.println("User: " + user);
            ArrayList<Book> userBooks = issuedBooks.get(user);
            for (Book book : userBooks) {
                System.out.println(book.getTitle() + " - Issued on: " + book.getAddedDateTime());
            }
        }
    }

    public void displayLibrarySize() {
        System.out.println("Number of books in the library: " + books.size());
    }
}

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
