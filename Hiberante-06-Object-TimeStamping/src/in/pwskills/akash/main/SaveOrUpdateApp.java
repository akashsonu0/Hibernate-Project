package in.pwskills.akash.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.pwskills.akash.bean.BankAccount;
import in.pwskills.akash.util.HibernateUtil;

public class SaveOrUpdateApp {

    public static void main(String[] args) {

        Session session = null;
        Transaction transaction = null;
        BankAccount account = null;
        Boolean flag = false;
        
       
        try {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();

            account = new BankAccount();
            account.setBalance(35040403.0);
            account.setHolderName("sachin");
            account.setType("saving");
            
            session.save(account);
            
                     
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
                    
                    System.out.println("Account is opened   on :: " +account.getOpeningDate());
                    System.out.println("Account is modified on :: " +account.getLastUpdate());
                    System.out.println("Account version is     :: " +account.getVersionCount());
            
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
