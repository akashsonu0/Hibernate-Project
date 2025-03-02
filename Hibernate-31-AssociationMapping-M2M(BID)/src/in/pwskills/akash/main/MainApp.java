package in.pwskills.akash.main;

import in.pwskills.akash.dao.HospitalDaoImpl;
import in.pwskills.akash.dao.IHospitalDao;

public class MainApp {

	public static void main(String[] args) {

		IHospitalDao dao = new HospitalDaoImpl();
		dao.loadRecordUsingParent();
	}
}
