
package com.abc.springdi.model;

public class Employee {
    private int id;
    private String name;
    private Department department; // injected via constructor

    // Constructor injection: Spring will resolve Department bean
    public Employee(int id, String name, Department department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    
    public int getId() {
    	return id; 
    	}
    public String getName() { 
    	return name; 
    	}
    public Department getDepartment() { 
    	return department;
    	}

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department=" + department + "}";
    }
}
