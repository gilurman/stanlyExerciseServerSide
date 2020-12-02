package book.Controllers;

import book.Services.BookService;
import book.models.Book;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/book")
@RestController
public class BookController {

    @Autowired
    BookService service;

    @GetMapping
    public List<Book> getAll() {
        Book b = new Book(new ObjectId().toString(), "harry", "potter", 4);
        Book y = new Book(new ObjectId().toString(), "harry", "potter", 0);
        ArrayList arr  = new ArrayList<Book>();
        arr.add(b);
        arr.add(b);
        arr.add(y);
        arr.add(b);
        return service.findAll();
    }

    @PostMapping
    public Book saveBook(@RequestBody Book newBook)
    {
       return service.save(newBook);
    }

    @PutMapping
    public int buyBook(@RequestBody String id) throws Exception {
        return service.buyBook(id);
    }
}
