package vn.toilamdev.bookmarket.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.toilamdev.bookmarket.domain.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByName(String name);

    boolean existsByNameAndNationalityAndBirthDate(String name, String nationality, Date birthDate);

    Author findById(long id);

    void deleteById(long id);
}
