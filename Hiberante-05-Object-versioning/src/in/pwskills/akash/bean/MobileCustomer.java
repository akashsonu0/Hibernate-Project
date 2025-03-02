package in.pwskills.akash.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;



@Entity
@Table(name="MOBILE_CUSTOMER")
public class MobileCustomer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cno;
	
	@Column(name="cname",length=20)
	private String cname;
	
	@Column(name="mobile")
	private long mobileNo;
	
	@Column(name="callertune",length=50)
	private String callerTune;
	
	@Version
	private Integer versionCount;
	
	static {
		System.out.println("Hibernate----> MobileCustomer.class file is loading...");
	}
	public MobileCustomer() {
		System.out.println("Hibernate----> MobileCustomer Zero param consstructor...");
	}
	
	public Integer getCno() {
		return cno;
	}
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getCallerTune() {
		return callerTune;
	}
	public void setCallerTune(String callerTune) {
		this.callerTune = callerTune;
	}
	public Integer getVersionCount() {
		return versionCount;
	}
	public void setVersionCount(Integer versionCount) {
		this.versionCount = versionCount;
	}
	@Override
	public String toString() {
		return "MobileCustomer [cno=" + cno + ", cname=" + cname + ", mobileNo=" + mobileNo + ", callerTune="
				+ callerTune + ", versionCount=" + versionCount + "]";
	}
	
}
