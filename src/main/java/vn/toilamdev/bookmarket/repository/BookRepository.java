package vn.toilamdev.bookmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.toilamdev.bookmarket.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findById(long id);

    void deleteById(long id);
}
