package in.pwskills.akash.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.pwskills.akash.bean.Passport;
import in.pwskills.akash.bean.Person;
import in.pwskills.akash.util.HibernateUtil;

public class PassportDaoImpl implements IPassportDao {

	@Override
	public void saveRecordUsingParent() {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			// create a parent object
			Person person = new Person();
			person.setPaddress("hyderabadh");
			person.setPname("cummins");

			// create a child object
			Passport passport = new Passport();
			passport.setCountry("AUS");
			passport.setExprityDate(LocalDate.of(2026, 12, 25));

			// link parent to child
			passport.setPerson(person);

			// link child to parent
			person.setPassport(passport);

			// save parent object
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
					System.out.println("Record saved to database using Parent(Person)...");
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
		// TODO Auto-generated method stub

		Session session = null;

		try {
			session = HibernateUtil.getSession();

			Query<Person> query = session.createQuery("from Person");
			List<Person> records = query.getResultList();
			System.out.println();
			records.forEach(record -> {
				System.out.println(record);
				Passport passport = record.getPassport();
				System.out.println(passport);
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

			// create a parent object
			Person person = new Person();
			person.setPaddress("chennai");
			person.setPname("ravindra");

			// create a child object
			Passport passport = new Passport();
			passport.setCountry("NZ");
			passport.setExprityDate(LocalDate.of(2025, 10, 12));

			// link parent to child
			passport.setPerson(person);

			// link child to parent
			person.setPassport(passport);

			// saving child object
			session.save(passport);

			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Saving record using child(Passport)...");
				} else {
					transaction.rollback();
					System.out.println("Some problem with insertion...");
				}
			}
		}
	}
}
