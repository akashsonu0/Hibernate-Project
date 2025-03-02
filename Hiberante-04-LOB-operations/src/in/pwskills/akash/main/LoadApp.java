package in.pwskills.akash.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.pwskills.akash.bean.Naukri;
import in.pwskills.akash.util.HibernateUtil;

public class LoadApp {

	public static void main(String[] args) {
		
		Session session = null;
		int id =5;
		
		try {
			session = HibernateUtil.getSession();
			
			Naukri naukri = session.get(Naukri.class, id);
			 if(naukri !=null) {
				 System.out.println("ID   is  :: "+naukri.getId());
				 System.out.println("Name is  :: "+naukri.getName());
				 System.out.println("ADDR is  :: "+naukri.getAddress());
				 
				 String resumeLoc ="D:\\resume.txt";
				 String imageLoc ="D://akash.jpg";
				 try(FileWriter fw = new FileWriter(new File(resumeLoc));
						 FileOutputStream fos = new FileOutputStream(new File(imageLoc))) {
					 
					 fw.write(naukri.getResume());
					 fw.flush();
					 System.out.println("RESUME details in :: " +resumeLoc);
					 
					 System.out.println();
					 fos.write(naukri.getImage());
					 fos.flush();
					 System.out.println("Image details in :: " +imageLoc);
					 
				 }catch(Exception e) {
					 e.printStackTrace();
				 }
				 
			 }else {
				 System.out.println("Record not found for the givenn id ::" +id);
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

