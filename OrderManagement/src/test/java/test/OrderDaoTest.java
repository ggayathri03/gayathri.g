package test;

import com.orderapp.Order;
import com.orderapp.OrderDao;
import com.orderapp.OrderDaoImpl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderDaoTest {

   OrderDao dao = new OrderDaoImpl();

   // ✅ Positive Test
   @Test
   void testAddOrderSuccess() {
       Order o = new Order();
       o.setCustomerName("Kiki");
       o.setProduct("Laptop");
       o.setQuantity(2);
       o.setPrice(70000);

       assertTrue(dao.addOrder(o));
   }

   // ❌ Negative Test
   @Test
   void testAddOrderFailure() {
       Order o = new Order();
       o.setCustomerName(null); // invalid
       o.setProduct("Phone");

       assertFalse(dao.addOrder(o));
   }

   // ✅ Read Test
   @Test
   void testGetOrders() {
       assertNotNull(dao.getAllOrders());
   }

   // ❌ Delete Negative
   @Test
   void testDeleteInvalidOrder() {
       assertFalse(dao.deleteOrder(9999));
   }
}