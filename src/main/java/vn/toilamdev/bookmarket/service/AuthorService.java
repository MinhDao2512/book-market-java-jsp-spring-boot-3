package vn.toilamdev.bookmarket.service;

import java.util.List;
import java.util.Date;

import org.springframework.stereotype.Service;

import vn.toilamdev.bookmarket.domain.Author;
import vn.toilamdev.bookmarket.repository.AuthorRepository;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return this.authorRepository.findAll();
    }

    public Author saveOrUpdate(Author author) {
        return this.authorRepository.save(author);
    }

    public Author getAuthorByName(String name) {
        return this.authorRepository.findByName(name);
    }

    public Author getAuthorById(long id) {
        return this.authorRepository.findById(id);
    }

    public boolean existsAuthor(String name, String nationality, Date birthDate) {
        return this.authorRepository.existsByNameAndNationalityAndBirthDate(name, nationality, birthDate);
    }

    public void deleteAuthorById(long id) {
        this.authorRepository.deleteById(id);
    }
}
