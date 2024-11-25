package vn.toilamdev.bookmarket.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vn.toilamdev.bookmarket.constant.SystemConstant;
import vn.toilamdev.bookmarket.domain.Author;
import vn.toilamdev.bookmarket.domain.Book;
import vn.toilamdev.bookmarket.domain.BookCategorization;
import vn.toilamdev.bookmarket.domain.BookImage;
import vn.toilamdev.bookmarket.domain.CartItem;
import vn.toilamdev.bookmarket.domain.Category;
import vn.toilamdev.bookmarket.domain.Comment;
import vn.toilamdev.bookmarket.domain.OrderItem;
import vn.toilamdev.bookmarket.domain.Publisher;
import vn.toilamdev.bookmarket.dto.BookDTO;
import vn.toilamdev.bookmarket.mapper.BookMapper;
import vn.toilamdev.bookmarket.repository.AuthorRepository;
import vn.toilamdev.bookmarket.repository.BookCategorizationRepository;
import vn.toilamdev.bookmarket.repository.BookImageRepository;
import vn.toilamdev.bookmarket.repository.BookRepository;
import vn.toilamdev.bookmarket.repository.CartItemRepository;
import vn.toilamdev.bookmarket.repository.CategoryRepository;
import vn.toilamdev.bookmarket.repository.CommentRepository;
import vn.toilamdev.bookmarket.repository.OrderItemRepository;
import vn.toilamdev.bookmarket.repository.PublisherRepository;
import vn.toilamdev.bookmarket.utils.UploadFile;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final UploadFile uploadFileService;
    private final BookImageRepository bookImageRepository;
    private final CategoryRepository categoryRepository;
    private final BookCategorizationRepository bookCategorizationRepository;
    private final CommentRepository commentRepository;
    private final OrderItemRepository orderItemRepository;
    private final CartItemRepository cartItemRepository;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, UploadFile uploadFileService,
            BookImageRepository bookImageRepository, CategoryRepository categoryRepository,
            BookCategorizationRepository bookCategorizationRepository, CommentRepository commentRepository,
            CartItemRepository cartItemRepository, OrderItemRepository orderItemRepository,
            PublisherRepository publisherRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.uploadFileService = uploadFileService;
        this.bookImageRepository = bookImageRepository;
        this.categoryRepository = categoryRepository;
        this.bookCategorizationRepository = bookCategorizationRepository;
        this.commentRepository = commentRepository;
        this.orderItemRepository = orderItemRepository;
        this.cartItemRepository = cartItemRepository;
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    public List<Book> getAllBooks(Pageable pageable) {
        Page<Book> page = this.bookRepository.findAll(pageable);
        return page.getContent();
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

    public void handleCreateBook(BookDTO bookDTO, List<MultipartFile> files) {
        Publisher publisher = this.publisherRepository.findByName(bookDTO.getPublisher());
        Book newBook = new Book();
        newBook = BookMapper.mappingBookDTO(newBook, bookDTO);

        if (bookDTO.getAuthorDefault().equals("OTHER")) {
            Author newAuthor = bookDTO.getNewAuthor();
            newAuthor.setCreatedAt(new Date(System.currentTimeMillis()));
            newAuthor = this.authorRepository.save(newAuthor);

            newBook.setAuthor(newAuthor);
        } else {
            Author newAuthor = this.authorRepository.findByName(bookDTO.getAuthorDefault());
            newBook.setAuthor(newAuthor);
        }
        newBook.setPublisher(publisher);
        newBook.setCreatedAt(new Date(System.currentTimeMillis()));
        // Save Book
        newBook = this.bookRepository.save(newBook);
        // Save BookImage
        this.handleSaveBookImage(files, newBook);
        // Save Category
        this.handleSaveBookCategorization(bookDTO.getCategories(), newBook);
    }

    public void handleUpdateBook(BookDTO bookDTO, Book currentBook, List<MultipartFile> files) {
        currentBook = BookMapper.mappingBookDTO(currentBook, bookDTO);

        // Update Publisher
        if (currentBook.getPublisher() == null
                || !currentBook.getPublisher().getName().equals(bookDTO.getPublisher())) {
            Publisher newPublisher = this.publisherRepository.findByName(bookDTO.getPublisher());
            currentBook.setPublisher(newPublisher);
        }
        // Update BookCategorizations
        List<BookCategorization> bookCategorizations = new ArrayList<>();
        for (BookCategorization bookCate : currentBook.getBookCategorizations()) {
            this.bookCategorizationRepository.deleteById(bookCate.getId());
        }
        for (String category : bookDTO.getCategories()) {
            Category newCategory = this.categoryRepository.findByName(category);

            BookCategorization newBookCategorization = new BookCategorization();
            newBookCategorization.setCategory(newCategory);
            newBookCategorization.setBook(currentBook);

            newBookCategorization = this.bookCategorizationRepository.save(newBookCategorization);
            bookCategorizations.add(newBookCategorization);
        }
        currentBook.setBookCategorizations(bookCategorizations);
        // Update Book Images
        if (files != null && files.get(0).getOriginalFilename() != "") {
            currentBook.setBookImages(this.handleUpdateBookImage(files, currentBook));
        }
        currentBook.setUpdatedAt(new Date(System.currentTimeMillis()));

        this.bookRepository.save(currentBook);
    }
}
