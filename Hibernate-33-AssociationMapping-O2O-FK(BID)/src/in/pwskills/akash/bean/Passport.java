package in.pwskills.akash.bean;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PASSPORT_ONE_ONE_FK_BI")
public class Passport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer passportNo;
	private String country;
	private LocalDate exprityDate;

	@OneToOne(targetEntity = Person.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id", referencedColumnName = "pid")
	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Passport() {
		System.out.println("Passport[child] object is created...");
	}

	public Integer getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(Integer passportNo) {
		this.passportNo = passportNo;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LocalDate getExprityDate() {
		return exprityDate;
	}

	public void setExprityDate(LocalDate exprityDate) {
		this.exprityDate = exprityDate;
	}

	@Override
	public String toString() {
		return "Passport [passportNo=" + passportNo + ", country=" + country + ", exprityDate=" + exprityDate + "]";
	}

}
