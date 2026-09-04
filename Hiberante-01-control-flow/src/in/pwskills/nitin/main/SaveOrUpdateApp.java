package in.pwskills.nitin.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.nitin.bean.Student;
import in.pwskills.nitin.util.HibernateUtil;

public class SaveOrUpdateApp {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		Student student = null;
		Integer id= null;
		BufferedReader br = null; 
		String name =null, address=null, age=null;
		Boolean flag = false;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			session = HibernateUtil.getSession();
			if(session !=null && br !=null) {
				System.out.print("Enter the value of id :: ");
				id =Integer.parseInt(br.readLine());
				
				//hitting the database to find the record with respect to id
			    student=session.get(Student.class, id);
			}
			if (student != null) {
				transaction = session.beginTransaction();
				if(transaction != null) {
					
					System.out.println("Record of id ::"+id);
					
					System.out.print("OldName is :: "+student.getSname() +" Enter new Name :: ");
					name = br.readLine();
					if(name.equals("") || name == null) {
						student.setSname(student.getSname());
					}else {
						student.setSname(name);
					}
					
					System.out.print("OldAdress is :: "+student.getSaddress() +" Enter new Address :: ");
					address = br.readLine();
					if(address.equals("") || address == null) {
						student.setSaddress(student.getSaddress());
					}else {
						student.setSaddress(address);
					}
					
					System.out.print("OldAge is :: "+student.getSage() +" Enter new Age :: ");
					age = br.readLine();
					if(age.equals("") || age == null) {
						student.setSage(student.getSage());
					}else {
						student.setSage(Integer.parseInt(age));
					}
						
					//record for the updation with new values along with id present in db
					session.saveOrUpdate(student);
					
					flag = true;	
				}
				
			}else {
				// record not available in database
				student = new Student();
				student.setSid(id);
				student.setSaddress("BRO2");
				student.setSname("Sonu");
				student.setSage(21);
				
				transaction = session.beginTransaction();
				
				//record w.r.t id not found in table, so it performed insert operation
				session.saveOrUpdate(student);
				flag= true;
			}
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			if(flag) {
				transaction.commit();
				System.out.println("Record Updated succesfully...");
			}else {
				transaction.rollback();
				System.out.println("Record failed for Updating...");
			}
			HibernateUtil.closeSessionFactory();
			if(session !=null) {
				session.close();
			}		
		}
	}
}
