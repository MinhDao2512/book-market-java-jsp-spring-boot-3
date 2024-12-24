package vn.toilamdev.bookmarket.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import vn.toilamdev.bookmarket.domain.Book;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    Book findById(long id);

    void deleteById(long id);

    List<Book> findByCreatedBy(String createdBy);

    Page<Book> findByCreatedBy(String createdBy, Pageable pageable);

    List<Book> findByTitleContaining(String title, Pageable pageable);

    int countByTitleContaining(String title);
}
