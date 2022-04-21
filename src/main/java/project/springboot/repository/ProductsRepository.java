package project.springboot.repository;

import java.time.Instant;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import project.springboot.model.Orders;
import project.springboot.model.Products;

public interface ProductsRepository extends JpaRepository<Products,Integer> {
	
	
	
	
	@Query("SELECT u.serialId from Products u where u.serialId= :serialId")
	String checkProduct(@Param("serialId")String serialId);
	
	
	@Query("SELECT u from Products u where u.serialId= :serialId")
	Products findProduct(@Param("serialId")String serialId);
	
	@Query("SELECT u from Products u where u.locationId= :locationId")
	Products findProductByLocationId(@Param("locationId")String serialId);

	
	@Query("SELECT u from Products u where u.productStatus =:s" )
	List<Products> findAllByStatus(@Param("s")String status);

	
	@Query("SELECT min(u.product) from Products u where u.productId = :p")
	String findProductNameById(@Param("p")String productId);

	@Query("SELECT u.price from Products u where u.productId= :p")
	int findProductPriceById(@Param("p")String productId);
	
	@Query("SELECT min(u.productId) from Products u where u.serialId= :s")
	String findProductIdBySerialId(@Param("s")String serialId);

	@Transactional
	@Modifying(flushAutomatically = true, clearAutomatically = true)
	@Query("Update Products u set u.lastUpdated= :t, u.product= :p1, u.price= :p2 where u.productId= :p3")
	void productPrice(@Param("t")Instant instant, @Param("p1")String productName, @Param("p2")int productPrice,@Param("p3")String productId);

	@Query("SELECT u.id from Products u where u.serialId= :p")
	int findIdBySerialId(@Param("p")String serialId);
	
	@Transactional
	@Modifying(flushAutomatically = true, clearAutomatically = true)
	@Query("Update Products u set u.lastUpdated= :t, u.productStatus = :s where u.id= :p")
	void updateProductStatus(@Param("t")Instant instant, @Param("s")String productStatus1,@Param("p") int id);

	
}
