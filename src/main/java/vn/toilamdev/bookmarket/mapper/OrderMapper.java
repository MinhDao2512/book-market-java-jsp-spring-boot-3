package vn.toilamdev.bookmarket.mapper;

import vn.toilamdev.bookmarket.domain.Order;
import vn.toilamdev.bookmarket.dto.OrderDTO;

public class OrderMapper {
    public static Order mappingOrderDTO(OrderDTO orderDTO) {
        Order order = new Order();
        order.setReceiverName(orderDTO.getReceiverName());
        order.setReceiverEmail(orderDTO.getReceiverEmail());
        order.setShippingAddress(orderDTO.getShippingAddress());
        order.setPhoneNumber(orderDTO.getPhoneNumber());
        order.setPaymentMethod(orderDTO.getPaymentMethod());
        order.setNote(orderDTO.getNote());
        order.setTotalAmount(orderDTO.getTotalAmount());
        return order;
    }
}
