package project.springboot.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import project.springboot.model.Store;
import project.springboot.repository.ProductsRepository;
import project.springboot.repository.StoreRepository;



@Service
public class StoreService {

	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private ProductsRepository productsRepository;
	
	
	

//	public void addItem(String p,String l) { 
//		// TODO Auto-generated method stub
//		
//		this.storeRepository.addLocation(p, l);
//		
//	}
//	

	public String checkLocation(String z,String a,String l) {
		
		String locationA = l.concat("A");
		String locationB = l.concat("B");
		String locationC = l.concat("C");
		String locationD = l.concat("D");
		
		if (storeRepository.findById(storeRepository.fetchIdByLocation(z, a, locationA)).get().getProductId().isEmpty() &&
		storeRepository.findById(storeRepository.fetchIdByLocation(z, a, locationB)).get().getProductId().isEmpty() &&
		storeRepository.findById(storeRepository.fetchIdByLocation(z, a, locationC)).get().getProductId().isEmpty() &&
		storeRepository.findById(storeRepository.fetchIdByLocation(z, a, locationD)).get().getProductId().isEmpty() ) {
			int c = storeRepository.findById(storeRepository.fetchIdByLocation(z, a, locationA)).get().getQuantity();
			  storeRepository.findById(storeRepository.fetchIdByLocation(z, a, locationA)).get().setQuantity(++c);
			  System.out.println("Location is available " +locationA);
			  return storeRepository.fetchLocationId(z, a, locationA) ;
		}
		else {
			return null;
		}
		
		
		
	}
	public String checkLocationQuantity(String z,String a,String l) {
		// TODO Auto-generated method stub
		 
		String locationA = l.concat("A");
		String locationB = l.concat("B");
		String locationC = l.concat("C");
		String locationD = l.concat("D");
		int countA = storeRepository.checkQuantity(storeRepository.fetchLocationId(z, a, locationA));
		int countB = storeRepository.checkQuantity(storeRepository.fetchLocationId(z, a, locationB));
		int countC = storeRepository.checkQuantity(storeRepository.fetchLocationId(z, a, locationC));
		int countD = storeRepository.checkQuantity(storeRepository.fetchLocationId(z, a, locationD));
		int count = 1;
		 
		  if (countA < count) {
			  System.out.println(storeRepository.checkQuantity(storeRepository.fetchLocationId(z, a, locationA)));
			  int c = storeRepository.findById(storeRepository.fetchIdByLocation(z, a, locationA)).get().getQuantity();
			  storeRepository.findById(storeRepository.fetchIdByLocation(z, a, locationA)).get().setQuantity(++c);
			  storeRepository.findById(storeRepository.fetchIdByLocation(z, a, locationA)).get().setLastUpdated(Instant.now().plusSeconds(3600));
			  System.out.format("Location  is available",locationA);
			  return storeRepository.fetchLocationId(z, a, locationA) ;
		  }
		  else if ((countB < count)) {
			  System.out.println(storeRepository.checkQuantity(storeRepository.fetchLocationId(z, a, locationB)));
			  int c = storeRepository.findById(storeRepository.fetchIdByLocation(z, a, locationB)).get().getQuantity();
			  storeRepository.findById(storeRepository.fetchIdByLocation(z, a, locationB)).get().setQuantity(++c);
			  storeRepository.findById(storeRepository.fetchIdByLocation(z, a, locationB)).get().setLastUpdated(Instant.now().plusSeconds(3600));
			  
			  System.out.format("Location  is available",locationB);
			  return storeRepository.fetchLocationId(z, a, locationB);
		  
		  }
		  else if ((countC < count)) {
			  System.out.println(storeRepository.checkQuantity(storeRepository.fetchLocationId(z, a, locationC)));
			  int c = storeRepository.findById(storeRepository.fetchIdByLocation(z, a, locationC)).get().getQuantity();
			  storeRepository.findById(storeRepository.fetchIdByLocation(z, a, locationC)).get().setQuantity(++c);
			  storeRepository.findById(storeRepository.fetchIdByLocation(z, a, locationC)).get().setLastUpdated(Instant.now().plusSeconds(3600));
			  System.out.format("Location  is available",locationC);
			  return storeRepository.fetchLocationId(z, a, locationC);
		  
		  }
		  else if ((countD < count)) {
			  System.out.println(storeRepository.checkQuantity(storeRepository.fetchLocationId(z, a, locationD)));
			  int c = storeRepository.findById(storeRepository.fetchIdByLocation(z, a, locationD)).get().getQuantity();
			  storeRepository.findById(storeRepository.fetchIdByLocation(z, a, locationD)).get().setQuantity(++c);
			  storeRepository.findById(storeRepository.fetchIdByLocation(z, a, locationD)).get().setLastUpdated(Instant.now().plusSeconds(3600));
			  System.out.format("Location  is available",locationD);
			  return storeRepository.fetchLocationId(z, a, locationD);
		  
		  }
		  else {
			 return null;
			 
		  }
		  
	}
	
	public void addProductLocation(String z, String a, String l, String productId) {
		String locationA = l.concat("A");
		String locationB = l.concat("B");
		String locationC = l.concat("C");
		String locationD = l.concat("D");
		
		storeRepository.findById(storeRepository.fetchIdByLocation(z, a, locationA)).get().setProductId(productId);
		storeRepository.findById(storeRepository.fetchIdByLocation(z, a, locationA)).get().setEnteredDate(Instant.now().plusSeconds(3600));
		
		storeRepository.findById(storeRepository.fetchIdByLocation(z, a, locationB)).get().setProductId(productId);
		storeRepository.findById(storeRepository.fetchIdByLocation(z, a, locationB)).get().setEnteredDate(Instant.now().plusSeconds(3600));
		
		storeRepository.findById(storeRepository.fetchIdByLocation(z, a, locationC)).get().setProductId(productId);
		storeRepository.findById(storeRepository.fetchIdByLocation(z, a, locationC)).get().setEnteredDate(Instant.now().plusSeconds(3600));
		
		storeRepository.findById(storeRepository.fetchIdByLocation(z, a, locationD)).get().setProductId(productId);
		storeRepository.findById(storeRepository.fetchIdByLocation(z, a, locationD)).get().setEnteredDate(Instant.now().plusSeconds(3600));
		
		
		
		
	}
	
	
	
	public boolean checkProductId(String productId) {
		  List<Store> t =	storeRepository.findAll();
		  for(int i=0; i<t.size();i++) {
			  if(t.get(i).getProductId().equals(productId)) {
				  return true;
			  }
			  
		  }
		  
		  return false;
	
}

	public String fetchLocationId(String z, String a, String l) {
		// TODO Auto-generated method stub
		return storeRepository.fetchLocationId(z,a,l);
	}
	

}
