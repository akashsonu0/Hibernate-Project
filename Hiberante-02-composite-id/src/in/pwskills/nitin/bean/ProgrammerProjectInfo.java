package in.pwskills.nitin.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProgrammerProjectInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ProgramProjId id;
	
	@Column(name = "pname" , length = 20)
	private String pname;
	
	@Column(name = "projname" , length =20)
	private String projName;

	public ProgramProjId getId() {
		return id;
	}

	public void setId(ProgramProjId id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	@Override
	public String toString() {
		return "ProgrammerProjectInfo [id=" + id + ", pname=" + pname + ", projName=" + projName + "]";
	}

	
}
