package cdac.HibernateMMMapping;



import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(cdac.HibernateMMMapping.MultiQuestion.class);
		cfg.addAnnotatedClass(cdac.HibernateMMMapping.MultiAnswers.class);
		cfg.configure();
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session session   = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		MultiQuestion q1 = new MultiQuestion();
		q1.setQuestionName("what is orm?");
		MultiQuestion q2 = new MultiQuestion();
		q2.setQuestionName("what is jdbc?");
		
		MultiAnswers ans1 = new MultiAnswers();
		ans1.setAnsName("orm is object relation mapping");
		
		MultiAnswers ans2 = new MultiAnswers();
		ans2.setAnsName("orm help in conversion of object into entity");
		
		
		
		MultiAnswers ans3 = new MultiAnswers();
		ans3.setAnsName("jdbc is java data base connectivity");
		
		MultiAnswers ans4 = new MultiAnswers();
		ans4.setAnsName("jdbc is an api for database connection ");
		
		ArrayList<MultiAnswers> ansList1 = new ArrayList<MultiAnswers>();
		ansList1.add(ans1);
		ansList1.add(ans2);
		
		ArrayList<MultiAnswers> ansList2 = new ArrayList<MultiAnswers>();
		ansList2.add(ans3);
		ansList2.add(ans4);
		
		q1.setAnswers(ansList1);
		q2.setAnswers(ansList2);
		
		session.save(q1);
		session.save(q2);
		
		tx.commit();
		
		session.close();
		
		System.out.println(" done ...........");
		
		
		
		

	}

}
