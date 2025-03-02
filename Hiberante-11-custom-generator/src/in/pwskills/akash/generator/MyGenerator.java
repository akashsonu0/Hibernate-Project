package in.pwskills.akash.generator;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MyGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor si, Object arg1) throws HibernateException {
		
		//logic to generate our own primary key ::
		//c001,....c010....c099....c100....c999
		String id = "";
		try {
		int i= 0;
		Connection connection = si.connection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select id from temp_Table");
		if(resultSet.next())
			i=resultSet.getInt(1);
		if(i<=9)
			id = "c00" +i;
		else if(i>9 && i <=99)
			id ="c0" +i;
		else
			id = "c" +i;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return id;
	}

}
