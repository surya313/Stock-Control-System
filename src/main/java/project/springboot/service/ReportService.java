package project.springboot.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import project.springboot.model.Orders;
import project.springboot.model.Products;
import project.springboot.model.Store;
import project.springboot.repository.OrdersRepository;
import project.springboot.repository.ProductsRepository;
import project.springboot.repository.StoreRepository;

@Service
public class ReportService {
	
	
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private ProductsService productsService;
	
	
	public String ordersReport() throws FileNotFoundException, JRException {
		
		List<Orders> orders = ordersRepository.findAll();
		File file = ResourceUtils.getFile("classpath:reports/Simple_Blue.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(orders);
		Map<String,Object> parameters = new HashMap<>();
		parameters.put("orders", "Stock control system");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		//JasperExportManager.exportReportToHtmlFile(jasperPrint, "D:\\Stock_Control_System\\report" + "\\orders.html");
		JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\Stock_Control_System\\report" + "\\orders.pdf");
		
		return "Orders Report Generated";
		
		
		
	}
	
	public String locationLabel(String z,String a,String l) throws FileNotFoundException, JRException{
		String locationId = storeRepository.fetchLocationId(z, a, l);
		int i = storeRepository.fetchIdByLocation(z,a,l);
		List<Store> locationId1 = new ArrayList<Store>();
		locationId1.add(storeRepository.getOne(i));
		System.out.println(locationId1);
		File file = ResourceUtils.getFile("classpath:reports/Label.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(locationId1);
		Map<String,Object> labelParameters = new HashMap<>();
		labelParameters.put("yes", "Stock control system");
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,labelParameters,dataSource);
		
		//JasperExportManager.exportReportToHtmlFile(jasperPrint, "D:\\Stock_Control_System\\report" + "\\label.html");
		JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\Stock_Control_System\\report" + "\\Locationlabel.pdf");
		
		return "Label Generated for the Location: "+locationId;
	}
	
	public String orderLabel(String orderId) throws FileNotFoundException, JRException{
		//String locationId = storeRepository.fetchLocationId(z, a, l);
		int i = ordersRepository.fetchIdByOrderId(orderId);
		List<Orders> OrderId = new ArrayList<Orders>();
		OrderId.add(ordersRepository.getOne(i));
		System.out.println(OrderId);
		File file = ResourceUtils.getFile("classpath:reports/Orderslabel.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(OrderId);
		Map<String,Object> labelParameters = new HashMap<>();
		labelParameters.put("yes", "Stock control system");
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,labelParameters,dataSource);
		
		//JasperExportManager.exportReportToHtmlFile(jasperPrint, "D:\\Stock_Control_System\\report" + "\\label.html");
		JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\Stock_Control_System\\report" + "\\Orderslabel.pdf");
		
		return "Label Generated for OrderId: "+orderId;
	}
	
	public String productsReportToShelve() throws FileNotFoundException, JRException {
		
		String status = "Place the Product in the Location";
		if(!productsRepository.findAllByStatus(status).isEmpty()) {
		 List<Products> products = productsRepository.findAllByStatus(status);
		 System.out.println("list of products with status "+products.size());
		File file = ResourceUtils.getFile("classpath:reports/Products.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(products);
		Map<String,Object> parameters = new HashMap<>();
		parameters.put("products", "status");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		//JasperExportManager.exportReportToHtmlFile(jasperPrint, "D:\\Stock_Control_System\\report" + "\\products.html");
		JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\Stock_Control_System\\report" + "\\productsToShelve.pdf");
		
		return "Products Report Generated";
		}
		else {
			return "Products not Found with given Status";
		}
		
		
		
	}
	
public String productsReportToPick() throws FileNotFoundException, JRException {
		
		String status = "Ordered";
		if(!productsRepository.findAllByStatus(status).isEmpty()) {
		 List<Products> products = productsRepository.findAllByStatus(status);
		File file = ResourceUtils.getFile("classpath:reports/Products.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(products);
		Map<String,Object> parameters = new HashMap<>();
		parameters.put("products", "status");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		//JasperExportManager.exportReportToHtmlFile(jasperPrint, "D:\\Stock_Control_System\\report" + "\\products.html");
		JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\Stock_Control_System\\report" + "\\productsToPick.pdf");
		
		return "Products Report Generated";
		}
		else {
			return "Products not Found with given Status";
		}
		
		
		
	}

}
