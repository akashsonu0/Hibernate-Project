package in.pwskills.akash.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.pwskills.akash.util.HibernateUtil;

public class PersonDaoImpl implements IPersonDao {

	@SuppressWarnings("unchecked")
	@Override
	public void loadRecordUsingJoinsParentToChild() {

		Session session = null;

		try {
			session = HibernateUtil.getSession();

			String  HQL_INNER_JOIN="select per.pid,per.pname,per.paddress,num.regNo,num.mobileNo,num.type,num.provider from Person per  inner join per.numbers num ";
			//String  HQL_LEFT_JOIN="select per.pid,per.pname,per.paddress,num.regNo,num.mobileNo,num.type,num.provider from Person per   left  join per.numbers num ";
			//String  HQL_RIGHT_JOIN="select per.pid,per.pname,per.paddress,num.regNo,num.mobileNo,num.type,num.provider from Person per    right  join per.numbers num ";
			Query<Object[]> query = session.createQuery(HQL_INNER_JOIN);
			List<Object[]> parents = query.getResultList();
			parents.forEach(parent -> {
				for (Object row : parent) {
					System.out.print(row+" ");	
				}
				System.out.println();
			});

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public void loadRecordUsingJoinsChildToParent() {

		Session session = null;

		try {
			session = HibernateUtil.getSession();

			String  HQL_INNER_JOIN="select num.regNo,num.mobileNo,num.type,num.provider, per.pid,per.pname,per.paddress from PhoneNumber num  inner  join  num.person per ";
			//String  HQL_RIGHT_JOIN="select num.regNo,num.mobileNo,num.type,num.provider, per.pid,per.pname,per.paddress from PhoneNumber num  right  join  num.person per ";
			//String  HQL_LEFT_JOIN="select num.regNo,num.mobileNo,num.type,num.provider, per.pid,per.pname,per.paddress from PhoneNumber num   left   join  num.person per ";
			Query<Object[]> query = session.createQuery(HQL_INNER_JOIN);
			List<Object[]> parents = query.getResultList();
			parents.forEach(parent -> {
				for (Object row : parent) {
					System.out.print(row+" ");	
				}
				System.out.println();
			});


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
