package day1;

//All bean implements Serializable interface but not all pojo implements //Serializabe interface 
//beans are subset of pojo class
//properties are private 
//all beans are pojo but not all pojos are beans 

//pojos dont have any dis advantages but beans have some 

//beans provide complete control on fields
//pojo it is not necessary to have a non argument constructor.it may or may not
//beans must have an no -argument constructor 
//beans can only be accessed by using getter and setter 

import java.io.Serializable;
class StudentBean implements Serializable{
private String sname;
private int rollno;

StudentBean(){

	}
	StudentBean(String sname,int rollno){
	   this.sname=sname;
    this.rollno=rollno;
	}

	public void setSname(String sname){
	  this.sname=sname;
	}

	public void setRollno(int rollno ){
	  this.rollno=rollno;
	}

	public String getSname(){
	  return this.sname;
	}

	public int getRollno(){
	  return this.rollno;
	}
	public static void main(String...st){
	   StudentBean s1 = new StudentBean();
	   s1.setSname("Chintu");
	   s1.setRollno(121);
	   
	   StudentBean s = new StudentBean("Choota Bheem",5);

	   System.out.println("Student 1 name is"+s1.getSname());
	   System.out.println("Student 1 rollno is "+s1.getRollno());

	   System.out.println("Student 2 name is"+s.getSname());
	   System.out.println("Student 2  rollno is "+s.getRollno());



	}
}


