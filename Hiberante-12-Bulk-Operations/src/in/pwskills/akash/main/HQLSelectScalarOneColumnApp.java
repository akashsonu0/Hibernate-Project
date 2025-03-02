package in.pwskills.akash.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.pwskills.akash.util.HibernateUtil;

public class HQLSelectScalarOneColumnApp {

    @SuppressWarnings("unchecked")
	public static void main(String[] args) {

        Session session = null;
        Query<Long> query = null;

        try {
            session = HibernateUtil.getSession();
            query=session.createQuery("SELECT policyId FROM in.pwskills.akash.bean.InsurancePolicy where tenure>=:max");
            query.setParameter("max",22);
            List<Long> list= query.getResultList();
            list.forEach(System.out::println);
            
        } catch (HibernateException he) {
            he.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            HibernateUtil.closeSessionFactory();
            if (session != null) {
                session.close();
            }
        }
    }
}