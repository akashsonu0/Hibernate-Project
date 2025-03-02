package in.pwskills.akash.main;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.pwskills.akash.bean.InsurancePolicy;
import in.pwskills.akash.util.HibernateUtil;

public class HQLSelectScalarTestApp {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        Session session = null;
        List<Object[]> listOfRecords = null;
        Query<Object[]> query = null;

        try {
            session = HibernateUtil.getSession();
            query = session.createQuery("SELECT policyId,policyName FROM in.pwskills.akash.bean.InsurancePolicy WHERE policyId=:id");

            // Set named parameter for id
            Long id = 2L;
            query.setParameter("id", id);

            listOfRecords = query.getResultList();
            System.out.println(listOfRecords.size());
            if (!listOfRecords.isEmpty()) {
                // Print the records
                Object[] object = listOfRecords.get(0);
                System.out.println(object[0] + " " + object[1]);

            } else {
                System.out.println("Record not available for the given id ::" + id);
            }

            System.out.println("*********************");

            query = session.createQuery("SELECT count(*) FROM in.pwskills.akash.bean.InsurancePolicy");
            List<?> list = query.getResultList();
            if (!list.isEmpty()) {
                // Print the records
                Long count = (long) list.get(0);
                System.out.println("No of records is :: " + count);
            }

            System.out.println();

            System.out.println("**********************");

            
            Query<InsurancePolicy> entityQuery = session.createQuery("FROM in.pwskills.akash.bean.InsurancePolicy where policyId=:id", InsurancePolicy.class);
            entityQuery.setParameter("id", 4L);
            Optional<InsurancePolicy> optional = entityQuery.uniqueResultOptional();
            if (optional.isPresent()) {
                InsurancePolicy policy = optional.get();
                System.out.println(policy);
            } else {
                System.out.println("Record not available for the given id");
            }

        } catch (HibernateException he) {
            he.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            HibernateUtil.closeSessionFactory();
            if (session != null) {
                session.close();
            }
        }
    }
}