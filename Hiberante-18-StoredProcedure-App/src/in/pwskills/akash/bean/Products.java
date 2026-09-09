package in.pwskills.akash.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQuery(query ="CALL `GET_PRODUCT_DETAILS_BY_NAME`(:product1,:product2)",
						 name="callStoredProcedure",
						 resultClass = Products.class)
public class Products implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	private String pname;
	private Float price;
	private Integer quantity;
	
	static {
		System.out.println("Hibernate --> Products.class file is loading...");
	}
	
	public Products() {
		System.out.println("Hibernate --> Products Object reated using Zero param...");
	}
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Products [pid=" + pid + ", pname=" + pname + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
}
