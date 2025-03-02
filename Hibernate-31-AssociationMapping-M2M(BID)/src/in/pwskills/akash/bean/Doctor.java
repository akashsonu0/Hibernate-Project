package in.pwskills.akash.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DOCTOR_MTM_BI")
public class Doctor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer doctId;
	private String doctName;
	private String hospital;
	
	
	@ManyToMany(targetEntity = Patient.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name = "DOCTOR_PATIENT_M2M",joinColumns = 
								@JoinColumn(name="DOCT_ID",referencedColumnName = "doctId"),
								inverseJoinColumns = @JoinColumn(name="PAT_ID",referencedColumnName = "patId"))				
	private Set<Patient> patients;

	public Integer getDoctId() {
		return doctId;
	}

	public void setDoctId(Integer doctId) {
		this.doctId = doctId;
	}

	public String getDoctName() {
		return doctName;
	}

	public void setDoctName(String doctName) {
		this.doctName = doctName;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	@Override
	public String toString() {
		return "Doctor [doctId=" + doctId + ", doctName=" + doctName + ", hospital=" + hospital + "]";
	}

	public Set<Patient> getPatients() {
		return patients;
	}

	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}
	

}
