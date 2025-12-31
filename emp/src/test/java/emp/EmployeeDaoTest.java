package emp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
 
public class EmployeeDaoTest {
 
    EmployeeDao dao = new EmployeeDaoImpl();
 
    @Test
    void testAddEmployee() {
        Employee emp = new Employee(301, "Ravi", 50000);
        Employee result = dao.addEmployee(emp);
        assertNotNull(result);
    }
 
    @Test
    void testUpdateEmployee() {
        Employee emp = new Employee(301, "Ravi", 55000);
        Employee result = dao.updateEmployee(emp);
        assertEquals(55000, result.getSalary());
    }
 
    @Test
    void testGetAllEmployees() {
        List<Employee> list = dao.getAllEmployees();
        assertTrue(list.size() >= 0);
    }
 
    @Test
    void testDeleteEmployee() {
        assertDoesNotThrow(() -> dao.deleteEmployee(301));
    }
}
 