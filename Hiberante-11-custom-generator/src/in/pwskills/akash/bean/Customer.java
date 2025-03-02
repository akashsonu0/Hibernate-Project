package in.pwskills.akash.bean;

public class Customer {
	
	private String customerId;
	private String customerName;
	private String location;
	
	static {
		System.out.println("Hibernate -->Customer.class file is loading...");
	}
	
	public Customer() {
		System.out.println("Hibernate --> Customer :: Zero param constructor...");
	}
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", location=" + location + "]";
	}
	
	

}
