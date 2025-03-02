package in.pwskills.nitin.main;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.nitin.bean.ProgramProjId;
import in.pwskills.nitin.bean.ProgrammerProjectInfo;
import in.pwskills.nitin.util.HibernateUtil;

public class LoadApp {

	public static void main(String[] args) {
		
		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			
			ProgramProjId id = new ProgramProjId();
			id.setPid(100);
			id.setProjId(500);
			
			ProgrammerProjectInfo info = session.get(ProgrammerProjectInfo.class, id);
			if(info!=null) {
				System.out.println(info);
			}else {
				System.out.println("Record not for the id ::" +id);
			}
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			
			HibernateUtil.closeSessionFactory();
			if(session !=null) {
				session.close();
			}	
		}
	 }
  }

