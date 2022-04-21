package project.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import project.springboot.service.ShelveService;

@RestController
public class ShelveController {
	
	
	@Autowired
	private ShelveService shelveService;
	
	
	@GetMapping("/shelveproduct")
	public String shelveProduct() {
		return shelveService.shelve();
	}

}
