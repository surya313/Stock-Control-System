package project.springboot.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.springboot.model.Orders;
import project.springboot.model.Products;
import project.springboot.repository.OrdersRepository;
import project.springboot.repository.ProductsRepository;

@Service
public class OrdersService {
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	private ProductsRepository productsRepository;
	
	final String orderPlaced = "Ordered";
	String productStatus = "Shelved";
	
	public String addOrders(Orders orders) {
		String serialId = orders.getSerialId();
		double tax =  0.05;
		double totPrice;
		if(!productsRepository.checkProduct(serialId).isEmpty() && productsRepository.findProduct(serialId).getProductStatus().matches(productStatus)){
			
			int i = productsRepository.findProduct(serialId).getPrice();
			orders.setProductPrice(i);
			orders.setProduct(productsRepository.findProduct(serialId).getProduct());
			int temp = orders.getProductPrice();
			totPrice = temp + (temp*tax);
			orders.setTotalprice(totPrice);
			orders.setTaxAmount(tax);
			String number =   Long.toString((long)Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L) ;
			orders.setOrderId(number);
			productsRepository.findProduct(serialId).setProductStatus(orderPlaced);
			productsRepository.findProduct(serialId).setLastUpdated(Instant.now().plusSeconds(3600));;
			orders.setEnteredDate(Instant.now().plusSeconds(3600));
			ordersRepository.save(orders);
			
		}
		else {
			System.out.println("Invalid Product or Invalid Product Status");
			return "Invalid Product or Invalid Product Status";
		}
		
		return "Order Added Successfully";
		
	}
	

}
