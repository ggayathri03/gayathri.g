
package com.example.hibernatecrud.dao;

import com.example.hibernatecrud.entity.Order;

public class OrderDao extends BaseDao<Order> {
    public OrderDao() { super(Order.class); }
}
