package in.pwskills.nitin.main;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.pwskills.nitin.bean.Student;
import in.pwskills.nitin.util.HibernateUtil;

public class GetRecordApp {

	public static void main(String[] args) {

		Session session = null;
		Scanner scanner = null;
		Student std1 = null;
		Student std2 = null;
		Student std3 = null;
		Student std4 = null;
		Integer sid = null;

		try {
			session = HibernateUtil.getSession();
			scanner = new Scanner(System.in);

			if (session != null && scanner != null) {
				System.out.print("Enter the sid value :: ");
				sid = scanner.nextInt();

				// performing read operation on database
				std1 = session.get(Student.class, sid); // Select Query :: DB to L1 cache
				System.out.println(std1 + " its hashCode value is :: " + std1.hashCode());
				
				// performing read operation on database
				std3 = session.get(Student.class,3);// Select Query :: DB to L1 cache
				System.out.println(std3 + " its hashCode value is :: " + std3.hashCode());
				
				
				System.in.read();
				
				//removing std3 from L1 cache
				session.evict(std3);
				
				// performing read operation on database
				std2 = session.get(Student.class, 3);// Select Query
				System.out.println(std2 + " its hashCode value is :: " + std2.hashCode());


				// performing read operation on database
				std4 = session.get(Student.class, sid);// Select Query
				System.out.println(std4 + " its hashCode value is :: " + std4.hashCode());

			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (session != null) {
				session.close();
			}
		}
	}

}
