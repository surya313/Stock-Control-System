package project.springboot.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import project.springboot.model.Orders;
import project.springboot.service.OrdersService;
import project.springboot.service.ReportService;

@RestController
public class OrdersController {
	
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private ReportService reportService;
	
	
	@RequestMapping(method=RequestMethod.POST, value="/addorders")
	public String addOrders(@RequestBody Orders orders) {
		return ordersService.addOrders(orders);
		
	}
	
	@GetMapping("/ordersreport")
	public String generateOrdersReport() throws FileNotFoundException, JRException {
		return reportService.ordersReport();
	}

	
}
