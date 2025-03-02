package in.pwskills.akash.bean;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_INFO")
public class StudentInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sid;
	private String sanme;
	private Float avg;
	
	@Embedded
	private Address address;
	
	public StudentInfo( String sanme, Float avg, Address address) {
		
		this.sanme = sanme;
		this.avg = avg;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "StudentInfo [sid=" + sid + ", sanme=" + sanme + ", avg=" + avg + ", address=" + address + "]";
	}
	
	static {
		System.out.println("StudentInfo.class file is loading....");
	}
	
	
	public StudentInfo() {
		System.out.println("StudentInfo object is created....");
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSanme() {
		return sanme;
	}
	public void setSanme(String sanme) {
		this.sanme = sanme;
	}
	public Float getAvg() {
		return avg;
	}
	public void setAvg(Float avg) {
		this.avg = avg;
	}
	
}
