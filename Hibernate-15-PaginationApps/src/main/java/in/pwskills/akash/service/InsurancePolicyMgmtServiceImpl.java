package in.pwskills.akash.service;

import java.util.ArrayList;


import java.util.List;

import in.pwskills.akash.entity.InsurancePolicyDTO;
import in.pwskills.akash.dao.InsurancePolicyDao;
import in.pwskills.akash.dao.InsurancePolicyDaoImpl;
import in.pwskills.akash.entity.InsurancePolicy;

public class InsurancePolicyMgmtServiceImpl implements InsurancePolicyManagementService {

	private InsurancePolicyDao dao;

	public InsurancePolicyMgmtServiceImpl() {
		dao = new InsurancePolicyDaoImpl();
	}

	@Override
	public long fetchPagesCount(int pageSize) {
		//get the total no of records
		long recordsCount = dao.getTotalRecordsCount();
		
		//calculate no of pages required
		long pagesCount = recordsCount / pageSize;
		if (recordsCount % pageSize != 0) {
			pagesCount++;
		}
	
		return pagesCount;
	}
	@Override
	public List<InsurancePolicyDTO> fetchPageData(int pageSize, int pageNo) {
		List<InsurancePolicyDTO> listDTO = new ArrayList<InsurancePolicyDTO>();
		List<InsurancePolicy> entities = null;

		// printing the records from starting position to ending position in a page
		int startPos = 0;
		startPos = (pageNo * pageSize) - pageSize;
		entities = dao.getPageData(pageSize, startPos);// 3,3

		// convert from BO to DTO
		entities.forEach(entity -> {

			InsurancePolicyDTO dto = new InsurancePolicyDTO();

			dto.setPolicyId(entity.getPolicyId());
			dto.setPolicyName(entity.getPolicyName());
			dto.setPolicyType(entity.getPolicyType());
			dto.setTenure(entity.getTenure());
			dto.setCompany(entity.getCompany());
			dto.setSerialNo(listDTO.size() + 1);

			// adding to listDTO
			listDTO.add(dto);

		});
		return listDTO;
	}

	@Override
	public List<InsurancePolicyDTO> fetchPagesData(int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return null;
	}
}
