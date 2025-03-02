package in.pwskills.akash.main;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.pwskills.akash.util.HibernateUtil;

public class HQLUpdateQueryApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		long count = 0;

		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			@SuppressWarnings({ "unused", "rawtypes" })
			Query query = session.createQuery("UPDATE in.pwskills.akash.bean.InsurancePolicy SET tenure = tenure+:bonusyears WHERE policyName LIKE :intialLetters ");
			
			//setting the parameter
			query.setParameter("bonusyears", 10);
			query.setParameter("intialLetters","J%");
			
			//execute the query
			count = query.executeUpdate();
			flag = true;
			
		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("No of records updated are :: " + count);
			}else {
				transaction.rollback();
			}

			HibernateUtil.closeSessionFactory();
			if (session != null) {
				session.close();
			}
		}
	}

	}
