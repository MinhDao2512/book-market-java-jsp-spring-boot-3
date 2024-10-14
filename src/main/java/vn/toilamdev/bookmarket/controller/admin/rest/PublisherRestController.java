package vn.toilamdev.bookmarket.controller.admin.rest;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.toilamdev.bookmarket.domain.Publisher;
import vn.toilamdev.bookmarket.service.PublisherService;

@RestController
@RequestMapping("/api/admin")
public class PublisherRestController {
    private final PublisherService publisherService;

    public PublisherRestController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping("/publishers")
    public ResponseEntity<Void> createPublisher(@ModelAttribute Publisher publisher) {
        boolean existsPublisher = this.publisherService.existsPublisherByName(publisher.getName());
        if (!existsPublisher) {
            publisher.setCreatedAt(new Date(System.currentTimeMillis()));
            this.publisherService.saveOrUpdatePublisher(publisher);

            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }

    @PutMapping("/publishers/{id}")
    public ResponseEntity<Void> updatePublisher(@ModelAttribute Publisher publisher, @PathVariable long id) {
        Publisher currentPublisher = this.publisherService.getPublisherById(id);
        currentPublisher.setAddress(publisher.getAddress());
        currentPublisher.setPhoneNumber(publisher.getPhoneNumber());
        currentPublisher.setWebsite(publisher.getWebsite());
        currentPublisher.setUpdatedAt(new Date(System.currentTimeMillis()));

        this.publisherService.saveOrUpdatePublisher(currentPublisher);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping("/publishers/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable long id) {
        Publisher currentPublisher = this.publisherService.getPublisherById(id);
        this.publisherService.handleDeletePublisher(currentPublisher);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
