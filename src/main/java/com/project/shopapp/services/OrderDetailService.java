package com.project.shopapp.services;

import com.project.shopapp.dtos.OrderDetailDTO;
import com.project.shopapp.exceptions.DataNotFoundException;
import com.project.shopapp.models.Order;
import com.project.shopapp.models.OrderDetail;
import com.project.shopapp.models.Product;
import com.project.shopapp.repositories.OrderDetailRepository;
import com.project.shopapp.repositories.OrderRepository;
import com.project.shopapp.repositories.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderDetailService implements IOderDetailService{
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderDetailRepository orderDetailRepository;


    @Override
    public OrderDetail createOrderDetail(OrderDetailDTO orderDetailDTO) throws DataNotFoundException {
        Order order = orderRepository.findById(orderDetailDTO.getOrderId())
            .orElseThrow(()-> new DataNotFoundException("Order not found"));

        Product product = productRepository.findById(orderDetailDTO.getOrderId())
            .orElseThrow(()-> new DataNotFoundException("Product not found"));
        OrderDetail orderDetail = new OrderDetail().builder()
            .order(order)
            .product(product)
            .numberOfProducts(orderDetailDTO.getNumberOfProducts())
            .price(orderDetailDTO.getPrice())
            .totalMoney(orderDetailDTO.getTotalMoney())
            .color(orderDetailDTO.getColor())
            .build();
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public OrderDetail getOrderDetail(Long id) throws DataNotFoundException {
        return orderDetailRepository.findById(id).orElseThrow(()-> new DataNotFoundException("Can not find OrderDetail with Id: "+ id));

    }

    @Override
    public OrderDetail updateOrderDetail(Long id, OrderDetailDTO orderDetailDTO)
        throws DataNotFoundException {
        OrderDetail existingOrderDetail = orderDetailRepository.findById(id)
            .orElseThrow(() -> new DataNotFoundException("Can not find OrderDetail with id"));

        Order existingOrder = orderRepository.findById(orderDetailDTO.getOrderId())
            .orElseThrow(()-> new DataNotFoundException("Can not find Order with id"));

        Product exitingProduct = productRepository.findById(orderDetailDTO.getOrderId())
            .orElseThrow(()-> new DataNotFoundException("Product not found with id"));

        existingOrderDetail.setPrice(orderDetailDTO.getPrice());
        existingOrderDetail.setNumberOfProducts(orderDetailDTO.getNumberOfProducts());
        existingOrderDetail.setTotalMoney(orderDetailDTO.getTotalMoney());
        existingOrderDetail.setColor(orderDetailDTO.getColor());
        existingOrderDetail.setOrder(existingOrder);
        existingOrderDetail.setProduct(exitingProduct);
        return orderDetailRepository.save(existingOrderDetail);
    }

    @Override
    public void deleteOrderDetail(Long id) {
        orderDetailRepository.deleteById(id);
    }

    @Override
    public List<OrderDetail> findByOrderId(Long orderId) {
        return orderDetailRepository.findByOrderId(orderId);
    }
}
