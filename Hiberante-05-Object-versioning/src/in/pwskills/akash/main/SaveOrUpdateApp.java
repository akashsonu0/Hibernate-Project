package in.pwskills.akash.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.akash.bean.MobileCustomer;
import in.pwskills.akash.util.HibernateUtil;

public class SaveOrUpdateApp {

    public static void main(String[] args) {

        Session session = null;
        Transaction transaction = null;
        Boolean flag = false;
        
       
        try {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();

            MobileCustomer customer = new MobileCustomer();
            customer.setCname("rohith");
            customer.setCallerTune("MI...MI...");
            customer.setMobileNo(99445353334L);
            
            session.saveOrUpdate(customer);           
            flag = true;

        } catch (HibernateException he) {
            he.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (transaction != null) {
                if (flag) {
                    transaction.commit();
                    System.out.println("Record inserted/updated successfully...");
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
