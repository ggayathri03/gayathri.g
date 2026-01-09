
package com.abc.springdi.config;

import com.abc.springdi.model.Company;
import com.abc.springdi.model.Department;
import com.abc.springdi.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {

    
    @Bean
    public Department department() {
        return new Department("Engineering"); 
    }

    
    @Bean(name = "John")
    public Employee empJohn(Department department) {
        return new Employee(1, "John", department);
    }

    @Bean(name = "Jane")
    public Employee empJane(Department department) {
        return new Employee(2, "Jane", department);
    }

    
    @Bean
    public Company company(List<Employee> employees, Department department) {
        Company company = new Company();
        company.setName("ABC");                 
        company.setDepartment(department);    
        company.setEmployees(employees);        
        return company;
    }
}
