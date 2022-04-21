package project.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import project.springboot.service.ShortItemsService;

@RestController
public class ShortItemsController {
	
	
	@Autowired
	private ShortItemsService shortItemsService;
	
	
	@GetMapping("/shortItems")
	public String shortItems() {
		return shortItemsService.shortItems();
	}

}
