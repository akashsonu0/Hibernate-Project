package in.pwskills.akash.main;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import in.pwskills.akash.util.HibernateUtil;

public class NativeSQLScalarQueryApp {

	public static void main(String[] args) {
		
			Session session = null;
			
			
		  try { 
			  
			  //scalar Query (specific column)
			  
			    session = HibernateUtil.getSession();
				@SuppressWarnings("unchecked")
				NativeQuery<Object[]> query = session
						.createSQLQuery("select policyId,policyName,company from insurancePolicy where tenure>=:max1 and tenure<=:max2");
				
				
				// setting the value to named parameter(max1 and max2)
				query.setParameter("max1",20);
				query.setParameter("max2",25);
				
				//execute the query and get the Result
				  List<Object[]> list = query.getResultList();
				  list.forEach(object-> { 
				  for(Object row : object) {
					   System.out.print(row+" :: "+row.getClass());
					}
					System.out.println();
					});
				  
				  System.out.println();
				  
				  System.out.println("********************************");
				  
				  // Scalar Query (particular column)
				  
				  @SuppressWarnings("unchecked")
				NativeQuery<String> query1 = session
							.createSQLQuery("select company from insurancePolicy where tenure>=:max1 and tenure<=:max2");
					
					
					// setting the value to named parameter(max1 and max2)
					query1.setParameter("max1",20);
					query1.setParameter("max2",25);
					
					List<String> result = query1.getResultList();
					result.forEach(System.out::println);
					  
				
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
