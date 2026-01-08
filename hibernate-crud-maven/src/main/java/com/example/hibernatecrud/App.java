
package com.example.hibernatecrud;

import com.example.hibernatecrud.dao.*;
import com.example.hibernatecrud.entity.*;
import com.example.hibernatecrud.util.HibernateUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        CustomerDao customerDao = new CustomerDao();
        OrderDao orderDao = new OrderDao();
        DeptDao deptDao = new DeptDao();
        EmpDao empDao = new EmpDao();

        // === CREATE ===
        Customer alice = new Customer("Alice", "alice@example.com");
        customerDao.save(alice);

        Order o1 = new Order(LocalDate.now(), new BigDecimal("199.99"));
        Order o2 = new Order(LocalDate.now().minusDays(1), new BigDecimal("49.50"));
        // maintain both sides
        alice.addOrder(o1);
        alice.addOrder(o2);
        orderDao.save(o1);
        orderDao.save(o2);

        Dept engineering = new Dept("Engineering");
        deptDao.save(engineering);
        Emp e1 = new Emp("Bob", "Developer", new BigDecimal("80000"));
        Emp e2 = new Emp("Carol", "QA Engineer", new BigDecimal("70000"));
        engineering.addEmp(e1);
        engineering.addEmp(e2);
        empDao.save(e1);
        empDao.save(e2);

        // === READ ===
        System.out.println("All customers:");
        List<Customer> customers = customerDao.findAll();
        customers.forEach(System.out::println);
        System.out.println("All orders:");
        orderDao.findAll().forEach(System.out::println);
        System.out.println("All departments:");
        deptDao.findAll().forEach(System.out::println);
        System.out.println("All employees:");
        empDao.findAll().forEach(System.out::println);

        // === UPDATE ===
        alice.setName("Alice Smith");
        customerDao.update(alice);
        e1.setTitle("Senior Developer");
        empDao.update(e1);
        System.out.println("Updated customer: " + customerDao.findById(alice.getId()));
        System.out.println("Updated employee: " + empDao.findById(e1.getId()));

        // === DELETE ===
        // Delete an order
        orderDao.deleteById(o2.getId());
        System.out.println("Orders after deletion:");
        orderDao.findAll().forEach(System.out::println);

        // Delete employee
        empDao.deleteById(e2.getId());
        System.out.println("Employees after deletion:");
        empDao.findAll().forEach(System.out::println);

        // Cleanup
        HibernateUtil.shutdown();
    }
}
