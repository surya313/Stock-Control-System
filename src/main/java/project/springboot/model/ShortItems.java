package project.springboot.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ShortItems {
	
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			private Integer id;
			private String status;
			private String productId;
			private String locationId;
			private Instant enteredDate;
			private Instant lastUpdated;
			
			public ShortItems() {
				
			}

			public ShortItems(Integer id, String status, String productId, String locationId, Instant enteredDate,
					Instant lastUpdated) {
				super();
				this.id = id;
				this.status = status;
				this.productId = productId;
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

			public String getStatus() {
				return status;
			}

			public void setStatus(String status) {
				this.status = status;
			}

			public String getProductId() {
				return productId;
			}

			public void setProductId(String productId) {
				this.productId = productId;
			}

			public String getLocationId() {
				return locationId;
			}

			public void setLocationId(String locationId) {
				this.locationId = locationId;
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


