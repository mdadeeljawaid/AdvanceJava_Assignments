package cdac.HQLExample;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cdac.HibernateOMMapping.*;

public class HQLExample {
	public static void fetchdata(Session session, Transaction tx) {
		// String hql="FROM Books b where b.bookName= :param";
		String hql="FROM Books b where b.bookid > :param order by b.bookid desc ";
		//String hql = "SELECT bobj.bookPublisher from Books  bobj ";
		Query query = session.createQuery(hql);
		query.setParameter("param",101);
		List<Books> list = query.list();
		System.out.println(list);
		
		for(Books q:list) { 
		 System.out.println(q.getBookName());
		 System.out.println(q.getBookid()); 
		 System.out.println(q.getBookPublisher());
		  }
		 

	}
	public static void fetchdata2(Session session, Transaction tx) {
		// count() , sum(), min(),max(),avg()
		String hql="select count(distinct b.bookid) from Books b  ";
		
		Query query = session.createQuery(hql);
		
		List list = query.list();
		System.out.println(list);
		
		

	}

	public static void insertData(Session session, Transaction tx) {
		Books b = new Books();
		b.setBookName("head first java");
		b.setBookPublisher("xyz");
		b.setBookid(102);
		session.save(b); // save is used to insert data
		tx.commit();

	}
	
	public static void insertDataUsingHQL(Session session , Transaction tx) {
		// we can not specify the values explicitly 
		String hql ="insert into Books(bookid ,bookName,bookPublisher)"+
		"select b.bookid+1, b.bookName,b.bookPublisher from Books b where b.bookid=20";
		Query  query=session.createQuery(hql);
		
		int r=query.executeUpdate();
		if(r>0) {
			System.out.println("data is inserted");
		}
		
	}
	
	public static void deleteDataUsingHQL(Session session ,Transaction tx) {
		// we can not specify the values explicitly 
		String hql ="delete Books b where b.bookid=:param";
		Query  query=session.createQuery(hql);
		query.setParameter("param", 20);
		int r=query.executeUpdate();
		if(r>0) {
			System.out.println("data is deleted");
		}
		tx.commit();
		
	}
	
	public static void updateDataUsingHQL(Session session ,Transaction tx) {
		// we can not specify the values explicitly 
		String hql ="update Books b  set b.bookPublisher =:param2 where b.bookid=:param";
		Query  query=session.createQuery(hql);
		query.setParameter("param2", "diamond");
		query.setParameter("param", 21);
		int r=query.executeUpdate();
		if(r>0) {
			System.out.println("data is updated");
		}
		tx.commit();
		
	}

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		Configuration cfg = new Configuration().configure().addAnnotatedClass(cdac.HQLExample.Books.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		// insertData(session, tx);
        System.out.println("1 to fetch using hql");
        System.out.println("2 to insert without hql");
        System.out.println("3 to insert using hql");
        System.out.println("4 to delete using hql");
        System.out.println("5 to update using hql");
        System.out.println("6 to  find number of distinct data using hql");
        int ch=sc.nextInt();
        switch (ch) {
		case 1:
			 fetchdata(session, tx);
			break;
			
		case 2:
			 insertData(session, tx);
			break;

		case 3:
			insertDataUsingHQL(session, tx);
			break;
		case 4:
			deleteDataUsingHQL(session,tx);
			break;
		case 5:
		  updateDataUsingHQL(session, tx);
			break;
		case 6:
			 fetchdata2(session, tx);
				break;


		default:
			break;
		}

	}

}
