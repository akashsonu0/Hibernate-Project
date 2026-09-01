package in.pwskills.nitin.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.nitin.bean.Student;
import in.pwskills.nitin.util.HibernateUtil;

public class CreateDropPropertiesApp {

	public static void main(String[] args) {

		Session session = null;
		Boolean flag = false;
		Transaction transaction = null;
		
		try {
			session = HibernateUtil.getSession();

			if (session != null ) {
				transaction = session.beginTransaction();
				Student student= new Student();
				student.setSaddress("kohli");
				student.setSaddress("RCB");
				student.setSage(35);
				
				session.saveOrUpdate(student);
				flag= true;
				
			}

				
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
			
			if(transaction!=null) {
	
			if(flag) {
				transaction.commit();
				System.out.println("Record inserted/updated succesfully...");
				
			}else {
				transaction.rollback();
				System.out.println("Some problem with insertion/updation...");
				
			}
		
	    }
				
			System.in.read();
			HibernateUtil.closeSessionFactory();
			if (session != null) {
				session.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	  }
   }
}
