package in.pwskills.akash.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.pwskills.akash.bean.Person;
import in.pwskills.akash.bean.PhoneNumber;
import in.pwskills.akash.util.HibernateUtil;

public class PersonDaoImpl implements IPersonDao {
	
	@Override
	public void saveRecordUsingParent() {
	
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			// Creating a parent object
			Person person = new Person();
			person.setPname("sachin");
			person.setPaddress("MI");

			// Creating a child objects
			PhoneNumber number1 = new PhoneNumber();
			number1.setMobileNo(777888999L);
			number1.setProvider("jio");
			number1.setType("personal");

			PhoneNumber number2 = new PhoneNumber();
			number2.setMobileNo(888999777L);
			number2.setProvider("airtel");
			number2.setType("office");

			PhoneNumber number3 = new PhoneNumber();
			number3.setMobileNo(999777888L);
			number3.setProvider("jio");
			number3.setType("personal");

			// linking child objects to parent object
			person.setNumbers(Set.of(number1, number2, number3));
			
			// linking parent objects to child object
			number1.setPerson(person);
			number2.setPerson(person);
			number3.setPerson(person);
			
			// saving parent object
			session.save(person);
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Record saved to database using Parent...");
				} else {
					transaction.rollback();
					System.out.println("Record not saved to database Some Problem...");
				}
			}

		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public void loadRecordUsingParent() {

		Session session = null;

		try {
			session = HibernateUtil.getSession();

			Query<Person> query = session.createQuery("from Person");
			List<Person> parents = query.getResultList();
			parents.forEach(parent -> {
				System.out.println(parent);
				Set<PhoneNumber> childs = parent.getNumbers();
				childs.forEach(child -> System.out.println(child));
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
     
	@SuppressWarnings("unchecked")
	@Override
	public void loadRecordUsingChild() {

		Session session = null;

		try {
			session = HibernateUtil.getSession();

			Query<PhoneNumber> query = session.createQuery("from PhoneNumber");
			List<PhoneNumber> childs = query.getResultList();
			childs.forEach(child -> {
				System.out.println(child);
				Person person = child.getPerson();
				System.out.println(person);
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
	public void saveRecordUsingChild() {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			//creating a child object
			PhoneNumber child1 = new PhoneNumber();
			child1.setMobileNo(666777888L);
			child1.setProvider("vi");
			child1.setType("office");
			
			PhoneNumber child2 = new PhoneNumber();
			child2.setMobileNo(666888999L);
			child2.setProvider("aircel");
			child2.setType("company");
			
			//creating a parent object
			Person person = new Person();
			person.setPaddress("rcb");
			person.setPname("kohli");
			
			//linking parent to child
			child1.setPerson(person);
			child2.setPerson(person);
			
			//linking child to parent
			person.setNumbers(Set.of(child1,child2));
			
			//saving child object
			session.save(child1);
			session.save(child2);
			
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Saving record using child...");
				} else {
					transaction.rollback();
					System.out.println("Some problem with insertion...");
				}
			}

		}

	}
}
