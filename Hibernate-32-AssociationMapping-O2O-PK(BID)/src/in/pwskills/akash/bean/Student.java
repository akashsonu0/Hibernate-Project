package in.pwskills.akash.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_ONE_ONE_PK_BI")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sno;
	private String sname;
	private String saddress;
	
	
	//one-one mapping
	@OneToOne(targetEntity = LibraryMembership.class,cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name = "lid", referencedColumnName = "sno")
	private LibraryMembership library;
	
	public Student() {
		System.out.println("Student[PARENT] Object is created....");
	}

	public LibraryMembership getLibrary() {
		return library;
	}

	public void setLibrary(LibraryMembership library) {
		this.library = library;
	}

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", saddress=" + saddress + "]";
	}

}
