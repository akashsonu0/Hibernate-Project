package in.pwskills.akash.bean;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value="card")
public class CardPayment extends Payment {
	
	private Long cardNo;
	private String cardType;
	private String paymentGateWay;

	
	static {
		System.out.println("CardPayment.class file is loading....");
	}
	public CardPayment() {
		System.out.println("Hibernate creating an object of CardPayment...");
	}
	public Long getCardNo() {
		return cardNo;
	}
	public void setCardNo(Long cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getPaymentGateWay() {
		return paymentGateWay;
	}
	public void setPaymentGateWay(String paymentGateWay) {
		this.paymentGateWay = paymentGateWay;
	}
	@Override
	public String toString() {
		return "CardPayment [cardNo=" + cardNo + ", cardType=" + cardType + ", paymentGateWay=" + paymentGateWay + "]";
	}
	
	
	}
	
	
	

