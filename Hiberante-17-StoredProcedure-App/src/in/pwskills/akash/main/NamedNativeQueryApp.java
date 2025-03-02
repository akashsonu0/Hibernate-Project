package in.pwskills.akash.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import in.pwskills.akash.bean.Products;
import in.pwskills.akash.util.HibernateUtil;

public class NamedNativeQueryApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		 
		Session session = null;
		
		 try { 
			   session =HibernateUtil.getSession();
				NativeQuery<Products> query = session
						.getNamedNativeQuery("callStoredProcedure");
				
				
				query.setParameter("product1","fossil");
				query.setParameter("product2","tissot");
				
				List<Products> list = query.getResultList();
				list.forEach(System.out::println);
				
						
						
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			HibernateUtil.closeSessionFactory();
			if (session != null) {
				session.close();
			}
		}
		
		
	}
}

