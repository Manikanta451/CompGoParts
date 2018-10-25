package com.compgoparts.pagefactory;

import org.openqa.selenium.WebDriver;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import javax.imageio.ImageIO;
import org.testng.Assert;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;

public class QRCode  extends CommonBase{

	public QRCode(WebDriver driver) {
		super(driver);
	}
	

	public void code()throws Exception{
		
		try {
			File file = new File("C:\\Users\\Manikanta\\Downloads\\qrcode-selenium.png");
            String decodedText = null;

            // store the file as image
            BufferedImage bufferedImage = ImageIO.read(file);

            // process the image
            LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            // store the details of the QR code
            Result result = new MultiFormatReader().decode(bitmap);
            decodedText =  result.getText();

            // print to console
            System.out.println("Decoded text = " + decodedText);

            // testng assertion
            Assert.assertEquals(decodedText, "cherchertech");
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void code1()throws Exception{
		
		try {
			

			String src = driver.findElement(By.id("complex-qrcode")).getAttribute("src");
			System.out.println("image url is : "+src);

			URL urlOfImage = new URL(src);
			BufferedImage bufferedImage = ImageIO.read(urlOfImage);

			LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

			// store the details of the QR code
			Result result = new MultiFormatReader().decode(bitmap);
			String decodedText = result.getText();

			Map contact = new HashMap();

			// print to console
			System.out.println("Decoded content = " + decodedText);
			System.out.println("**************************************\n\n");
			String[] abc = decodedText.replace("MECARD:", "").split(";");
			for (String str : abc) {
				System.out.println(str);
				String[] content = str.split(":");
				contact.put(content[0], content[1]);
			}
			System.out.println("**************************************\n\n");
			//print the contact map
			System.out.println("Complete contact map :: ");
			System.out.println(contact);
	    
		} catch (Exception e) {
			e.printStackTrace();		
			}
	}
	
	public void barcode()throws Exception{
		
		BufferedImage bufferedImage = ImageIO.read(new File("C:\\Users\\Manikanta\\Downloads\\bar-code.png"));

		LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

		Result result = new MultiFormatReader().decode(bitmap);
		System.out.println(result.getText());
	}
	
}
