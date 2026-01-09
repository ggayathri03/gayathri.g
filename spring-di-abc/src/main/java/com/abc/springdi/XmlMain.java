
package com.abc.springdi;

import com.abc.springdi.model.Company;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlMain {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml")) {
            Company company = ctx.getBean("company", Company.class);
            System.out.println(company);
        }
    }
}
