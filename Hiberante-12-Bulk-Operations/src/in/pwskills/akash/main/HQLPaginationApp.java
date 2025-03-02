package in.pwskills.akash.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.pwskills.akash.bean.InsurancePolicy;
import in.pwskills.akash.util.HibernateUtil;

public class HQLPaginationApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;
		List<InsurancePolicy> listOfRecords = null;
		Query<InsurancePolicy> query = null;

	  	  try { 
			    session = HibernateUtil.getSession();
				query = session.createQuery("FROM in.pwskills.akash.bean.InsurancePolicy");
				
				// pagination settings
				query.setFirstResult(2);
				query.setMaxResults(3);
				
				//run the query using HQL
				listOfRecords = query.getResultList();
				listOfRecords.forEach(System.out::println);
				
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
