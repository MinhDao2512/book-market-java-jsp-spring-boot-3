package vn.toilamdev.bookmarket.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vn.toilamdev.bookmarket.constant.SystemConstant;
import vn.toilamdev.bookmarket.domain.Book;
import vn.toilamdev.bookmarket.domain.BookCategorization;
import vn.toilamdev.bookmarket.domain.BookImage;
import vn.toilamdev.bookmarket.domain.Category;
import vn.toilamdev.bookmarket.repository.BookCategorizationRepository;
import vn.toilamdev.bookmarket.repository.BookImageRepository;
import vn.toilamdev.bookmarket.repository.BookRepository;
import vn.toilamdev.bookmarket.repository.CategoryRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final UploadFileService uploadFileService;
    private final BookImageRepository bookImageRepository;
    private final CategoryRepository categoryRepository;
    private final BookCategorizationRepository bookCategorizationRepository;

    public BookService(BookRepository bookRepository, UploadFileService uploadFileService,
            BookImageRepository bookImageRepository, CategoryRepository categoryRepository,
            BookCategorizationRepository bookCategorizationRepository) {
        this.bookRepository = bookRepository;
        this.uploadFileService = uploadFileService;
        this.bookImageRepository = bookImageRepository;
        this.categoryRepository = categoryRepository;
        this.bookCategorizationRepository = bookCategorizationRepository;
    }

    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    public Book saveOrUpdateBook(Book book) {
        return this.bookRepository.save(book);
    }

    public void handleSaveBookImage(List<MultipartFile> bookFiles, Book book) {
        for (int i = 0; i < bookFiles.size(); ++i) {
            if (bookFiles.get(i).getOriginalFilename() != null && bookFiles.get(i).getOriginalFilename() != "") {
                String fileName = uploadFileService.handleSaveFile(bookFiles.get(i), SystemConstant.DIRECTORY_PRODUCT);
                BookImage bookImage = new BookImage();

                bookImage.setBook(book);
                bookImage.setName(fileName);
                bookImage.setOrderImage(i + 1);
                bookImage.setCreatedAt(new Date(System.currentTimeMillis()));

                this.bookImageRepository.save(bookImage);
            }
        }
    }

    public void handleSaveBookCategorization(List<String> categories, Book book) {
        for (String category : categories) {
            Category currentCategory = this.categoryRepository.findByName(category);
            BookCategorization bookCategorization = new BookCategorization();
            bookCategorization.setCategory(currentCategory);
            bookCategorization.setBook(book);
            bookCategorization.setCreatedAt(new Date(System.currentTimeMillis()));

            this.bookCategorizationRepository.save(bookCategorization);
        }
    }
}
