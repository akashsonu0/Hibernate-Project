package in.pwskills.akash.main;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.akash.bean.InsurancePolicy;
import in.pwskills.akash.util.HibernateUtil;

//Nitin -> shahid atm card of canara bank
public class ClientApp2 {
	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			InsurancePolicy policy = session.get(InsurancePolicy.class, 2L, LockMode.UPGRADE_NOWAIT);
			System.out.println(policy);

			policy.setTenure(14);
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
			flag= false;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("object updated...");
			} else {
				transaction.rollback();
				System.out.println("object not updated...");
			}
		}
	}
}
