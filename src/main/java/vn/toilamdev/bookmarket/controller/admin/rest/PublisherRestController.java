package vn.toilamdev.bookmarket.controller.admin.rest;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
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
    public ResponseEntity<?> createPublisher(@Valid @ModelAttribute Publisher publisher, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        boolean existsPublisher = this.publisherService.existsPublisherByName(publisher.getName());
        if (!existsPublisher) {
            publisher.setCreatedAt(new Date(System.currentTimeMillis()));
            this.publisherService.saveOrUpdatePublisher(publisher);

            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @PutMapping("/publishers/{id}")
    public ResponseEntity<?> updatePublisher(@Valid @ModelAttribute Publisher publisher, BindingResult bindingResult,
            @PathVariable long id) {
        if (bindingResult.hasFieldErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        Publisher currentPublisher = this.publisherService.getPublisherById(id);
        if (currentPublisher != null) {
            currentPublisher.setName(publisher.getName());
            currentPublisher.setAddress(publisher.getAddress());
            currentPublisher.setPhoneNumber(publisher.getPhoneNumber());
            currentPublisher.setWebsite(publisher.getWebsite());
            currentPublisher.setUpdatedAt(new Date(System.currentTimeMillis()));

            this.publisherService.saveOrUpdatePublisher(currentPublisher);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/publishers/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable long id) {
        Publisher currentPublisher = this.publisherService.getPublisherById(id);
        this.publisherService.handleDeletePublisher(currentPublisher);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
