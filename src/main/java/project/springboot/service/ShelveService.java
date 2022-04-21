package project.springboot.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.springboot.repository.ProductsRepository;


@Service
public class ShelveService {
	
	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private BarcodeService barcodeService;
	
	public String shelve() {
		
		
		String productStatus = "Place the Product in the Location";
		String productStatus1 = "Shelved";
		
		String serialId = barcodeService.scanSerialId();
		if(productsRepository.findProduct(serialId).getProductStatus().equals(productStatus)) {
			String locationId = productsRepository.findProduct(serialId).getLocationId();
			String locationId1 = barcodeService.scanLocationId();
			System.out.println(locationId1);
			if(locationId.equals(locationId1)) {
				productsRepository.updateProductStatus(Instant.now().plusSeconds(3600),productStatus1,productsRepository.findIdBySerialId(serialId));
				return "Please place the product in the given location: " +locationId1; 
			}
			else {
				return "Please Check and Scan the Correct Location: " +locationId;
			}
		}
		else {
			return "Product Already Shelved";
		}
		
		
		
		
	}
	
}
