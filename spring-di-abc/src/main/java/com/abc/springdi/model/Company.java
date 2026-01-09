
package com.abc.springdi.model;

import java.util.List;

public class Company {
    private String name;            
    private Department department;    
    private List<Employee> employees;

    public Company() {}

    public String getName() { return name; }
    public Department getDepartment() { return department; }
    public List<Employee> getEmployees() { return employees; }

    
    public void setName(String name) { this.name = name; }
    public void setDepartment(Department department) { this.department = department; }

    
    public void setEmployees(List<Employee> employees) {
    	this.employees = employees; 
    	}

    @Override
    public String toString() {
        return "Company{name='" + name + "', department=" + department + ", employees=" + employees + "}";
    }
}
