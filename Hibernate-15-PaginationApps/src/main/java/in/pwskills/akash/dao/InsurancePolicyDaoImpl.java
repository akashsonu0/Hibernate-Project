package in.pwskills.akash.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import in.pwskills.akash.entity.InsurancePolicy;
import in.pwskills.akash.util.HibernateUtil;

public class InsurancePolicyDaoImpl implements InsurancePolicyDao {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public long getTotalRecordsCount() {
		Session session = HibernateUtil.getSession();
		Query query = session.getNamedQuery("GET_POLICIES_COUNT");
		List<Long> list = query.getResultList();
		return list.get(0);
	}

	@Override
	public List<InsurancePolicy> getPageData(int pageSize, int startPos) {
		Session session = HibernateUtil.getSession();
		@SuppressWarnings("rawtypes")
		Query query = session.getNamedQuery("GET_ALL_POLICIES");

		// perform pagination
		query.setFirstResult(startPos);//3
		query.setMaxResults(pageSize);// 3

		@SuppressWarnings("unchecked")
		List<InsurancePolicy> list = query.getResultList();

		return list;
	}

}