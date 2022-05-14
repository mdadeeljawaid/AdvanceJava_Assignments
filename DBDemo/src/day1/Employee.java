package day1;

public class Employee{
    // pojo - plain old java object 
   // pojo class must be public
	// pojo class must have a public default constructor 
	// pojo class can have some public getter and setter 
	// pojo can have any access modifier  data member 
	// it should not implement or extend any predefined class or interface
	// it should not have any prespecified annotation

	private String empName;
	private int empId;
   
   public Employee(){

   }
 
   public void setEmpName(String empName){
      this.empName=empName;

   }

   public String getEmpName(){
      return this.empName;
   }
  
   public void setEmpId( int empId){
      this.empId=empId;
   }

   public int getEmpId(){
      return this.empId;
   }
 
  public static void main(String...s){
     Employee  e = new Employee();
     e.setEmpName("Aayush");
     e.setEmpId(101);
     System.out.println("Employee name is"+e.getEmpName());
     System.out.println("Employee Id is"+e.getEmpId());

  }
	

}