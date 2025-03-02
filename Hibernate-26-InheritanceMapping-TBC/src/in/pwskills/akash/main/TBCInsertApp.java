package in.pwskills.akash.main;
import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.akash.bean.CardPayment;
import in.pwskills.akash.bean.ChequePayment;
import in.pwskills.akash.util.HibernateUtil;

public class TBCInsertApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		Boolean flag = false;
		
		try {
			
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			CardPayment cardPayment = new CardPayment();
			cardPayment.setCardNo(1234L);
			cardPayment.setCardType("debit");
			cardPayment.setPaymentGateWay("visa");
			cardPayment.setAmount(8000.0f);

			session.save(cardPayment);
			
			ChequePayment chequePayment = new ChequePayment();
			chequePayment.setAmount(9000.0f);
			chequePayment.setChequeNo(56456L);
			chequePayment.setChequeType("all");
			chequePayment.setExpriyDate(LocalDate.of(2025, 10, 25));
			
			session.save(chequePayment);
			
			flag = true;
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				System.out.println("Record saved to database..");
			}else {
				System.out.println("Record not saved to database...");
			}
			
		}
		
		
	}

}
