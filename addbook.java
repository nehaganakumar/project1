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
