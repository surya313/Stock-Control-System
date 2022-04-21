package project.springboot.repository;

import java.time.Instant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import project.springboot.model.Store;

public interface StoreRepository extends JpaRepository<Store,Integer> {
	

	
//	
	
	
	@Query("SELECT u.quantity from Store u where u.locationId= :ld")
	int checkQuantity(@Param("ld")String locationId);


	@Query("SELECT u.locationId from Store u where u.zone= :z AND u.area= :a AND u.location = :l")
	String fetchLocationId(@Param("z")String z,@Param("a")String a,@Param("l")String l);


	@Query("SELECT u.id from Store u where u.zone= :z AND u.area= :a AND u.location = :l")
	int fetchIdByLocation(@Param("z")String z,@Param("a")String a,@Param("l")String l);

	
	@Query("SELECT min(u.id) from Store u where u.productId = :p")
	Integer checkProductId(@Param("p")String productId);

	
	@Query("SELECT min(u.locationId) from Store u where u.productId= :p")
	String findLocationByProductId(@Param("p")String productId);


	@Query("SELECT u.id from Store u where u.locationId= :l")
	int findIdByLocationId(@Param("l")String locationId1);

	@Transactional
	@Modifying(flushAutomatically = true, clearAutomatically = true)
	@Query("Update Store u set u.lastUpdated= :t,u.quantity= :i where u.id= :l")
	void updateLocationQuantity(@Param("t")Instant instant, @Param("i")int i, @Param("l")int id);
	
	

	
	

}
