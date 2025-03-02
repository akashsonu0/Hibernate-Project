package in.pwskills.akash.bean;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String doorNo;
	private String streetName;
	private String areaNmae;
	private String cityName;
	private String country;
	private long pinCode;
		
	
	public Address(String doorNo, String streetName, String areaNmae, String cityName, String country, long pinCode) {
	
		this.doorNo = doorNo;
		this.streetName = streetName;
		this.areaNmae = areaNmae;
		this.cityName = cityName;
		this.country = country;
		this.pinCode = pinCode;
	}
	
	static {
		System.out.println("Address.class file is loading...");
	}
	
	public Address() {
		System.out.println("Address object is created...");
	}
	
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getAreaNmae() {
		return areaNmae;
	}
	public void setAreaNmae(String areaNmae) {
		this.areaNmae = areaNmae;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getPinCode() {
		return pinCode;
	}
	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", streetName=" + streetName + ", areaNmae=" + areaNmae + ", cityName="
				+ cityName + ", country=" + country + ", pinCode=" + pinCode + "]";
	}
	


}
