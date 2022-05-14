package cdac.Hibernatedemo;

import java.util.ArrayList;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void insertData(Session session , Transaction tx) {
		    Employee emp = new Employee();
	        emp.setEname("Aman");
	        emp.setEpassword("12356");
	        session.save(emp);  // save is used to insert data 
	        tx.commit();
		
	}
	// delete a transient object
	public static void deleteData( Scanner sc,Session session , Transaction tx) {
	   System.out.println("Enter id ");
		int id =sc.nextInt();
		Employee emp = new Employee();
		emp.setEid(id);
		session.delete(emp); // is used to delete given object
		tx.commit();
	
}
	  // delete persistent object
	public static void deleteEmployee (Scanner sc,Session session , Transaction tx)
    {
    	  System.out.println("Enter id ");
  		   int id =sc.nextInt();
  		   Employee emp=session.get(Employee.class,id);
  		   if(emp!=null) {
  			   session.remove(emp);
  			   System.out.println("customer is removed");
  		   }else {
  			  System.err.println("no employee found"); 
  		   }
  		   tx.commit();
		
	}
	public static void addEmployees(Scanner sc,Session session , Transaction tx) {
		System.out.println("enter number of employee to add");
        int no=sc.nextInt();
        ArrayList<Employee> emplist = new ArrayList<Employee>();
        for (int i =0;i<no;i++) {
        	Employee emp = new Employee();
        	System.out.println("enter name of employee");
        	String ename =sc.next();
        	System.out.println("enter pasword");
        	String epass =sc.next();
        	emp.setEname(ename);
        	emp.setEpassword(epass);
        	emplist.add(emp);
        	
        }
       for(Employee emp:emplist) {
    	   session.save(emp);
       }
        tx.commit();
	}
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
       
        //Configure() Use the mappings and properties specified in an application resource named hibernate.cfg.xml.
        Configuration cfg = new Configuration().configure();
        // Mapping pojo class without mapping it in hibernate.cfg.xml
        //Configuration cfg = new Configuration().configure().addAnnotatedClass(cdac.Hibernatedemo.Employee.class);
       
        SessionFactory sf =cfg.buildSessionFactory();
        Session session =sf.openSession();
        Transaction  tx = session.beginTransaction();
        Scanner  sc = new Scanner(System.in);
        System.out.println("enter to 1 to insert");
        System.out.println("enter 2 to delete");
        System.out.println("enter 3 to delete persistent object");
        int ch = sc.nextInt();
        switch (ch) {
		case 1:
			  insertData(session, tx);
			break;
		case 2:
			  deleteData(sc, session, tx);
			break;
		case 3:
			 deleteEmployee(sc, session, tx);
			break;
		case 4:
			addEmployees(sc, session, tx);
			break;

		default:
			break;
		}
        
        
     
       
    }
}
