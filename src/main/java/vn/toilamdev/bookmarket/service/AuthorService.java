package vn.toilamdev.bookmarket.service;

import java.util.List;
import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public List<Author> getAllAuthors(Pageable pageable) {
        Page<Author> page = this.authorRepository.findAll(pageable);
        return page.getContent();
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

    public Author handleUpdateAuthor(Author currentAuthor, Author newAuthor) {
        currentAuthor.setName(newAuthor.getName());
        currentAuthor.setBiography(newAuthor.getBiography());
        currentAuthor.setBirthDate(newAuthor.getBirthDate());
        currentAuthor.setNationality(newAuthor.getNationality());
        currentAuthor.setUpdatedAt(new Date(System.currentTimeMillis()));

        currentAuthor = this.authorRepository.save(currentAuthor);

        return currentAuthor;
    }
}
