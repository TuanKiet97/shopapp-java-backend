package com.project.shopapp.services;

import com.project.shopapp.dtos.OrderDetailDTO;
import com.project.shopapp.exceptions.DataNotFoundException;
import com.project.shopapp.models.OrderDetail;
import java.util.List;

public interface IOderDetailService {
    OrderDetail createOrderDetail (OrderDetailDTO orderDetailDTO)
        throws com.project.shopapp.exceptions.DataNotFoundException;
    OrderDetail getOrderDetail (Long id) throws DataNotFoundException;
    OrderDetail updateOrderDetail(Long id, OrderDetailDTO orderDetailDTO) throws DataNotFoundException;
    void deleteOrderDetail(Long id);
    List<OrderDetail> findByOrderId(Long orderId);

}
