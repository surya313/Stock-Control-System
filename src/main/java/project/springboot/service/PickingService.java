package project.springboot.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.springboot.repository.ProductsRepository;
import project.springboot.repository.ShortItemsRepository;
import project.springboot.repository.StoreRepository;

@Service
public class PickingService {
	
	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private BarcodeService barcodeService;
	
	@Autowired
	private ShortItemsRepository shortItemsRepository;
	
	
	
	public String picking() {
		String productStatus = "Ordered";
		String productStatus1 = "Picked";
		String productStatus2 = "Items Short";
		
		String serialId = barcodeService.scanSerialId();
		
		if(productsRepository.findProduct(serialId).getProductStatus().equals(productStatus) ) {
			String locationId = productsRepository.findProduct(serialId).getLocationId();
			String locationId1 = barcodeService.scanLocationId();
			System.out.println(locationId1);
			if(locationId.equals(locationId1)) {
				productsRepository.updateProductStatus(Instant.now().plusSeconds(3600),productStatus1,productsRepository.findIdBySerialId(serialId));
			    int q = storeRepository.findById(storeRepository.findIdByLocationId(locationId1)).get().getQuantity();
			    storeRepository.updateLocationQuantity(Instant.now().plusSeconds(3600),--q,storeRepository.findIdByLocationId(locationId1)); 
			    if(storeRepository.checkQuantity(locationId1) ==0) {
			    	
					String status = productStatus2 ;
					String productId = productsRepository.findProduct(serialId).getProductId();
					String location_Id = locationId1;
					shortItemsRepository.insertShortItems(status,productId,location_Id,Instant.now().plusSeconds(3600));
			    }
		
			    
				return "Pick the Item with serialID: " +serialId; 
			}
			else {
				return "Please Check and Scan the Correct Location: " +locationId;
			}
		}
		else {
			return "Product is not ordered yet";
		}
		
		
		
		
	}

}
