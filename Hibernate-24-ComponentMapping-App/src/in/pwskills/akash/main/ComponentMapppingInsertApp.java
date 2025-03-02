package in.pwskills.akash.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.akash.bean.Address;
import in.pwskills.akash.bean.StudentInfo;
import in.pwskills.akash.util.HibernateUtil;

public class ComponentMapppingInsertApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		Boolean flag = false;
		
		try {
			
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			Address address = new Address("#2/2", "FoodStreet", "VJYNGR", "BENGALURU","IND", 560026L);
			
			StudentInfo student = new StudentInfo("nitin", 35.5f, address);
			session.save(student);
			flag = true;
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				System.out.println("Record saved to database..");
			}else {
				System.out.println("Record not saved to database...");
			}
			
		}
		
		
	}

}
