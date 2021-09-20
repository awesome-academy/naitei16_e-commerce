package com.javanaitei.phoneshop.dao;

import com.javanaitei.phoneshop.entity.Order;
import com.javanaitei.phoneshop.model.OrderModel;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface OrderDAO extends GenericDAO<Order, Long>{
    public Page<Order> paginate(OrderModel orderModel, String query, Map<String, Object> params);
}
