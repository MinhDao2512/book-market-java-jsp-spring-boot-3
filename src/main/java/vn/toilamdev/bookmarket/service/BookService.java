package vn.toilamdev.bookmarket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.toilamdev.bookmarket.domain.Book;
import vn.toilamdev.bookmarket.repository.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }
}
