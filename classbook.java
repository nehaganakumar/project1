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
