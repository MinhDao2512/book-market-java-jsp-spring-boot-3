package vn.toilamdev.bookmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.toilamdev.bookmarket.domain.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    void deleteById(long id);

    Cart findById(long id);

}
