package project.springboot.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Instant enteredDate;
	private Instant lastUpdated;
	private String orderId;
	private String product;
	private String serialId;
	private String customerName;
	//private int numberOfItems;
	private int productPrice;
	//private int orderPrice;
	private double taxAmount;
	private double totalprice;
	
	public Orders() {
		
	}

	public Orders(Integer id, Instant enteredDate, Instant lastUpdated, String orderId, String product, String serialId,
			String customerName, int productPrice, double taxAmount, double totalprice) {
		super();
		this.id = id;
		this.enteredDate = enteredDate;
		this.lastUpdated = lastUpdated;
		this.orderId = orderId;
		this.product = product;
		this.serialId = serialId;
		this.customerName = customerName;
		this.productPrice = productPrice;
		this.taxAmount = taxAmount;
		this.totalprice = totalprice;
	}







	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

//	public int getNumberOfItems() {
//		return numberOfItems;
//	}
//
//	public void setNumberOfItems(int numberOfItems) {
//		this.numberOfItems = numberOfItems;
//	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

//	public int getOrderPrice() {
//		return orderPrice;
//	}
//
//	public void setOrderPrice(int orderPrice) {
//		this.orderPrice = orderPrice;
//	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(double tax) {
		this.taxAmount = tax;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totPrice) {
		this.totalprice = totPrice;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getOrderId() {
		return orderId;
	}



	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}



	

	public String getSerialId() {
		return serialId;
	}

	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}

	public Instant getEnteredDate() {
		return enteredDate;
	}

	public void setEnteredDate(Instant enteredDate) {
		this.enteredDate = enteredDate;
	}

	public Instant getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Instant lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
	
	
	
	

}
