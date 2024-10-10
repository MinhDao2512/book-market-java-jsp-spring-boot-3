package vn.toilamdev.bookmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.toilamdev.bookmarket.domain.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    void deleteById(long id);
}
