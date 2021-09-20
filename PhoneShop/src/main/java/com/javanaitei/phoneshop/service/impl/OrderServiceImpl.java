package com.javanaitei.phoneshop.service.impl;

import com.javanaitei.phoneshop.dao.OrderDAO;
import com.javanaitei.phoneshop.entity.Order;
import com.javanaitei.phoneshop.model.OrderModel;
import com.javanaitei.phoneshop.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDAO orderDAO;

    @Override
    public OrderModel findOrder(Long id) {
        logger.info("Checking the order in the database");
        try {
            Order order = orderDAO.find(id);
            OrderModel orderModel = null;
            if (order != null) {
                orderModel = new OrderModel();
                BeanUtils.copyProperties(order, orderModel);
            }
            return orderModel;
        } catch (Exception e) {
            logger.error("An error occurred while fetching the tour details from the database", e);
            return null;
        }
    }

    @Override
    public boolean deleteOrder(OrderModel orderModel) throws Exception {
        logger.info("Deleting the order in the database");
        try {
            Order order = orderDAO.find(orderModel.getId(), true);
            orderDAO.makeTransient(order);
            return true;
        } catch (Exception e) {
            logger.error("An error occurred while deleting the tour details to the database", e);
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderModel> findAll(OrderModel orderModel) {
        logger.info("Fetching all orders in the database");
        List<OrderModel> orderModels = new ArrayList<OrderModel>();
        try {
            Order condition = new Order();
            List<Order> orders = orderDAO.findAll();
            for (Order order : orders) {
                OrderModel model = new OrderModel();
                BeanUtils.copyProperties(order, model);
                orderModels.add(model);
            }
        } catch (Exception e) {
            logger.error("An error occurred while fetching all tours from the database", e);
        }
        return orderModels;
    }

    @Override
    public List<OrderModel> findAll() {
        logger.info("Fetching all order in the database");
        List<OrderModel> orderModels = new ArrayList<OrderModel>();
        try {
            List<Order> orders = orderDAO.findAll();
            for (Order order : orders) {
                OrderModel orderModel = new OrderModel();
                BeanUtils.copyProperties(order, orderModel);
                orderModels.add(orderModel);
            }
        } catch (Exception e) {
            logger.error("An error occurred while fetching all tours from the database", e);
        }
        return orderModels;
    }

    @Override
    public Page<OrderModel> paginate(OrderModel orderModel) {
        return null;
    }

    @Override
    public int count(OrderModel orderModel) {
        return 0;
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
}
