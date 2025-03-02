package in.pwskills.akash.main;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.akash.bean.InsurancePolicy;
import in.pwskills.akash.util.HibernateUtil;

//shahid -> using phonephe linked to canara bank
public class ClientApp1 {
	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			InsurancePolicy policy = session.get(InsurancePolicy.class, 2L);
			System.out.println(policy);

			Thread.sleep(20000);// 20 sec sleeping

			// continuing the execution
			policy.setTenure(35);
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object updated...");
			} else {
				System.out.println("object not updated...");
			}
		}

	}
}
