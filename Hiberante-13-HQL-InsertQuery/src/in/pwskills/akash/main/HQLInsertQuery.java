package in.pwskills.akash.main;

import in.pwskills.akash.dao.InsurancePolicyDao;
import in.pwskills.akash.dao.InsurancePolicyDaoImpl;

public class HQLInsertQuery {

	public static void main(String[] args) {

		InsurancePolicyDao dao = new InsurancePolicyDaoImpl(); 
		System.out.println(dao.transferPolicies(25));
	}

	}
