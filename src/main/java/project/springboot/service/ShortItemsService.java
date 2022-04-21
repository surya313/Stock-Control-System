package project.springboot.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.springboot.repository.ShortItemsRepository;
import project.springboot.repository.StoreRepository;

@Service
public class ShortItemsService {

	@Autowired
	private BarcodeService barcodeService;
	
	@Autowired
	private ShortItemsRepository shortItemsRepository;
	
	@Autowired
	private StoreRepository storeRepository;
	
	String status;
	String productStatus = "Items Filled";
	String locationA;
	String locationB;
	String locationC;
	String locationD;
	
	
	public String shortItems() {
		
		
		
		String locationId = barcodeService.scanLocationId();
		String l = locationId.substring(0, 7); //01A1001A
	    locationA = l.concat("A");
		locationB = l.concat("B");
		locationC = l.concat("C");
		locationD = l.concat("D");
		
		if(shortItemsRepository.checkLocationId(locationId) != null) {
			if(storeRepository.checkQuantity(locationId)==0) {
				if(locationId.equals(locationA)) {
					status = checkQuantityA(locationA);
				}
				else if(locationId.equals(locationB)) {
					status = checkQuantityB(locationB);
				}
				else if(locationId.equals(locationC)) {
					status = checkQuantityC(locationC);
				}
				else if(locationId.equals(locationD)) {
					return "Location Null";
				}
				
				else {
					System.out.println(locationA);
					return "Invalid";
				}
				
				
			}
			else {
				return "Location Already Filled";
			}
			
			
		}
		else {
			return "Please check and scan correct LocationId";
		}
		
		return status;
		
		
		
		
		
		
	}
	
	public String checkQuantityA(String locationA) {
		if(storeRepository.checkQuantity(locationB) > 0) {
			System.out.println("Please scan Location-Id: "+locationB);
			String locationId1 = barcodeService.scanLocationId1();
			if(locationId1.equals(locationB)) {
				 storeRepository.updateLocationQuantity(Instant.now().plusSeconds(3600), storeRepository.checkQuantity(locationB), storeRepository.findIdByLocationId(locationA));
				 storeRepository.updateLocationQuantity(Instant.now().plusSeconds(3600), 0, storeRepository.findIdByLocationId(locationB));
				 shortItemsRepository.updateStatus(Instant.now().plusSeconds(3600),productStatus,locationA);
			}
			else {
				return "Please check and scan correct locationId: "+locationB;
			}
		}
		
		else if(storeRepository.checkQuantity(locationC) > 0) {
			System.out.println("Please scan Location-Id: "+locationC);
			String locationId1 = barcodeService.scanLocationId1();
			if(locationId1.equals(locationC)) {
				 storeRepository.updateLocationQuantity(Instant.now().plusSeconds(3600), storeRepository.checkQuantity(locationC), storeRepository.findIdByLocationId(locationA));
				 storeRepository.updateLocationQuantity(Instant.now().plusSeconds(3600), 0, storeRepository.findIdByLocationId(locationC));
				 shortItemsRepository.updateStatus(Instant.now().plusSeconds(3600),productStatus,locationA);
				 
			}
			else {
				return "Please check and scan correct locationId: "+locationC;
			}
		}
		
		else if(storeRepository.checkQuantity(locationD) > 0) {
			System.out.println("Please scan Location-Id: "+locationD);
			String locationId1 = barcodeService.scanLocationId1();
			if(locationId1.equals(locationD)) {
				 storeRepository.updateLocationQuantity(Instant.now().plusSeconds(3600), storeRepository.checkQuantity(locationD), storeRepository.findIdByLocationId(locationA));
				 storeRepository.updateLocationQuantity(Instant.now().plusSeconds(3600), 0, storeRepository.findIdByLocationId(locationD));
				 shortItemsRepository.updateStatus(Instant.now().plusSeconds(3600),productStatus,locationA);
				 
			}
			else {
				return "Please check and scan correct locationId: "+locationD;
			}
		}
		
		else {
			return "LOCATION NULL";
		}
		
		return "Items Filled in Location: "+locationA;
	}
	
	
	public String checkQuantityB(String locationB) {
		if(storeRepository.checkQuantity(locationC) > 0) {
			System.out.println("Please scan Location-Id: "+locationC);
			String locationId1 = barcodeService.scanLocationId1();
			if(locationId1.equals(locationC)) {
				 storeRepository.updateLocationQuantity(Instant.now().plusSeconds(3600), storeRepository.checkQuantity(locationC), storeRepository.findIdByLocationId(locationB));
				 storeRepository.updateLocationQuantity(Instant.now().plusSeconds(3600), 0, storeRepository.findIdByLocationId(locationC));
				 shortItemsRepository.updateStatus(Instant.now().plusSeconds(3600),locationB,productStatus);
				
			}
			else {
				return "Please check and scan correct locationId: "+locationC;
			}
		}
		
		else if(storeRepository.checkQuantity(locationD) > 0) {
			System.out.println("Please scan Location-Id: "+locationD);
			String locationId1 = barcodeService.scanLocationId1();
			if(locationId1.equals(locationD)) {
				 storeRepository.updateLocationQuantity(Instant.now().plusSeconds(3600), storeRepository.checkQuantity(locationD), storeRepository.findIdByLocationId(locationB));
				 storeRepository.updateLocationQuantity(Instant.now().plusSeconds(3600), 0, storeRepository.findIdByLocationId(locationD));
				 shortItemsRepository.updateStatus(Instant.now().plusSeconds(3600),locationB,productStatus);
				 
			}
			else {
				return "Please check and scan correct locationId: "+locationD;
			}
		}
		
		else {
			return "LOCATION NULL";
		}
		
		return "Items Filled in Location: "+locationB;
	}
	
	
	public String checkQuantityC(String locationC) {
		if(storeRepository.checkQuantity(locationD) > 0) {
			System.out.println("Please scan Location-Id: "+locationD);
			String locationId1 = barcodeService.scanLocationId1();
			if(locationId1.equals(locationD)) {
				 storeRepository.updateLocationQuantity(Instant.now().plusSeconds(3600), storeRepository.checkQuantity(locationD), storeRepository.findIdByLocationId(locationC));
				 storeRepository.updateLocationQuantity(Instant.now().plusSeconds(3600), 0, storeRepository.findIdByLocationId(locationD));
				 shortItemsRepository.updateStatus(Instant.now().plusSeconds(3600),productStatus,locationC);
				
			}
			else {
				return "Please check and scan correct locationId: "+locationC;
			}
		}
		
		else {
			return "LOCATION NULL";
		}
		
		return "Items Filled in Location: "+locationC;
	}
	
	
}
