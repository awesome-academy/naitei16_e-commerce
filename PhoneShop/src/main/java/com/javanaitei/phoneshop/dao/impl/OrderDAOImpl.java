package com.javanaitei.phoneshop.dao.impl;

import com.javanaitei.phoneshop.dao.OrderDAO;
import com.javanaitei.phoneshop.entity.Order;
import com.javanaitei.phoneshop.model.OrderModel;
import com.javanaitei.phoneshop.util.SearchQueryTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.Map;

public class OrderDAOImpl extends GenericDAOImpl<Order, Long> implements OrderDAO {
    private static final Logger logger = LoggerFactory.getLogger(OrderDAOImpl.class);

    public OrderDAOImpl() {
        super(Order.class);
    }

    @Override
    public Page<Order> paginate(OrderModel orderModel, String query, Map<String, Object> params) {
        String sql = query;
        String countSql = "SELECT COUNT(*) " + sql;
        SearchQueryTemplate searchQueryTemplate = new SearchQueryTemplate(sql, countSql, orderModel.getPageable());
        searchQueryTemplate.addParameters(params);
        searchQueryTemplate.addOrder(Sort.Direction.DESC, "createTime");
        return paginate(searchQueryTemplate);
    }
}
