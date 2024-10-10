package vn.toilamdev.bookmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.toilamdev.bookmarket.domain.BookCategorization;

@Repository
public interface BookCategorizationRepository extends JpaRepository<BookCategorization, Long> {
    void deleteById(long id);
}
