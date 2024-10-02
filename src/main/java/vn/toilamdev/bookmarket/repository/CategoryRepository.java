package vn.toilamdev.bookmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.toilamdev.bookmarket.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}