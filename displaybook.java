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
