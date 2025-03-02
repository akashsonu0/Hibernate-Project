package in.pwskills.akash.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT_QBC")
public class Project implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projId;
	private String projName;
	private String company;
	private String location;
	private Integer teamSize;
	private Float cost;
	
	static {
		System.out.println("Project.class file is loading...");
	}
	
	public Project() {
		System.out.println("Project object create by hibernate...");
	}
	
	public Long getProjId() {
		return projId;
	}
	public void setProjId(Long projId) {
		this.projId = projId;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(Integer teamSize) {
		this.teamSize = teamSize;
	}
	public Float getCost() {
		return cost;
	}
	public void setCost(Float cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Project [projId=" + projId + ", projName=" + projName + ", company=" + company + ", location="
				+ location + ", teamSize=" + teamSize + ", cost=" + cost + "]";
	}
	
	
}
