package project.springboot.service;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Paths;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.oned.Code128Writer;

import project.springboot.repository.OrdersRepository;
import project.springboot.repository.StoreRepository;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.image.BufferedImage;


@Service
public class BarcodeService {
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	public String scanProductId() {
		
		String bResult = null;
		Webcam webcam = Webcam.getDefault(); 
		webcam.open();//Generate Webcam Object
        webcam.setViewSize(new Dimension(320,240));
        WebcamPanel webcamPanel = new WebcamPanel(webcam);
        webcamPanel.setMirrored(false);
        JFrame jFrame = new JFrame();
        jFrame.add(webcamPanel);
        jFrame.pack();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
		
	
		try {	
			//String path = "D:\\Stock_Control_System\\barcodes\\Product_Id\\productId_2.jpg";
			//BufferedImage barBufferedImage = ImageIO.read(new FileInputStream(path));
			BufferedImage Image = webcam.getImage();
			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(
					new BufferedImageLuminanceSource(Image)));
			Result result = new MultiFormatReader().decode(bitmap);
			System.out.println(result.getText());
			bResult = result.getText().toString();
			//bResult = bt;
			System.out.println(bResult);
		
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
		
		return bResult;

}
	
	public String scanSerialId() {
		
		String bResult = null;
		
	
		try {	
			String path = "D:\\Stock_Control_System\\barcodes\\Serial_Id\\serialId_2.jpg";
			BufferedImage barBufferedImage = ImageIO.read(new FileInputStream(path));
			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(
					new BufferedImageLuminanceSource(barBufferedImage)));
			Result result = new MultiFormatReader().decode(bitmap);
			System.out.println(result.getText());
			bResult = result.getText().toString();
			//bResult = bt;
			System.out.println(bResult);
			
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
		
		return bResult;

	}
	
public String scanLocationId() {
		
		String bResult = null;
		
	
		try {	
			String path = "D:\\Stock_Control_System\\barcodes\\Location_Id\\locationId_2.jpg";
			BufferedImage barBufferedImage = ImageIO.read(new FileInputStream(path));
			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(
					new BufferedImageLuminanceSource(barBufferedImage)));
			Result result = new MultiFormatReader().decode(bitmap);
			System.out.println(result.getText());
			bResult = result.getText().toString();
			//bResult = bt;
			System.out.println(bResult);
			
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
		
		return bResult;

	}

public String scanLocationId1() {
	
	String bResult = null;
	

	try {	
		String path = "D:\\Stock_Control_System\\barcodes\\Location_Id\\locationId_3.jpg";
		BufferedImage barBufferedImage = ImageIO.read(new FileInputStream(path));
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(
				new BufferedImageLuminanceSource(barBufferedImage)));
		Result result = new MultiFormatReader().decode(bitmap);
		System.out.println(result.getText());
		bResult = result.getText().toString();
		//bResult = bt;
		System.out.println(bResult);
		
	} catch (Exception e) {
		System.out.println("Error" + e.getMessage());
	}
	
	return bResult;

}
	
	
	public void barcodeGenerate(String z,String a,String l) throws Exception {
		try {
			String text = storeRepository.fetchLocationId(z, a, l);
			//String text = "0000000789";
			String path = "D:\\Stock_Control_System\\generated_barcodes\\Location_barcodes\\Locationbarcode.jpg";
			Code128Writer barcode = new Code128Writer();
			BitMatrix matrix = barcode.encode(text, BarcodeFormat.CODE_128, 500, 300);
			MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));
			
			
		} catch(Exception e) {
			
			System.out.println("Error in creating barcode" +e);
			
			
		}
	}
	
		public void ordersBarcodeGenerate(String orderId) throws Exception {
			try {
				String text = orderId;
				String path = "D:\\Stock_Control_System\\generated_barcodes\\Orders_barcodes\\orderIdbarcode.jpg";
				Code128Writer barcode = new Code128Writer();
				BitMatrix matrix = barcode.encode(text, BarcodeFormat.CODE_128, 500, 300);
				MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));
				
			} catch(Exception e) {
				
				System.out.println("Error in creating barcode" +e);
				
			}
		
	}
	
}

