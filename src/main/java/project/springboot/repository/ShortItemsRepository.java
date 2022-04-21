package project.springboot.repository;

import java.time.Instant;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import project.springboot.model.ShortItems;

public interface ShortItemsRepository extends JpaRepository<ShortItems,Integer> {

	
	@Transactional
	@Modifying(flushAutomatically = true, clearAutomatically = true)
	@Query(value = "INSERT INTO Short_Items (status,product_id,location_id,entered_date) VALUES (:s,:p,:l,:t)", nativeQuery = true)
	void insertShortItems(@Param("s")String status,@Param("p") String productId,@Param("l") String location_Id,@Param("t") Instant plusSeconds);
	
	
	@Query("SELECT u.locationId from ShortItems u where u.locationId =:l")
	String checkLocationId(@Param("l")String locationId);

	@Transactional
	@Modifying(flushAutomatically = true, clearAutomatically = true)
	@Query("Update ShortItems u set u.lastUpdated= :t,u.status= :s where u.locationId= :l")
	void updateStatus(@Param("t")Instant plusSeconds,@Param("s")String productStatus,@Param("l") String locationA);

}
