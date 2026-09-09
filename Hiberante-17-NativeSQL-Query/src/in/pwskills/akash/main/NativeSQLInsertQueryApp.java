package in.pwskills.akash.main;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import in.pwskills.akash.util.HibernateUtil;

public class NativeSQLInsertQueryApp {

	public static void main(String[] args) {
		
			Session session = null;
			Transaction transaction = null;
			Boolean flag = false;
			long count =0;
		  try { 
			    //Native SQL Query
			    session = HibernateUtil.getSession();
				transaction = session.beginTransaction();
				
				@SuppressWarnings("rawtypes")
				NativeQuery nquery = session.createSQLQuery(
						"insert into insurancepolicy(`company`,`policyName`,`policyType`,`tenure`) values(:comp,:pname,:ptype,:ten)");
				
				//setting value for named parameter
				nquery.setParameter("comp","tata");
				nquery.setParameter("pname","healthVIG");
				nquery.setParameter("ptype","monthly");
				nquery.setParameter("ten","35");

				//Running the query
				count = nquery.executeUpdate();
				flag = true;
				
				
				
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(transaction!=null) {
				if(flag) {
					transaction.commit();
					System.out.println("No of Records inserted are ::" +count);
				}else {
					transaction.rollback();
					System.out.println("Some problem with insertion of records....");
				}
			}

			HibernateUtil.closeSessionFactory();
			if (session != null) {
				session.close();
			}
		}
		
		
	}

}
