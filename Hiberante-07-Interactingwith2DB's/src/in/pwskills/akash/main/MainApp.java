package in.pwskills.akash.main;

import in.pwskills.akash.dao.TransferDao;
import in.pwskills.akash.dao.TransferDaoImpl;

public class MainApp {

	public static void main(String[] args) {

		TransferDao dao = null;
		dao = new TransferDaoImpl();
		System.out.println("status:: "+dao.transferProductById(12));

	}
}
