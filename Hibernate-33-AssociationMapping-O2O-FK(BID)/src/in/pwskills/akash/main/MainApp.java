package in.pwskills.akash.main;

import in.pwskills.akash.dao.IPassportDao;
import in.pwskills.akash.dao.PassportDaoImpl;

public class MainApp {

	public static void main(String[] args) {

		IPassportDao dao = new PassportDaoImpl();
		dao.loadRecordUsingParent();
	}
}
