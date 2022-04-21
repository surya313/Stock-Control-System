package project.springboot.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.springboot.model.Products;
import project.springboot.model.Store;
import project.springboot.repository.ProductsRepository;
import project.springboot.repository.StoreRepository;


@Service
public class ProductsService {

	@Autowired
	private  ProductsRepository productsRepository;
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private BarcodeService barcodeService;
	
	@Autowired
	private StoreService storeService;
	
	String placeAtLocation = "Place the Product in the Location";
	
	Instant now = Instant.now().plusSeconds(3600);
	
	
	



	public String addProduct(Products product) {
		// TODO Auto-generated method stub
		String productName;
		String locationId;
		String zone;
		String area;
		String location;
		int price;
		Instant now = Instant.now().plusSeconds(3600);
		 String p = product.getProduct();
		 String z = product.getZone();
		 String a = product.getArea();
		 String l = product.getLocation();
		 String productId = null;
		 String serialId = null;
		
				try {
					productId = barcodeService.scanProductId();
				    
						   
				 } catch (Exception e) {
					 System.out.println("error " + e.getMessage());
				 }
				 
				 System.out.println("productId " +productId);
		 
				 try {
					 serialId = barcodeService.scanSerialId();
					    
							   
					 } catch (Exception e) {
						 System.out.println("error " + e.getMessage());
					 }
				 System.out.println("serialId " +serialId);
		 
		 
		if(storeService.checkProductId(productId)) {
			if(productsRepository.checkProduct(serialId) == null) {
					productName = productsRepository.findProductNameById(productId);
					System.out.format("ProductId for  Already Exists!",productName);
					price = productsRepository.findProductPriceById(productId);
					locationId = storeRepository.findLocationByProductId(productId);
					zone = locationId.substring(0, 2);
					area = locationId.substring(2, 4);
					location = locationId.substring(4,7);
					System.out.format("Location for the ProductId is zone: , area: , location: ",zone,area,location);
					
					String s = storeService.checkLocationQuantity(zone,area,location);
					
					if(s != null) {
						product.setLocationId(s);
						product.setProductId(productId);
						product.setSerialId(serialId);
						product.setProduct(productName);
						product.setPrice(price);
						product.setZone(zone);
						product.setArea(area);
						product.setLocation(location);
						product.setProductStatus(placeAtLocation);
						product.setEnteredDate(now);
						productsRepository.save(product);
						return "Product Saved";
					}
					else {
						return "Location Full";
					}
			}
			else {
					return "Product with SerialId Already Exists";
			}
			
		}
		else {
			
			System.out.println("New ProductId Found - Please Enter details");
			if(productsRepository.checkProduct(serialId) == null){		
				    String s = storeService.checkLocation(z,a,l);
					if(s != null) {
						locationId = s;
						storeService.addProductLocation(z,a,l,productId);
						product.setProductId(productId);
						product.setSerialId(serialId);
						product.setLocationId(locationId);
						product.setProductStatus(placeAtLocation);
						product.setEnteredDate(now);
						productsRepository.save(product);
						return "Product Saved";
						
						
					}
					else {
						 System.out.println("Location Unavailable");
						 return "Location Unavailable";
						
					}
			}
			else {
				return "Product with SerialId Already Exists";
			}
		}
	
	}




	public List<Products> listProducts() {
		// TODO Auto-generated method stub
		return this.productsRepository.findAll();
	}



	public String editProducts(Products product) {
		// TODO Auto-generated method stub
		
		String productName; 
		String serialId;
			
		if(product.getProduct() !=null && product.getSerialId() !=null) {
			
				 productName = product.getProduct();
				 serialId = product.getSerialId();
				 String productId = productsRepository.findProductIdBySerialId(serialId);
				 int productPrice = product.getPrice();
				  
				 productsRepository.productPrice(Instant.now().plusSeconds(3600),productName,productPrice,productId);
				
				 
				 
				 return "Product Details Changed Successfully!";
		}
		else {
				 return "Product Details should not be Empty!"; 
		}
		
		
	}
	




}
