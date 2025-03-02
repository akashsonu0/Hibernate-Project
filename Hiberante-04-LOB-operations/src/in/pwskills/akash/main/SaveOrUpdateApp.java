package in.pwskills.akash.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.akash.bean.Naukri;
import in.pwskills.akash.util.HibernateUtil;

public class SaveOrUpdateApp {

    public static void main(String[] args) {

        Session session = null;
        Transaction transaction = null;
        Boolean flag = false;
        byte[] image = null;
        char[] resume = null;
        FileInputStream fis = null;
        BufferedReader br = null;

        try {

            // Reading image data
            fis = new FileInputStream("D://akash.jpg");
            int size = fis.available();
            image = new byte[size];
            fis.read(image); // Add this line to actually read the image data into the byte array

            // Reading resume data
            File resumeFile = new File("D:\\resume.txt"); // Provide the correct file path
            br = new BufferedReader(new FileReader(resumeFile));
            resume = new char[(int) resumeFile.length()]; // Allocate the correct size for the char array
            br.read(resume);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();

            Naukri naukri = new Naukri();
            naukri.setAddress("bengaluru");
            naukri.setName("akash");
            naukri.setImage(image);
            naukri.setResume(resume);

            session.saveOrUpdate(naukri);
            flag = true;

        } catch (HibernateException he) {
            he.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (transaction != null) {
                if (flag) {
                    transaction.commit();
                    System.out.println("Record inserted/updated successfully...");
                } else {
                    transaction.rollback();
                    System.out.println("Record failed for updation...");
                }
            }

            HibernateUtil.closeSessionFactory();
            if (session != null) {
                session.close();
            }
        }
    }
}
