package cdac.Hibernatedemo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class CriterialApiExample {
	@SuppressWarnings("deprecation")
	public static void fetchAllEmployees(Session session,Transaction tx ) {
		// creating critera reference
		
		Criteria criteria = session.createCriteria(Employee.class);
		List<Employee> emplist =criteria.list();
		for(Employee emp:emplist) {
			System.out.println(emp.getEid());
			System.out.println(emp.getEname());
			System.out.println(emp.getEpassword());
			
		}
		
		tx.commit();
	}
	
	@SuppressWarnings("deprecation")
	public static void fetchAllEmployeesOnBasisOfName(Session session,Transaction tx ) {
		// creating critera reference
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.like("ename","A%"));
		List<Employee> emplist =criteria.list();
		System.out.println("Name starting with A");
		for(Employee emp:emplist) {
		
			System.out.println(emp.getEname());
			
			
		}
		
		tx.commit();
	}
	
	public static void fetchAllEmployeesOnBasisOfId(Scanner sc,Session session,Transaction tx ) {
		// creating critera reference
		Criteria criteria = session.createCriteria(Employee.class);
		System.out.println("enter id ");
		int id =sc.nextInt();
		criteria.add(Restrictions.gt("eid",id));
		criteria.add(Restrictions.lt("eid",12));
		List<Employee> emplist =criteria.list();
		System.out.println("detail of employee on basis of id");
		for(Employee emp:emplist) {
		
			System.out.println(emp.getEname());
			
			
		}
		
		tx.commit();
	}
	
	public static void fetchEmployeeDetail(Scanner sc,Session session,Transaction tx ) {
		// creating critera reference
		Criteria criteria = session.createCriteria(Employee.class);
		System.out.println("enter username ");
		String uname =sc.next();
		System.out.println("enter password ");
		String upass =sc.next();
	     criteria.add(Restrictions.and(Restrictions.eq("ename", uname),Restrictions.eq("epassword", upass)));
		
	
		List<Employee> emplist =criteria.list();
		System.out.println("detail of employee on basis of id");
		for(Employee emp:emplist) {
		
			System.out.println(emp.getEname());
			
			
		}
		
		tx.commit();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
          Configuration  config = new Configuration().configure();
          SessionFactory sf =    config.buildSessionFactory();
          Session  session =sf.openSession();
          Transaction tx = session.beginTransaction();
          Scanner  sc = new Scanner(System.in);
	        System.out.println("enter to 1 to fetch all employee list");
	        System.out.println("enter 2 to fetch employee name starting with specific character ");
	        System.out.println("enter 3 to update persistent object");
	        System.out.println("enter 4 to save or  update object");
	        int ch = sc.nextInt();
	        switch (ch) {
			case 1:
				 fetchAllEmployees(session, tx);
				break;
			case 2:
				fetchAllEmployeesOnBasisOfName(session, tx);
				break;
			case 3:
				 fetchAllEmployeesOnBasisOfId(sc, session, tx);
				break;
			case 4:
				fetchEmployeeDetail(sc, session, tx);
				break;
	}

 }
}
