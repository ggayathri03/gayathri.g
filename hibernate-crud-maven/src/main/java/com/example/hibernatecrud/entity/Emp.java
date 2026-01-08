
package com.example.hibernatecrud.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "employees")
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 100)
    private String title;

    @Column(precision = 12, scale = 2)
    private BigDecimal salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private Dept dept;

    public Emp() {}

    public Emp(String name, String title, BigDecimal salary) {
        this.name = name;
        this.title = title;
        this.salary = salary;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public BigDecimal getSalary() { return salary; }
    public void setSalary(BigDecimal salary) { this.salary = salary; }

    public Dept getDept() { return dept; }
    public void setDept(Dept dept) { this.dept = dept; }


@Override
public String toString() {
    return String.format("Emp{id=%d, name=%s, title=%s, salary=%s}", id, name, title, salary);
}

}
