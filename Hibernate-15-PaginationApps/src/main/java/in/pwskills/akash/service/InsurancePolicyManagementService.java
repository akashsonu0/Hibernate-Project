package in.pwskills.akash.service;

import java.util.List;


import in.pwskills.akash.entity.InsurancePolicyDTO;

public interface InsurancePolicyManagementService {
	public long fetchPagesCount(int pageSize);
	public List<InsurancePolicyDTO> fetchPagesData(int pageSize,int pageNo);
	
}
