package com.example.bibblan.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public List<BookDTO> getAllBookDTOs() {
        List<Book> books = bookRepository.findAll();
        return bookMapper.toDTOList(books);
    }


}
