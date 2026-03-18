package in.pwskills.akash.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.pwskills.akash.bean.Student;



public class MainApp {

	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
					
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student();
		student.setSname("Sonu");
		student.setSage(20);
		student.setSaddress("MI");
		
		session.save(student);
		transaction.commit();
		session.close();
		
	}

}
