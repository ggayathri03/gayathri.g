
package com.abc.springdi.model;

public class Department {
    private String name;

    // Constructor injection-friendly
    public Department(String name) {
        this.name = name;
    }

   
    public Department() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Department{name='" + name + "'}";
    }
}
