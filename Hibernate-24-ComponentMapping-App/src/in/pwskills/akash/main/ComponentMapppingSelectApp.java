package in.pwskills.akash.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.pwskills.akash.bean.Address;
import in.pwskills.akash.bean.StudentInfo;
import in.pwskills.akash.util.HibernateUtil;

public class ComponentMapppingSelectApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = null;
		
		
		try {
			
			session = HibernateUtil.getSession();
			
			Query <StudentInfo> query = session.createQuery("from StudentInfo where address.cityName=:city");
			query.setParameter("city", "BENGALURU");
			List<StudentInfo> students = query.getResultList();
			students.forEach(System.out::println);
			
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
		
	}

}
