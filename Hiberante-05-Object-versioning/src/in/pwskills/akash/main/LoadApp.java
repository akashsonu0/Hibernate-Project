package in.pwskills.akash.main;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.akash.bean.MobileCustomer;
import in.pwskills.akash.util.HibernateUtil;

public class LoadApp {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		MobileCustomer customer = null;
        Boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
			int id=1;
			customer = session.get(MobileCustomer.class,id);
				
			if (customer !=null) {
				 
				System.out.println(customer);
				transaction = session.beginTransaction();
				customer.setCallerTune("dhoni...dhoni...dhoni..");
				flag = true;
				
			}else {
				System.out.println("Record not found for the id ::" + id);
			}
				
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			
			if (transaction != null) {
                if (flag) {
                    transaction.commit();
                    System.out.println("Record inserted/updated successfully...");
                    System.out.println("object is modified for ::" +customer.getVersionCount() + ": times");
                } else {
                    transaction.rollback();
                    System.out.println("Record failed for updation...");
                }
            }

            HibernateUtil.closeSessionFactory();
            if (session != null) {
                session.close();
            }
        }
		
	 }
  }

