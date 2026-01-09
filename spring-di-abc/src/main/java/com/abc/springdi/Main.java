
package com.abc.springdi;

import com.abc.springdi.config.AppConfig;
import com.abc.springdi.model.Company;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {
            Company company = ctx.getBean(Company.class);
            System.out.println("=== Company Details ===");
            System.out.println("Name: " + company.getName());
            System.out.println("Department: " + company.getDepartment().getName());
            System.out.println("Employees:");
            company.getEmployees().forEach(e ->
                System.out.println(" - " + e.getId() + ": " + e.getName() + " (" + e.getDepartment().getName() + ")")
            );
        }
    }
}
