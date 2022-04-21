package project.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import project.springboot.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders,Integer> {

	@Query("SELECT u.id from Orders u where u.orderId= :p")
	int fetchIdByOrderId(@Param("p")String orderId);
	

}
