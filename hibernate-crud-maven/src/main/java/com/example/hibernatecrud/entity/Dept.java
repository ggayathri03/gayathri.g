
package com.example.hibernatecrud.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "departments")
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @OneToMany(mappedBy = "dept", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Emp> emps = new LinkedHashSet<>();

    public Dept() {}
    public Dept(String name) { this.name = name; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Set<Emp> getEmps() { return emps; }
    public void setEmps(Set<Emp> emps) { this.emps = emps; }

    public void addEmp(Emp emp) {
        emps.add(emp);
        emp.setDept(this);
    }

    public void removeEmp(Emp emp) {
        emps.remove(emp);
        emp.setDept(null);
    }



@Override
public String toString() {
    return String.format("Dept{id=%d, name=%s}", id, name);
}



}
