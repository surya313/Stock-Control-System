package project.springboot.model;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Products {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String product;
	private int price;
	//private int quantity;
	private String zone;
	private String area;
	private String location;
	private String productStatus;
	private String productId;
	private String serialId;
	private String locationId;
	private Instant enteredDate;
	private Instant lastUpdated;
	//private int orderedQuantity;
	
	public Products() {
		
	}
	
	
	
	



	public Products(Integer id, String product, int price, String zone, String area, String location,
			String productStatus, String productId, String serialId, String locationId, Instant enteredDate,
			Instant lastUpdated) {
		super();
		this.id = id;
		this.product = product;
		this.price = price;
		this.zone = zone;
		this.area = area;
		this.location = location;
		this.productStatus = productStatus;
		this.productId = productId;
		this.serialId = serialId;
		this.locationId = locationId;
		this.enteredDate = enteredDate;
		this.lastUpdated = lastUpdated;
	}







	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
//	public int getQuantity() {
//		return quantity;
//	}
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
//	public int getOrderedQuantity() {
//		return orderedQuantity;
//	}
//	public void setOrderedQuantity(int orderedQuantity) {
//		this.orderedQuantity = orderedQuantity;
//	}



	public Instant getEnteredDate() {
		return enteredDate;
	}



	public void setEnteredDate(Instant now) {
		this.enteredDate = now;
	}



	public Instant getLastUpdated() {
		return lastUpdated;
	}



	public void setLastUpdated(Instant lastUpdated) {
		this.lastUpdated = lastUpdated;
	}







	public String getSerialId() {
		return serialId;
	}







	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}
	
	
	
	
	
	
	
	
	

}
