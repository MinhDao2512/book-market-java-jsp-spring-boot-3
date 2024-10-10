package vn.toilamdev.bookmarket.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vn.toilamdev.bookmarket.constant.SystemConstant;
import vn.toilamdev.bookmarket.domain.Book;
import vn.toilamdev.bookmarket.domain.BookCategorization;
import vn.toilamdev.bookmarket.domain.BookImage;
import vn.toilamdev.bookmarket.domain.CartItem;
import vn.toilamdev.bookmarket.domain.Category;
import vn.toilamdev.bookmarket.domain.Comment;
import vn.toilamdev.bookmarket.domain.OrderItem;
import vn.toilamdev.bookmarket.repository.BookCategorizationRepository;
import vn.toilamdev.bookmarket.repository.BookImageRepository;
import vn.toilamdev.bookmarket.repository.BookRepository;
import vn.toilamdev.bookmarket.repository.CartItemRepository;
import vn.toilamdev.bookmarket.repository.CategoryRepository;
import vn.toilamdev.bookmarket.repository.CommentRepository;
import vn.toilamdev.bookmarket.repository.OrderItemRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final UploadFileService uploadFileService;
    private final BookImageRepository bookImageRepository;
    private final CategoryRepository categoryRepository;
    private final BookCategorizationRepository bookCategorizationRepository;
    private final CommentRepository commentRepository;
    private final OrderItemRepository orderItemRepository;
    private final CartItemRepository cartItemRepository;

    public BookService(BookRepository bookRepository, UploadFileService uploadFileService,
            BookImageRepository bookImageRepository, CategoryRepository categoryRepository,
            BookCategorizationRepository bookCategorizationRepository, CommentRepository commentRepository,
            CartItemRepository cartItemRepository, OrderItemRepository orderItemRepository) {
        this.bookRepository = bookRepository;
        this.uploadFileService = uploadFileService;
        this.bookImageRepository = bookImageRepository;
        this.categoryRepository = categoryRepository;
        this.bookCategorizationRepository = bookCategorizationRepository;
        this.commentRepository = commentRepository;
        this.orderItemRepository = orderItemRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    public Book saveOrUpdateBook(Book book) {
        return this.bookRepository.save(book);
    }

    public Book getBookById(long id) {
        return this.bookRepository.findById(id);
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

    public List<BookImage> handleUpdateBookImage(List<MultipartFile> bookFiles, Book book) {
        List<BookImage> newBookImages = new ArrayList<>();

        for (BookImage bookImage : book.getBookImages()) {
            this.bookImageRepository.deleteById(bookImage.getId());
        }

        for (int i = 0; i < bookFiles.size(); ++i) {
            if (bookFiles.get(i).getOriginalFilename() != null && bookFiles.get(i).getOriginalFilename() != "") {
                String fileName = uploadFileService.handleSaveFile(bookFiles.get(i), SystemConstant.DIRECTORY_PRODUCT);
                BookImage bookImage = new BookImage();

                bookImage.setBook(book);
                bookImage.setName(fileName);
                bookImage.setOrderImage(i + 1);
                bookImage.setCreatedAt(new Date(System.currentTimeMillis()));

                newBookImages.add(this.bookImageRepository.save(bookImage));
            }
        }
        return newBookImages;
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

    public void handleDeleteBook(Book book) {
        if (book.getBookCategorizations().size() != 0) {
            for (BookCategorization bc : book.getBookCategorizations()) {
                this.bookCategorizationRepository.deleteById(bc.getId());
            }
        }

        if (book.getBookImages().size() != 0) {
            for (BookImage bm : book.getBookImages()) {
                this.bookImageRepository.deleteById(bm.getId());
            }
        }

        if (book.getComments().size() != 0) {
            for (Comment cmt : book.getComments()) {
                this.commentRepository.deleteById(cmt.getId());
            }
        }

        if (book.getCartItems().size() != 0) {
            for (CartItem cartItem : book.getCartItems()) {
                this.cartItemRepository.deleteById(cartItem.getId());
            }
        }

        if (book.getOrderItems().size() != 0) {
            for (OrderItem orderItem : book.getOrderItems()) {
                this.orderItemRepository.deleteById(orderItem.getId());
            }
        }

        this.bookRepository.deleteById(book.getId());
    }
}
