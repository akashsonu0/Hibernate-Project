package in.pwskills.nitin.main;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.nitin.bean.Student;
import in.pwskills.nitin.util.HibernateUtil;

public class DeleteRecordApp {

	public static void main(String[] args) {

		Session session = null;
		Scanner scanner = null;
		Integer sid = null;
		Student student = null;
		Boolean flag = false;
		Transaction transaction = null;
		
		try {
			session = HibernateUtil.getSession();
			scanner = new Scanner(System.in);

			if (session != null && scanner != null) {
				System.out.print("Enter the sid value :: ");
				sid = scanner.nextInt();
				
				student = session.get(Student.class,sid);
			}

				if(student!=null) {
					transaction = session.beginTransaction();
					session.delete(student);
					flag= true;
					
				}else {
					System.out.println("Record not found for deletion");
				}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if(transaction!=null) {
	
			if(flag) {
				transaction.commit();
				System.out.println("Record wit id :: " + sid + " deleted succesfully..." );
			}else {
				transaction.rollback();
				System.out.println("Some problem with deletion....");
			}
	    }
				
			HibernateUtil.closeSessionFactory();
			if (session != null) {
				session.close();
			}
		}
	}
  
}
