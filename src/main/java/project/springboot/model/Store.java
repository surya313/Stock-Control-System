package project.springboot.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.Nullable;

@Entity
public class Store {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Instant enteredDate;
	private Instant lastUpdated;
	
	private String zone;
	
	private String area;
	
	private String location;
	
	
	private	String locationId;
	
	private String productId;
	
	//private	String product;
	
	private int quantity;
	
	
	
	public Store() {
		
	}
	
    

	
	public Store(Integer id, Instant enteredDate, Instant lastUpdated, String zone, String area, String location,
			String locationId, String productId, int quantity) {
		super();
		this.id = id;
		this.enteredDate = enteredDate;
		this.lastUpdated = lastUpdated;
		this.zone = zone;
		this.area = area;
		this.location = location;
		this.locationId = locationId;
		this.productId = productId;
		this.quantity = quantity;
	}




	public String getZone() {
		return zone;
	}



	public void setZone(String zone) {
		this.zone = zone;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}

	

	
	



	public String getLocationId() {
		return locationId;
	}



	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}



//	public String getProduct() {
//		return product;
//	}
//
//
//
//	public void setProduct(String product) {
//		this.product = product;
//	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getArea() {
		return area;
	}



	public void setArea(String area) {
		this.area = area;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
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
