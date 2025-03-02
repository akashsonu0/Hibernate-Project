package in.pwskills.akash.bean;

import java.time.LocalDate;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Table(name="CHEQUEPAYMENT_TBSC")
@DiscriminatorValue(value="cheque")
@PrimaryKeyJoinColumn(name="payment_id",referencedColumnName = "pid")
public class ChequePayment extends Payment {
	
	private Long chequeNo;
	private String chequeType;
	private LocalDate expriyDate;
	
	static {
		System.out.println("ChequePayment.class file is loading....");
	}
	public ChequePayment() {
		System.out.println("Hibernate creating an object of CheqePayment...");
	}
	
	
	
	public Long getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(Long chequeNo) {
		this.chequeNo = chequeNo;
	}
	public String getChequeType() {
		return chequeType;
	}
	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}
	public LocalDate getExpriyDate() {
		return expriyDate;
	}
	public void setExpriyDate(LocalDate expriyDate) {
		this.expriyDate = expriyDate;
	}
	
	@Override
	public String toString() {
		return "ChequePayment [chequeNo=" + chequeNo + ", chequeType=" + chequeType + ", expriyDate=" + expriyDate
				+ "]";
	}

}
