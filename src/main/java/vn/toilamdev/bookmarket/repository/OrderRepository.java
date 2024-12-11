package vn.toilamdev.bookmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.toilamdev.bookmarket.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    void deleteById(long id);

    Order findByPaymentRef(String paymentRef);
}
