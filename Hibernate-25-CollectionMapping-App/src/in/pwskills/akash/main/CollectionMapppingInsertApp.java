package in.pwskills.akash.main;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.akash.bean.Employee;
import in.pwskills.akash.util.HibernateUtil;

public class CollectionMapppingInsertApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		Boolean flag = false;
		
		try {
			
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			Employee employee = new Employee("sachin","MI",
					  List.of("dravid", "saurav", "sehwagh"),
					  Set.of(999888777L, 666555444L, 777888555L), 
					  Map.of ("SBI",55544466L,"HDFC",6575657L,"ICICI",8877799L));
			session.save(employee);
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
