package com.ieseljust.cepa3;

import com.ieseljust.DAO.*;
import com.ieseljust.Model.*;
import java.util.*;

/**
 * This class represents the main entry point for the CEPA3 program. It includes
 * functionality for managing authors and books through a simple command-line
 * interface. Author: Daniel
 */
public class CEPA3 {

    /**
     * The main method where the program execution begins. It continuously
     * prompts the user for commands until the "exit" command is entered.
     * Commands include displaying authors, displaying authors with their books,
     * adding books, and adding books with authors.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your command ('exit' to quit): ");
            String command = scanner.nextLine();

            if ("exit".equalsIgnoreCase(command)) {
                break;
            } else if ("show Author".equalsIgnoreCase(command)) {
                showAuthors();
            } else if ("show -r Author".equalsIgnoreCase(command)) {
                showAuthorsWithBooks();
            } else if ("add Book".equalsIgnoreCase(command)) {
                addBook(null);
            } else if ("add -r Book".equalsIgnoreCase(command)) {
                addBookWithAuthor();
            } else {
                System.out.println("Invalid command. Try again.");
            }
        }

        System.out.println("Exiting the program.");
    }

    /**
     * Displays a list of authors with their IDs and names.
     */
    private static void showAuthors() {
        AuthorDAO authorDAO = new AuthorDAO();
        List<Author> authors = authorDAO.getAllAuthors();

        for (Author author : authors) {
            System.out.println("Author ID: " + author.getAuthorId() + ", Name: " + author.getAuthorName());
        }
    }

    /**
     * Displays a list of authors with their IDs, names, and associated books.
     */
    private static void showAuthorsWithBooks() {
        AuthorDAO authorDAO = new AuthorDAO();
        List<Author> authorsWithBooks = authorDAO.getAllAuthorsWithBooks();

        for (Author author : authorsWithBooks) {
            System.out.println("Author ID: " + author.getAuthorId() + ", Name: " + author.getAuthorName());
            System.out.println("Books:");

            for (Books book : author.getBooks()) {
                System.out.println("  Book ID: " + book.getBookId() + ", Title: " + book.getBookTitle());
            }
        }
    }

    /**
     * Adds a book with the provided author to the database.
     *
     * @param author The author of the book.
     */
    private static void addBook(Author author) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter book title: ");
        String bookTitle = scanner.nextLine();

        Books book = new Books();
        book.setBookTitle(bookTitle);
        book.setAuthor(author);

        BooksDAO booksDAO = new BooksDAO();
        booksDAO.saveBooks(book);
    }

    /**
     * Prompts the user to select an existing author or create a new one, and
     * then adds a book with the chosen author to the database.
     */
    private static void addBookWithAuthor() {
        Scanner scanner = new Scanner(System.in);

        // Display the list of existing authors
        AuthorDAO authorDAO = new AuthorDAO();
        List<Author> authors = authorDAO.getAllAuthors();
        System.out.println("Authors:");

        for (int i = 0; i < authors.size(); i++) {
            System.out.println(i + 1 + ". " + authors.get(i).getAuthorName());
        }
        System.out.println("0. Create new author");

        // Select an author
        System.out.println("Select author (enter the corresponding number): ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        Author selectedAuthor = null;
        if (choice > 0 && choice <= authors.size()) {
            selectedAuthor = authors.get(choice - 1);
        } else if (choice == 0) {
            // Create a new author
            selectedAuthor = createNewAuthor();
        }

        // Create and save the book with the selected author
        addBook(selectedAuthor);
    }

    /**
     * Creates a new author with user-inputted details, saves it to the
     * database, and also creates and assigns an AuthorDetails object to the
     * author.
     *
     * @return The newly created author.
     */
    private static Author createNewAuthor() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter author name: ");
        String authorName = scanner.nextLine();

        // Ask if the author is alive
        System.out.println("Is the author alive? (true/false): ");
        boolean isAlive = scanner.nextBoolean();
        scanner.nextLine();  // Consume the newline character

        // Create and save the new author
        Author newAuthor = new Author();
        newAuthor.setAuthorName(authorName);

        AuthorDAO authorDAO = new AuthorDAO();
        authorDAO.saveAuthor(newAuthor);

        // Create and assign AuthorDetails
        AuthorDetails authorDetails = new AuthorDetails();
        authorDetails.setAuthor(newAuthor);
        authorDetails.setAlive(isAlive);

        AuthorDetailsDAO authorDetailsDAO = new AuthorDetailsDAO();
        authorDetailsDAO.saveAuthorDetails(authorDetails);

        System.out.println("New author created with ID: " + newAuthor.getAuthorId());
        return newAuthor;
    }

}
