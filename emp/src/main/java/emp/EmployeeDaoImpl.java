package emp;

import java.sql.*;
import java.util.*;
 
public class EmployeeDaoImpl implements EmployeeDao {
 
    private Connection getConnection() throws Exception {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/employeedb",
            "root",
            "root@39"
        );
    }
 
    @Override
    public Employee addEmployee(Employee emp) {
        try (Connection con = getConnection()) {
            PreparedStatement ps =
                con.prepareStatement("INSERT INTO employee VALUES(?,?,?)");
            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getName());
            ps.setDouble(3, emp.getSalary());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return emp;
    }
 
    @Override
    public Employee updateEmployee(Employee emp) {
        try (Connection con = getConnection()) {
            PreparedStatement ps =
                con.prepareStatement(
                    "UPDATE employee SET name=?, salary=? WHERE id=?");
            ps.setString(1, emp.getName());
            ps.setDouble(2, emp.getSalary());
            ps.setInt(3, emp.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return emp;
    }
 
    @Override
    public void deleteEmployee(int id) {
        try (Connection con = getConnection()) {
            PreparedStatement ps =
                con.prepareStatement("DELETE FROM employee WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
 
    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        try (Connection con = getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM employee");
 
            while (rs.next()) {
                list.add(new Employee(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getDouble(3)
                ));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
