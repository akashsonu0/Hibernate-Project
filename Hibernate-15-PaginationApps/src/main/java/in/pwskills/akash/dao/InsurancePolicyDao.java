package in.pwskills.akash.dao;

import java.util.List;

import in.pwskills.akash.entity.InsurancePolicy;

public interface InsurancePolicyDao {
	 
	public long getTotalRecordsCount();
	
	public List<InsurancePolicy> getPageData(int pageSize, int startPos);
}
