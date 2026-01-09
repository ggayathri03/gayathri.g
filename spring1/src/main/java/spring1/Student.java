package spring1;

public class Student {
	 private int id;
	  private String name;
	  private String dept;
	  private int rollno;
	  @Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", dept=" + dept + ", rollno=" + rollno + "]";
	}
	  public int getId() {
		return id;
	}
	  public void setId(int id) {
		  this.id = id;
	  }
	  public String getName() {
		  return name;
	  }
	  public void setName(String name) {
		  this.name = name;
	  }
	  public String getDept() {
		  return dept;
	  }
	  public void setDept(String dept) {
		  this.dept = dept;
	  }
	  public int getRollno() {
		  return rollno;
	  }
	  public void setRollno(int rollno) {
		  this.rollno = rollno;
	  }
	  public Student() {
		  
	  }
	  public Student(int id,String name,String dept,int rollno) {
		  this.id=id;
		  this.name=name;
		  this.dept=dept;
		  this.rollno=rollno;
	  }
}
