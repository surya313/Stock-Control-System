package project.springboot.controller;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;
import project.springboot.model.Products;
import project.springboot.service.BarcodeService;
import project.springboot.service.ProductsService;
import project.springboot.service.ReportService;
import project.springboot.service.StoreService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductsController {

	@Autowired
	private ProductsService productsService;
	
	@Autowired
	private ReportService reportService;
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="/addproduct")
	public String addProduct(@RequestBody Products product) {
		
		 return productsService.addProduct(product);
		
	}
	
	@GetMapping("/listproducts")
	public List<Products> listProducts() {
		return productsService.listProducts();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/editproduct")
	public String editProducts(@RequestBody Products product) {
		return productsService.editProducts(product);
	}
	
	
	@GetMapping("/productsreportToShelve")
	public String ProductsReportToShelve() throws FileNotFoundException, JRException {
		return reportService.productsReportToShelve();
	}
	
	@GetMapping("/productsreportToPick")
	public String ProductsReportToPick() throws FileNotFoundException, JRException {
		return reportService.productsReportToPick();
	}
	
//	@GetMapping("/locationCheck/{product}")
//	public String productCheck(@PathVariable String product) {
//		return productsService.locationCheck(product);
//	}
	
	
	
	
	
//	
}
