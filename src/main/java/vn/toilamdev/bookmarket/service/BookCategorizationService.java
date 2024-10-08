package vn.toilamdev.bookmarket.service;

import org.springframework.stereotype.Service;

import vn.toilamdev.bookmarket.domain.BookCategorization;
import vn.toilamdev.bookmarket.repository.BookCategorizationRepository;

@Service
public class BookCategorizationService {
    private final BookCategorizationRepository bookCategorizationRepository;

    public BookCategorizationService(BookCategorizationRepository bookCategorizationRepository) {
        this.bookCategorizationRepository = bookCategorizationRepository;
    }

    public BookCategorization saveOrUpdateBookCategorization(BookCategorization bookCategorization) {
        return this.bookCategorizationRepository.save(bookCategorization);
    }
}
