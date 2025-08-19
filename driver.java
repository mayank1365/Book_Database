import java.util.*;

public class driver {
    public static void main(String[] args) {
        String filePath = "books.csv";
        List<Book> books = DatasetReader.readBooksFromCSV(filePath);
        IBookService bookService = new BookService();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose a task:");
            System.out.println("1. Total number of books by an author");
            System.out.println("2. All the authors in the dataset");
            System.out.println("3. Names of all the books by an author");
            System.out.println("4. Classify with a user rating");
            System.out.println("5. Price of all the books by an author");
            System.out.println("0. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter author name: ");
                    String author1 = scanner.nextLine();
                    int count = bookService.countBooksByAuthor(books, author1);
                    System.out.println("Total books by " + author1 + ": " + count);
                    break;
                case 2:
                    Set<String> authors = bookService.getAllAuthors(books);
                    System.out.println("Authors in dataset:");
                    for (String a : authors) {
                        System.out.println(a);
                    }
                    break;
                case 3:
                    System.out.print("Enter author name: ");
                    String author2 = scanner.nextLine();
                    List<String> bookNames = bookService.getBooksByAuthor(books, author2);
                    System.out.println("Books by " + author2 + ":");
                    for (String name : bookNames) {
                        System.out.println(name);
                    }
                    break;
                case 4:
                    System.out.print("Enter user rating: ");
                    double rating = scanner.nextDouble();
                    scanner.nextLine();
                    List<Book> ratedBooks = bookService.getBooksByRating(books, rating);
                    System.out.println("Books with rating " + rating + ":");
                    for (Book book : ratedBooks) {
                        System.out.println(book.getTitle() + " by " + book.getAuthor());
                    }
                    break;
                case 5:
                    System.out.print("Enter author name: ");
                    String author3 = scanner.nextLine();
                    List<String> namePriceList = bookService.getBookNamesAndPricesByAuthor(books, author3);
                    System.out.println("Books and prices by " + author3 + ":");
                    for (String entry : namePriceList) {
                        System.out.println(entry);
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
            System.out.println();
        }
    }
}
