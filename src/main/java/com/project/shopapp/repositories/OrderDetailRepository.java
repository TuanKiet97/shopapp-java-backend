package com.project.shopapp.repositories;

import com.project.shopapp.models.OrderDetail;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findByOrderId(long orderId);

    OrderDetail findById(long id);
}
