package vn.toilamdev.bookmarket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.toilamdev.bookmarket.domain.Publisher;
import vn.toilamdev.bookmarket.repository.PublisherRepository;

@Service
public class PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> getAllPublishers() {
        return this.publisherRepository.findAll();
    }

    public Publisher getPublisherByName(String name) {
        return this.publisherRepository.findByName(name);
    }
}
