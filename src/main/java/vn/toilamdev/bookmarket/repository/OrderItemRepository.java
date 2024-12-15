package vn.toilamdev.bookmarket.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.toilamdev.bookmarket.domain.Book;
import vn.toilamdev.bookmarket.domain.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    void deleteById(long id);

    int countByBook(Book book);

    @Query("SELECT oi FROM OrderItem oi WHERE oi.book IN :books")
    Page<OrderItem> findByBooks(@Param("books") List<Book> books, Pageable pageable);
}
