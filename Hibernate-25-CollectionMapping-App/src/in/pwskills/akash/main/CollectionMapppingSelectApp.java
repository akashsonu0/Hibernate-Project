package in.pwskills.akash.main;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.pwskills.akash.bean.Employee;
import in.pwskills.akash.util.HibernateUtil;

public class CollectionMapppingSelectApp {


    public static void main(String[] args) {
        Session session = null;

        try {
            session = HibernateUtil.getSession();

            Query<Employee> query = session.createQuery("from Employee", Employee.class);
            List<Employee> employees = query.getResultList();
            employees.forEach(employee -> System.out.println(employee));

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