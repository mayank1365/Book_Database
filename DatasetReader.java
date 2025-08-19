import java.io.*;
import java.util.*;

public class DatasetReader {

    public static List<Book> readBooksFromCSV(String filePath) {
        List<Book> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            if ((line = br.readLine()) == null) {
                return books;
            }
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 7) {
                    String title = values[0].trim();
                    String author = values[1].trim();
                    double userRating = Double.parseDouble(values[2].trim());
                    int reviews = Integer.parseInt(values[3].trim());
                    double price = Double.parseDouble(values[4].trim());
                    int year = Integer.parseInt(values[5].trim());
                    String genre = values[6].trim();
                    Book book = new Book(title, author, userRating, reviews, price, year, genre);
                    books.add(book);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }
}
