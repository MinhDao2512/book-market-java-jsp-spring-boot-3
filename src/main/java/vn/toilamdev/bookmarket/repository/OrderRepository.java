package vn.toilamdev.bookmarket.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.toilamdev.bookmarket.domain.Order;
import vn.toilamdev.bookmarket.domain.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    void deleteById(long id);

    Order findByPaymentRef(String paymentRef);

    Order findById(long id);

    Page<Order> findByUser(User user, Pageable pageable);

    List<Order> findByUser(User user);
}
