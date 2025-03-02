package in.pwskills.akash.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.akash.bean.Product;
import in.pwskills.akash.util.MySQLHibernateUtil;
import in.pwskills.akash.util.OracleHibernateUtil;

public class TransferDaoImpl implements TransferDao {

	@SuppressWarnings("finally")
	@Override
	public String transferProductById(Integer id) {

		Session oracleSession = null, mysqlSession = null;
		Transaction mysqlTransaction = null;
		String status = "";
		boolean flag = false;

		oracleSession = OracleHibernateUtil.getSession();

		// get the record from oracle based on id
		Product product = oracleSession.get(Product.class, id);
		
		if (product != null) {
			// send to MYSQL and perform save operation

			try {
				mysqlSession = MySQLHibernateUtil.getSession();
				mysqlTransaction = mysqlSession.beginTransaction();

				mysqlSession.save(product);
				flag = true;

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (mysqlTransaction != null) {
					if (flag) {
						mysqlTransaction.commit();
						return "record copied from oracle to mysql...";
					} else {
						mysqlTransaction.rollback();
						return "record not copied from oracle to mysql...";
					}

				}
				return null;
			}

		} else {
			status = " record not found";
			return status;
		}

	}

}
