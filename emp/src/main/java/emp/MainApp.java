package emp;
import java.util.*;

public class MainApp {
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        EmployeeDao dao = new EmployeeDaoImpl();
 
        while (true) {
            System.out.println("\n1.Add 2.Update 3.Delete 4.View All 5.Exit");
            int choice = sc.nextInt();
 
            switch (choice) {
 
                case 1:
                    System.out.print("Id Name Salary: ");
                    dao.addEmployee(
                        new Employee(sc.nextInt(), sc.next(), sc.nextDouble()));
                    break;
 
                case 2:
                    System.out.print("Id Name Salary: ");
                    dao.updateEmployee(
                        new Employee(sc.nextInt(), sc.next(), sc.nextDouble()));
                    break;
 
                case 3:
                    System.out.print("Id: ");
                    dao.deleteEmployee(sc.nextInt());
                    break;
 
                case 4:
                    dao.getAllEmployees().forEach(System.out::println);
                    break;
 
                case 5:
                    System.exit(0);
            }
        }
    }
}