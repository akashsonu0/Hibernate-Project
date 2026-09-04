package in.pwskills.akash.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.akash.util.HibernateUtil;
import in.pwskills.akash.bean.Student;

public class MainApp {

	public static void main(String[] args) {
		
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
			if(session != null)
				transaction = session.beginTransaction();
			
			if(transaction != null) {
				Student student = new Student();
				student.setSname("dravid");
				student.setSage(51);
				student.setSaddress("RCB");
				
				session.save(student);
				flag = true;
				
			}
			
		} catch(HibernateException he) {
			he.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(flag) {
					
					System.in.read();
					transaction.commit();
					System.out.println("Object saved in db...");
				} else {
					transaction.rollback();
				}
				}catch(Exception e) {
					e.printStackTrace();
				}
			if(session != null) {
				session.close();
			}
		
			
			
		}
		
	

     }
}
