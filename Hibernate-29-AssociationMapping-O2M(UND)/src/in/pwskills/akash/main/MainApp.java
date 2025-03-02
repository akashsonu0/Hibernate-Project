package in.pwskills.akash.main;

import in.pwskills.akash.dao.IPersonDao;

import in.pwskills.akash.dao.PersonDaoImpl;

public class MainApp {

	public static void main(String[] args) {

		IPersonDao dao = new PersonDaoImpl();
		dao.deleteAllChildsOfAParent();
	}
}
