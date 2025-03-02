package in.pwskills.akash.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.pwskills.akash.bean.LibraryMembership;
import in.pwskills.akash.bean.Student;
import in.pwskills.akash.util.HibernateUtil;

public class LibraryDaoImpl implements ILibraryDao {

	@Override
	public void saveRecordUsingParent() {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			// Create parent object(Student)
			Student student = new Student();
			student.setSname("rajashree");
			student.setSaddress("Chennai");

			// Create a child object(LibraryMembership)
			LibraryMembership library = new LibraryMembership();
			library.setType("silver");
			library.setDate(LocalDate.of(2025, 10, 28));

			// link parent to child
			student.setLibrary(library);

			// link child to parent
			library.setStudent(student);

			// save parent object
			session.save(student);

			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Record saved to database using Parent(Student)...");
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

			Query<Student> query = session.createQuery("from Student");
			List<Student> records = query.getResultList();
			System.out.println();
			records.forEach(row -> {
				System.out.println(row);
				LibraryMembership libraryMembership = row.getLibrary();
				System.out.println(libraryMembership);
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

			// Create parent object(Student)
			Student student = new Student();
			student.setSname("akashsonu");
			student.setSaddress("Bihar");

			// Create a child object(LibraryMembership)
			LibraryMembership library = new LibraryMembership();
			library.setType("gold");
			library.setDate(LocalDate.now());

			// link parent to child
			student.setLibrary(library);

			// link child to parent
			library.setStudent(student);

			// save child object
			session.save(library);

			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Saving record using child(library)...");
				} else {
					transaction.rollback();
					System.out.println("Some problem with insertion...");
				}
			}
		}
	}
}
