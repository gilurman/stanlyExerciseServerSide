package book.Services;

import book.models.Book;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

@Service
public class BookService {

    ArrayList<Book> allBooks = new ArrayList<Book>();
    ReentrantLock lock = new ReentrantLock();

    public BookService() {

        allBooks.add(new Book(new ObjectId().toString(), "harry", "potter", 4));
        allBooks.add(new Book(new ObjectId().toString(), "harry2", "potter", 2));
        allBooks.add(new Book(new ObjectId().toString(), "harry3", "potter", 0));
        allBooks.add(new Book(new ObjectId().toString(), "harry4", "potter", 1));
        allBooks.add(new Book(new ObjectId().toString(), "harry5", "potter", 2));
        allBooks.add(new Book(new ObjectId().toString(), "harry6", "potter", 3));
        allBooks.add(new Book(new ObjectId().toString(), "harry", "potter", 5));

    }

    public List<Book> findAll() {
        return allBooks;
    }

    public Book save(Book b) {
        b.setId(new ObjectId().toString());
        allBooks.add(b);
        return b;
    }

    public int buyBook(String id) throws Exception {

        if (lock.tryLock()) {
            try {
                Book currentBook = allBooks.stream().filter(book -> id.equals(book.getId())).collect(Collectors.toList()).get(0);
                if (currentBook.getQuantity() > 0) {
                    int index = allBooks.indexOf(currentBook);
                    currentBook.setQuantity(currentBook.getQuantity() - 1);
                    allBooks.set(index, currentBook);
                    return currentBook.getQuantity();

                } else {
                    throw new Exception("out of stock");
                }

            } catch (Exception e) {
                throw e;
            } finally {
                lock.unlock();
            }
        }
        return 0;
    }
}