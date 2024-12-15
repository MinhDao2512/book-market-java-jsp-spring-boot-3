package vn.toilamdev.bookmarket.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.toilamdev.bookmarket.domain.Book;
import vn.toilamdev.bookmarket.domain.OrderItem;
import vn.toilamdev.bookmarket.repository.OrderItemRepository;

@Service
public class OrderItemService {
    private OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public int getOrderItemCountByBook(Book book) {
        return this.orderItemRepository.countByBook(book);
    }

    public List<OrderItem> getListOrderItemsByBooks(List<Book> books, Pageable pageable) {
        return this.orderItemRepository.findByBooks(books, pageable).getContent();
    }
}
