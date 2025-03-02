package in.pwskills.akash.main;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import in.pwskills.akash.bean.InsurancePolicy;
import in.pwskills.akash.util.HibernateUtil;

public class NamedNativeSQLQueryApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
			Session session = null;
			
			
			 try { 
				
			    session = HibernateUtil.getSession();
				
				NativeQuery<InsurancePolicy> nquery =  session.getNamedNativeQuery("GET_ALL_POLICIES");
				nquery.addEntity(InsurancePolicy.class);
				
				List<InsurancePolicy> list = nquery.getResultList();
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
