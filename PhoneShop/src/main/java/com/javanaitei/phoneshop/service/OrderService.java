package com.javanaitei.phoneshop.service;

import com.javanaitei.phoneshop.model.OrderModel;
import com.javanaitei.phoneshop.model.ProductModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderService {
    public OrderModel findOrder(Long id);

    public boolean deleteOrder(OrderModel orderModel) throws Exception;

    public List<OrderModel> findAll(OrderModel orderModel);

    public List<OrderModel> findAll();

    public Page<OrderModel> paginate(OrderModel orderModel);

    public int count(OrderModel orderModel);
}
