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
