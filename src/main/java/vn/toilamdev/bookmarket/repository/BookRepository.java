package vn.toilamdev.bookmarket.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.toilamdev.bookmarket.domain.Book;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findById(long id);

    void deleteById(long id);

    List<Book> findByCreatedBy(String createdBy);

    Page<Book> findByCreatedBy(String createdBy, Pageable pageable);
}
