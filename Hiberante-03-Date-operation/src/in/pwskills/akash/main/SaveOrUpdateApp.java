package in.pwskills.akash.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.akash.bean.PersonInfo;
import in.pwskills.akash.util.HibernateUtil;

public class SaveOrUpdateApp {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		Boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			PersonInfo info = new PersonInfo();
			info.setPaddr("CSK");
			info.setPname("dhoni");
			
			//year   :: 1900 +
			//month  :: 1 to 12
			//date   :: 1 to 31
			//hours  :: 0 to 23
			//minute :: 0 to 59
			//second :: 0 to 59
			info.setDob(LocalDateTime.of(1996, 2, 24, 13, 45));
			info.setDoj(LocalTime.of(8, 40, 54));
			info.setDom(LocalDate.of(2021, 10, 30));
			
			session.saveOrUpdate(info);
			
			flag = true;
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			if(transaction!=null) {
			if(flag) {
				transaction.commit();
				System.out.println("Record inserted/updated succesfully...");
			}else {
				transaction.rollback();
				System.out.println("Record failed for updation...");
			}
			
			HibernateUtil.closeSessionFactory();
			if(session !=null) {
				session.close();
			}	
		}
	 }
  }
}
