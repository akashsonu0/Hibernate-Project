package in.pwskills.akash.util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import in.pwskills.akash.bean.InsurancePolicy;


public class HibernateUtil {

	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	static {
		if (sessionFactory == null) {
			sessionFactory = new Configuration()
							.configure()
							.addAnnotatedClass(InsurancePolicy.class)
							.buildSessionFactory();
		}
	}

	public static Session getSession() {
		if (sessionFactory != null) {
			session = sessionFactory.openSession();
		}
		return session;
	}
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory != null) {
		
		return sessionFactory;
		}
		return sessionFactory;
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
	
	public static void closeSession(Session session) {
		if(session !=null) {
			session.close();
		}
	}
}
