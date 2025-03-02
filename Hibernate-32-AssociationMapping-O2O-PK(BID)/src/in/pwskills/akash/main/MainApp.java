package in.pwskills.akash.main;

import in.pwskills.akash.dao.ILibraryDao;
import in.pwskills.akash.dao.LibraryDaoImpl;

public class MainApp {

	public static void main(String[] args) {

		ILibraryDao dao = new LibraryDaoImpl();
		dao.loadRecordUsingParent();
	}
}
