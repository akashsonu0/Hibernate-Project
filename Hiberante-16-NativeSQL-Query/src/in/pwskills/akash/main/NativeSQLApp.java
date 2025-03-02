package in.pwskills.akash.main;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import in.pwskills.akash.bean.InsurancePolicy;
import in.pwskills.akash.util.HibernateUtil;

public class NativeSQLApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Session session = null;
			
			
		  try { 
			    session = HibernateUtil.getSession();
				@SuppressWarnings("unchecked")
				
				//Entity Query(Mapped to EntityClass)
				NativeQuery<InsurancePolicy> query = session.createSQLQuery("select * from insurancePolicy where tenure>=:max1 and tenure<=:max2");
				
				//setting the value to named parameter to (max1 and max2)
				query.setParameter("max1", 20);
				query.setParameter("max2", 25);
				
				//mapping the table to Entity class
				query.addEntity(InsurancePolicy.class);
				
				//execute the query and get the Result
				List<InsurancePolicy> list = query.getResultList();
				list.forEach(System.out::println);
				
				
				System.out.println("*************************************");
				 
				 //Entity Query(Not Mapped to EntityClass)
				   
				  @SuppressWarnings("unchecked")
				  NativeQuery<Object[]> query1 = session.createSQLQuery("select * from insurancePolicy where tenure>=:max1 and tenure<=:max2");
				  //setting the value to named parameter to (max1 and max2)
				  query1.setParameter("max1", 20);
				  query1.setParameter("max2", 25);
					
						
				  //execute the query and get the Result
				  List<Object[]> objects = query1.getResultList();
				  objects.forEach(object-> { 
				   for(Object data : object) {
					   System.out.print(data+" ");
					}
					System.out.println();
					});
						
						
						
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
