package in.pwskills.akash.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.pwskills.akash.bean.Person;
import in.pwskills.akash.bean.PhoneNumber;
import in.pwskills.akash.util.HibernateUtil;

public class PersonDaoImpl implements IPersonDao {

	@SuppressWarnings("unchecked")
	@Override
	public void loadRecordUsingHQLJoin() {

		Session session = null;

		try {
			session = HibernateUtil.getSession();

			String HQL_INNER_JOIN = "select per.pid,per.pname,per.paddress,ph.regNo,ph.mobileNo,ph.type,ph.provider from Person per inner join per.numbers ph";
			Query<Object[]> query = session.createQuery(HQL_INNER_JOIN);
			List<Object[]> parents = query.getResultList();
			parents.forEach(parent -> {
				for (Object row : parent) {
					System.out.print(row + " ");
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

	@Override
	public void loadRecordUsingQBCFetchTypeJoin() {
		Session session = null;

		try {
			session = HibernateUtil.getSession();

			CriteriaBuilder builder = session.getCriteriaBuilder();

			// Configuring the parent records
			CriteriaQuery<Person> criteriaQuery = builder.createQuery(Person.class);
			Root<Person> root = criteriaQuery.from(Person.class);

			// getting child objects using join
			root.fetch("numbers", JoinType.INNER);

			Query<Person> query = session.createQuery(criteriaQuery);
			List<Person> parents = query.getResultList();
			parents.forEach(parent -> {
				System.out.println(parent);
				Set<PhoneNumber> childs = parent.getNumbers();
				childs.forEach(System.out::println);
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
