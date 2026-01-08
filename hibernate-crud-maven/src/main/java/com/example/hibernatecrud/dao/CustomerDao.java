
package com.example.hibernatecrud.dao;

import com.example.hibernatecrud.entity.Customer;

public class CustomerDao extends BaseDao<Customer> {
    public CustomerDao() { super(Customer.class); }
}
