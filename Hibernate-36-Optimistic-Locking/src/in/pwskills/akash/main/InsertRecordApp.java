package in.pwskills.akash.main;

import org.hibernate.Session;

import org.hibernate.Transaction;

import in.pwskills.akash.bean.InsurancePolicy;
import in.pwskills.akash.util.HibernateUtil;

public class InsertRecordApp {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();

		Transaction transaction = session.beginTransaction();
		InsurancePolicy policy = new InsurancePolicy();
		policy.setCompany("PNB");
		policy.setPolicyName("mutualfunds");
		policy.setPolicyType("yearly");
		policy.setTenure(10);
		session.save(policy);
		transaction.commit();
		
	}

}
