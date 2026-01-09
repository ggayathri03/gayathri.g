
package com.abc.springdi.model;

import java.util.List;

public class Company {
    private String name;              // e.g., "ABC"
    private Department department;    // injected via setter
    private List<Employee> employees; // autowired list of Employee beans

    public Company() {}

    public String getName() { return name; }
    public Department getDepartment() { return department; }
    public List<Employee> getEmployees() { return employees; }

    // Setter Injection
    public void setName(String name) { this.name = name; }
    public void setDepartment(Department department) { this.department = department; }

    // Autowiring-Ready Setter (Spring injects all Employee beans into this list)
    public void setEmployees(List<Employee> employees) {
    	this.employees = employees; 
    	}

    @Override
    public String toString() {
        return "Company{name='" + name + "', department=" + department + ", employees=" + employees + "}";
    }
}
