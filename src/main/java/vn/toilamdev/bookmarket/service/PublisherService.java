package vn.toilamdev.bookmarket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.toilamdev.bookmarket.domain.Book;
import vn.toilamdev.bookmarket.domain.Publisher;
import vn.toilamdev.bookmarket.repository.BookRepository;
import vn.toilamdev.bookmarket.repository.PublisherRepository;

@Service
public class PublisherService {
    private final PublisherRepository publisherRepository;
    private final BookRepository bookRepository;

    public PublisherService(PublisherRepository publisherRepository, BookRepository bookRepository) {
        this.publisherRepository = publisherRepository;
        this.bookRepository = bookRepository;
    }

    public List<Publisher> getAllPublishers() {
        return this.publisherRepository.findAll();
    }

    public Publisher getPublisherByName(String name) {
        return this.publisherRepository.findByName(name);
    }

    public boolean existsPublisherByName(String name) {
        return this.publisherRepository.existsByName(name);
    }

    public Publisher saveOrUpdatePublisher(Publisher publisher) {
        return this.publisherRepository.save(publisher);
    }

    public Publisher getPublisherById(long id) {
        return this.publisherRepository.findById(id);
    }

    public void handleDeletePublisher(Publisher publisher) {
        for (Book book : publisher.getBooks()) {
            book.setPublisher(null);
            this.bookRepository.save(book);
        }

        this.publisherRepository.deleteById(publisher.getId());
    }
}
