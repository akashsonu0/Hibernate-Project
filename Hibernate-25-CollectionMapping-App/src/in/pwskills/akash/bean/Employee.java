package in.pwskills.akash.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

@Entity
@Table(name = "EMPLOYEE_COLLECTION")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eid;
	private String ename;
	private String eaddress;

	@ElementCollection
	@Column(name = "names")
	@CollectionTable(name = "EMP_FRIENDS_LIST", joinColumns = @JoinColumn(referencedColumnName = "eid", name = "emp_id"))
	@OrderColumn(name = "fno")
	@ListIndexBase(value = 1)
	private List<String> friends;

	@ElementCollection
	@Column(name = "phoneNumber")
	@CollectionTable(name = "PHONE_NUMBERS_SET", joinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "eid"))
	private Set<Long> phoneNumbers;

	
	@ElementCollection
	@Column(name = "accNo")
	@CollectionTable(name="EMP_BANK_MAP",joinColumns =
						@JoinColumn(name="emp_id",referencedColumnName = "eid"))
	@MapKeyColumn(name = "bankName")
	private Map<String, Long> bankAccounts;

	static {
		System.out.println("Employee.class file is loading...");
	}

	public Employee() {
		System.out.println("Employee Object is created...");
	}

	public Employee(String ename, String eaddress, List<String> friends, Set<Long> phoneNumbers,
			Map<String, Long> bankAccounts) {
		this.ename = ename;
		this.eaddress = eaddress;
		this.friends = friends;
		this.phoneNumbers = phoneNumbers;
		this.bankAccounts = bankAccounts;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEaddress() {
		return eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}

	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eaddress=" + eaddress + ", friends=" + friends
				+ ", phoneNumbers=" + phoneNumbers + ", bankAccounts=" + bankAccounts + "]";
	}

	public Set<Long> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<Long> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public Map<String, Long> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(Map<String, Long> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

}