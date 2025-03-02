package in.pwskills.akash.bean;

import java.io.Serializable;

//JPA Specification
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")

public class Student implements Serializable {
	
	private static final long serialVersionUID =1L;
	
	@Id
	@Column(name ="SID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sid;
	@Column(name ="SNAME",length=20)
	private String sname;
	@Column(name ="SADDRESS",length=20)
	private String saddress;
	@Column(name ="SAGE")
	private Integer sage;
	
	static {
		System.out.println("Student.class file is loading...");
	}
	
	public Student()
	{
		System.out.println("Student OBJECT :: Zero param constructor...");
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
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

	public Integer getSage() {
		return sage;
	}

	public void setSage(Integer sage) {
		this.sage = sage;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + ", sage=" + sage + "]";
	}
		
		
}
