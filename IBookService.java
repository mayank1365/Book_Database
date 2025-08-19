import java.util.*;

public interface IBookService {
    int countBooksByAuthor(List<Book> books, String author);

    Set<String> getAllAuthors(List<Book> books);

    List<String> getBooksByAuthor(List<Book> books, String author);

    List<Book> getBooksByRating(List<Book> books, double rating);

    List<String> getBookNamesAndPricesByAuthor(List<Book> books, String author);
}
