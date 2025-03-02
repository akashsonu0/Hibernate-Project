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


	@Override
	public void addChildToExistingParent() {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			// got the parent
			Person parent = session.get(Person.class, 1);

			// get the childs of the parent
			Set<PhoneNumber> childs = parent.getNumbers();
			PhoneNumber child = new PhoneNumber();
			child.setMobileNo(666777888L);
			child.setProvider("vi");
			child.setType("office");

			// add extra child
			childs.add(child);
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("New Child added to Existing Parent...");
				} else {
					transaction.rollback();
					System.out.println("Some problem with insertion...");
				}
			}

		}

	}

	@Override
	public void deleteAllChildsOfAParent() {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			// Getting the parent
			Person parent = session.get(Person.class, 1);

			// Getting all the childs of the parent
			Set<PhoneNumber> childs = parent.getNumbers();

			// removing all the childs
			childs.removeAll(childs);

			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("All child records are deleted w.r.t parent");
				} else {
					transaction.rollback();
					System.out.println("Problem in deleting the records of the parent..");
				}
			}

		}

	}
	
	public void deleteOneChildFromCollectionofChildsOfAParent() {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			// Getting the parent
			Person parent = session.get(Person.class, 1);

			// Getting all the childs of the parent
			Set<PhoneNumber> childs = parent.getNumbers();

			PhoneNumber child = session.get(PhoneNumber.class, 3);

			// removing one child
			childs.remove(child);

			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("One child records is deleted w.r.t parent");
				} else {
					transaction.rollback();
					System.out.println("Problem in deleting a Child record of the parent..");
				}
			}

		}

	}

	@Override
	public void deleteParentAndItsChilds() {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			// Getting the parent
			Person parent = session.get(Person.class, 1);
			session.delete(parent);

			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Parent and its child records are deleted ");
				} else {
					transaction.rollback();
					System.out.println("Problem in deleting the records of the parent..");
				}
			}

		}

	}

}

		
	



