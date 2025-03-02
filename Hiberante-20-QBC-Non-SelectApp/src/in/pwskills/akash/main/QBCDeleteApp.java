package in.pwskills.akash.main;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.pwskills.akash.bean.Project;
import in.pwskills.akash.util.HibernateUtil;

public class QBCDeleteApp {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		Boolean flag = false;
		long count =0;
		
	   //
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaDelete<Project> criteriaDelete = builder.createCriteriaDelete(Project.class);
			Root<Project> root = criteriaDelete.from(Project.class);
			
			//update operation
			criteriaDelete.where(builder.between(root.get("cost"),27000 , 45000));
			
			@SuppressWarnings("unchecked")
			Query<Integer> query = session.createQuery(criteriaDelete);
			count = query.executeUpdate();
			flag = true;
			
		}catch(HibernateException he){
			he.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("No of records deleted is :: "+count);
			}else {
				transaction.rollback();
				System.out.println("No records found to deleted");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}
}






 