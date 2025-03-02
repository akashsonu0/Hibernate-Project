package in.pwskills.akash.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.pwskills.akash.bean.CardPayment;
import in.pwskills.akash.bean.ChequePayment;
import in.pwskills.akash.bean.Payment;
import in.pwskills.akash.util.HibernateUtil;

public class TBSSelectApp {


    @SuppressWarnings("unchecked")
	public static void main(String[] args) {
        Session session = null;

        try {
           session = HibernateUtil.getSession();
           Query<Payment> query= session.createQuery("from Payment");
           List<Payment>payments = query.getResultList();
           payments.forEach(System.out::println);
           
          System.in.read();
          
          //selecting child classes
           Query<CardPayment> query1= session.createQuery("from CardPayment");
           List<CardPayment>card = query1.getResultList();
           card.forEach(System.out::println);
           
           System.in.read();
           
           //selecting child classes
           Query<ChequePayment> query2= session.createQuery("from ChequePayment");
           List<ChequePayment>cheque = query2.getResultList();
           cheque.forEach(System.out::println);
           
           
           
        } catch (HibernateException he) {
            he.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
            HibernateUtil.closeSessionFactory();
        }
    }
}