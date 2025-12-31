package emp;

import java.util.List;

public interface EmployeeDao {
 
    Employee addEmployee(Employee emp);
 
    Employee updateEmployee(Employee emp);
 
    void deleteEmployee(int id);
 
    List<Employee> getAllEmployees();
}