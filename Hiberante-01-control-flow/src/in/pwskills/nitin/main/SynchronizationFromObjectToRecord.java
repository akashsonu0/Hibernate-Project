package in.pwskills.nitin.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.nitin.bean.Student;
import in.pwskills.nitin.util.HibernateUtil;

public class SynchronizationFromObjectToRecord {

	public static void main(String[] args) {
		
		Session session = null;
		Student student = null;
		Boolean flag = false;
		Transaction transaction = null;
		int id =3;
		
		try {
			 session = HibernateUtil.getSession();
			 
			 //Getting the record in the form of student object(session)
			 student = session.get(Student.class, id);
			 System.out.println("Before modification ::" + student);
			 
			 //application in pausing state
			 System.in.read();
			 
			 if (student!=null) {
				 transaction=session.beginTransaction();
				 
				 //modifying the data
				 student.setSname("dravid");
				 flag = true;
				 
			 }else {
				 System.out.print("Record not found foor the id :: "+id);
			 }
				 
			 
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				System.out.println("After modification ::" + student);	
			}else {
				transaction .rollback();
			}
			HibernateUtil.closeSessionFactory();
			if(session !=null) {
				session.close();
			}
			
		}
	}

}
