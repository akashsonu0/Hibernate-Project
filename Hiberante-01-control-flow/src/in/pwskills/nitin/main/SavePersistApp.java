package in.pwskills.nitin.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.nitin.bean.Student;
import in.pwskills.nitin.util.HibernateUtil;

public class SavePersistApp {

	public static void main(String[] args) {
		
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {

				Student student = new Student();
				student.setSname("saurav");
				student.setSage(51);
				student.setSaddress("KKR");

				session.persist(student);//insert query :: refering to Mapping  information
				flag = true;

			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (flag) {
					System.in.read();
					transaction.commit();//query executed by DBE and result will be stored in DB 
					System.out.println("Object saved into database....");
				} else {
					transaction.rollback();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (session != null) {
				session.close();
			}	
		}
	}

}
