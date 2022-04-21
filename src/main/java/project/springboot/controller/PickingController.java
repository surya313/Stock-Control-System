package project.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import project.springboot.service.PickingService;

@RestController
public class PickingController {
	
	@Autowired
	private PickingService pickingService;

	
	@GetMapping("/picking")
	public String picking() {
		return pickingService.picking();
		
	}
}
