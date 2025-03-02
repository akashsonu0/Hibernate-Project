package in.pwskills.akash.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.pwskills.akash.bean.InsurancePolicy;
import in.pwskills.akash.util.HibernateUtil;

public class RetrieveRecordApp {

	public static void main(String[] args) {
		
		Session session = null;
		InsurancePolicy policy = null;
		try {
			session = HibernateUtil.getSession();
		
			policy = session.get(InsurancePolicy.class,5L);//gets from DB put in L2 and L1
			System.out.println(policy);
			
			System.out.println("--------------------------");
			
			policy = session.get(InsurancePolicy.class,5L); //get from L1
			System.out.println(policy);
			
			session.clear();//clearing L1 cache memory
			
			policy = session.get(InsurancePolicy.class,5L);// get from L2 and keep it in L1 cache
			System.out.println(policy);
			
			session.clear();//clearing L1 cache memory
			
			try {
				Thread.sleep(20000);//20 sec :: removed object from L2 cache
			}catch(Exception e) {
			}
			
			System.out.println("-------------------------");
			policy = session.get(InsurancePolicy.class,5L);// get from DB , keep in L2 and L1 cache
			System.out.println(policy);
			
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
