package vn.toilamdev.bookmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.toilamdev.bookmarket.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);
}
