package in.pwskills.akash.bean;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.akash.util.HibernateUtil;

public class InsertRecordApp {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		BankAccount account = new BankAccount();
		account.setBalance(35000.5f);
		account.setHolderName("sachin");
		account.setStatus("active");
		
		
		session.save(account);
		transaction.commit();

	}

}
