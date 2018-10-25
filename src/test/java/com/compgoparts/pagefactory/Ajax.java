package com.compgoparts.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ajax {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vinod\\git\\CompGoParts\\BrowserDrivers\\chromedriver.exe");
		driver=new ChromeDriver();
	    driver.get("http://google.co.in");
	    Thread.sleep(4000);
	    driver.findElement(By.id("lst-ib")).sendKeys("selenium");
        Thread.sleep(4000);
        String str=driver.findElement(By.xpath("//*[@id=\"sbtc\"]/div[2]/div[2]")).getText();
        System.out.println(str);
        String s[]=str.split("\n");
        System.out.println(s.length);
         for (int i = 0; i < s.length; i++) {
	//System.out.println(s[i]);
        	 if(s[i].equalsIgnoreCase("selenium tutorial")) {
        		 System.out.println(s[i]);
        		 driver.findElement(By.id("lst-ib")).clear();
        		 driver.findElement(By.id("lst-ib")).sendKeys(s[i]);
        	 }
         }
}

		
	}

