package cdac.HibernateMapping;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration().configure();
		SessionFactory sf =	cfg.buildSessionFactory();
		Session session  = sf.openSession();
		Transaction tx =   session.beginTransaction();
	   
	   Employee1 emp = new Employee1();
	   emp.setEmpName("Ankit");
	   emp.setEmpMail("ankit@gmail.com");
	  
	   Address  addr  = new Address();
	   addr.setStreet("street no 1");
	   addr.setCity("delhi");
	   addr.setPincode(110032);
	   addr.setEmployee1(emp);
	   
	   emp.setAddress(addr);
	   
	   session.save(emp);
	   tx.commit();
	   session.close();
	   System.out.println("work done...");

	}

}
