package vn.toilamdev.bookmarket.service;

import org.springframework.stereotype.Service;

import vn.toilamdev.bookmarket.domain.BookImage;
import vn.toilamdev.bookmarket.repository.BookImageRepository;

@Service
public class BookImageService {
    private final BookImageRepository bookImageRepository;

    public BookImageService(BookImageRepository bookImageRepository) {
        this.bookImageRepository = bookImageRepository;
    }

    public BookImage saveOrUpdateBookImage(BookImage bookImage) {
        return this.bookImageRepository.save(bookImage);
    }

    public void deleteBookImageById(long id) {
        this.bookImageRepository.deleteById(id);
    }
}
