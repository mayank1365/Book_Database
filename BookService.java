import java.util.*;

public class BookService implements IBookService {
    @Override
    public int countBooksByAuthor(List<Book> books, String author) {
        int count = 0;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Set<String> getAllAuthors(List<Book> books) {
        Set<String> authors = new HashSet<>();
        for (Book book : books) {
            authors.add(book.getAuthor());
        }
        return authors;
    }

    @Override
    public List<String> getBooksByAuthor(List<Book> books, String author) {
        List<String> bookNames = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                bookNames.add(book.getTitle());
            }
        }
        return bookNames;
    }

    @Override
    public List<Book> getBooksByRating(List<Book> books, double rating) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getUserRating() == rating) {
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public List<String> getBookNamesAndPricesByAuthor(List<Book> books, String author) {
        List<String> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book.getTitle() + " - Price: " + book.getPrice());
            }
        }
        return result;
    }
}
