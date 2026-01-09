package spring1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StuDemo {
  public static void main(String[] args) {
	  BeanFactory bn=new ClassPathXmlApplicationContext("beans.xml");
	  //Employee obj = bn.getBean("emp",Employee.class);
	  Student obj1 = (Student)bn.getBean("stud");
	  System.out.println(obj1);
	  System.out.println("Constructor injection");
	  Student obj2 = bn.getBean("stud1",Student.class);
	  System.out.println(obj2);
  }
}
