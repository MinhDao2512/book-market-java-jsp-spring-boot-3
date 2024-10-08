package vn.toilamdev.bookmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.toilamdev.bookmarket.domain.BookImage;

@Repository
public interface BookImageRepository extends JpaRepository<BookImage, Long> {

}
