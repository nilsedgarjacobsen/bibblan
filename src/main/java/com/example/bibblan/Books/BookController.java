package com.example.bibblan.Books;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/dto")
    public List<BookDTO> getAllBookDTOs(){
        return bookService.getAllBookDTOs();
    }

    @GetMapping("/id/{id}")
    public Optional<Book> getBookById(@PathVariable Integer id){
        return bookService.getBookById(id);
    }

    @GetMapping("/title/{title}")
    public Optional<Book> getBookByTitle(@PathVariable String title){
        return bookService.getBookByTitle(title);
    }

}
