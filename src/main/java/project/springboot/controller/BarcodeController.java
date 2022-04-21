package project.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import project.springboot.service.BarcodeService;
import project.springboot.service.ReportService;

@RestController
public class BarcodeController {
	
	@Autowired
	private BarcodeService barcodeService;
	
	@Autowired
	private ReportService reportService;
	
	
	@GetMapping("/barcode")
	public void barcodeScan() {
		barcodeService.scanProductId();
	}
	
	
	@GetMapping("/barcodeGenerate/{z}/{a}/{l}")
	public String barcodeGenerate(@PathVariable String z,@PathVariable String a,@PathVariable String l) throws Exception {
		barcodeService.barcodeGenerate(z, a, l);
		return reportService.locationLabel(z, a, l);
		
	}
	
	@GetMapping("/ordersbarcodeGenerate/{orderId}")
	public String ordersBarcodeGenerate(@PathVariable String orderId) throws Exception {
		barcodeService.ordersBarcodeGenerate(orderId);
		return reportService.orderLabel(orderId);
		
	}

}
