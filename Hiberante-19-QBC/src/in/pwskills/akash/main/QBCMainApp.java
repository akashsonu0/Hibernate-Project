package in.pwskills.akash.main;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.pwskills.akash.bean.Project;
import in.pwskills.akash.util.HibernateUtil;

public class QBCMainApp {

	public static void main(String[] args) {
		
		Session session = null;
		
		// QBC : HQL : SQL -> select .... from PROJECT_QBC
		
		try {
			session = HibernateUtil.getSession();
			
			//Create a builder object
			CriteriaBuilder builder = session.getCriteriaBuilder();
			
			//Create A CriteriaQuery object
			CriteriaQuery<Project>cQuery = builder.createQuery(Project.class);
			
			//Create a Root object specifying the entity class
			//(Table name from which records should be selected)
			Root<Project> root = cQuery.from(Project.class);
			
			//adding root object to cQuery object
			cQuery.select(root);
			
			//prepare a query object having cQuery
			Query<Project> query = session.createQuery(cQuery);
			
			//execute JPA QBC logic
			List<Project> list = query.getResultList();
			list.forEach(System.out::println);
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtil.closeSession(session);
			
		}
		
		System.out.println("******************************");
		
		//QBC : HQL : SQL -> select... from PROJECT_QBC where >= and <= order by descending

		try {
			session = HibernateUtil.getSession();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Project> cquery = builder.createQuery(Project.class);
			
			Root<Project> root = cquery.from(Project.class);
			cquery.select(root)
				  .where(builder.and
				  		  (builder.ge(root.get("projId"),1L), builder.le(root.get("projId"),3L)))
				  		  .orderBy(builder.desc(root.get("projName")));
			
			Query<Project> query = session.createQuery(cquery);
			List<Project> list = query.getResultList();
			list.forEach(System.out::println);
			
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtil.closeSession(session);
	  }
	  
   
		System.out.println("******************************");
		//select... from project where location in('HYD','PUNE','CHENNAI') order by projName ascending order
	
	
	try {
		session = HibernateUtil.getSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Project> cquery = builder.createQuery(Project.class);
		
		Root<Project> root = cquery.from(Project.class);
		cquery.select(root);//select... from project
		
		root.get("location").in("HYD","BENGALURU","PUNE");
		
		
		cquery.select(root)
			  .where(root.get("location").in("HYD","BENGALURU","PUNE"))
			  .orderBy(builder.asc(root.get("projName")));
		
		Query<Project> query = session.createQuery(cquery);
	
		List<Project> list = query.getResultList();
		list.forEach(System.out::println);
		
		
	}catch(HibernateException he) {
		he.printStackTrace();
	}finally {
		HibernateUtil.closeSession(session);

  }
  
		System.out.println("******************************");
		//select...from project where teamsize between (10,20) and projName like 's%'
		
		
		try {
			session = HibernateUtil.getSession();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Project> cquery = builder.createQuery(Project.class);
			
			Root<Project> root = cquery.from(Project.class);
			cquery.select(root);//select... from project
				
			cquery.select(root)
				  .where(builder.
						  and(builder.between(root.get("teamSize"),10,20),
								  builder.like(root.get("projName"),"s%")));
				  
			Query<Project> query = session.createQuery(cquery);
		
			List<Project> list = query.getResultList();
			list.forEach(System.out::println);
			
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtil.closeSession(session);
	  }
		HibernateUtil.closeSessionFactory();
	}
 } 














 