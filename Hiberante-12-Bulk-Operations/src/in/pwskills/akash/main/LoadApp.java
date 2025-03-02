package in.pwskills.akash.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.pwskills.akash.bean.InsurancePolicy;
import in.pwskills.akash.util.HibernateUtil;

public class LoadApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;
		List<InsurancePolicy> listOfRecords = null;
		Query<InsurancePolicy> query = null;

	  	  try { 
			    session = HibernateUtil.getSession();
				query = session.createQuery("FROM in.pwskills.akash.bean.InsurancePolicy");
				listOfRecords = query.getResultList();
				
				System.out.println("\nRetreived using foreach and lambda expression...");
				listOfRecords.forEach(policy  -> System.out.println(policy));
				
				System.out.println();
				System.out.println("Retreived using foreach and method reference...");;
				listOfRecords.forEach(System.out::println);
				
				
				System.out.println("*********************");
				
				System.out.println("Working with Named parameter...");
				query = session.createQuery("FROM in.pwskills.akash.bean.InsurancePolicy WHERE company IN (:org1,:org2)");
				
				//set the named parameter value
				query.setParameter("org1", "HDFC");
				query.setParameter("org2", "SBI");
				
				//execute and retrieve the record
				listOfRecords = query.getResultList();
				
				//print the result
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
