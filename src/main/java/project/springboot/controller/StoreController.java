package project.springboot.controller;

import org.springframework.web.bind.annotation.RestController;

import project.springboot.service.StoreService;

@RestController
public class StoreController {
	
	private StoreService storeService;
	
//	@GetMapping("/findlocation/{column}/{product}")
//	public String findLocation(@PathVariable String column,@PathVariable String product) {
//		System.out.println(storeService.findLocation(column,product));
//		return storeService.findLocation(column,product);
//		
//		
//	}

}
