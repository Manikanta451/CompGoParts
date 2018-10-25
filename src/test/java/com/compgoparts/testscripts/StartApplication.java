package com.compgoparts.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.TestNG;

import com.compgoparts.pagefactory.CommonBase;

public class StartApplication extends CommonBase {

	public StartApplication(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

public static String testngpath = System.getProperty("user.dir");
	
	public static void main (String[] args) throws Exception {
		
        try {
      	  TestNG runner=new TestNG();
      	  List<String> suitefiles=new ArrayList<String>();
      	  suitefiles.add(testngpath + "//TestNg.xml");
      	  runner.setTestSuites(suitefiles);
      	  runner.run();
      	 /* Xl.generateReport("TestReport.xlsx");
      	  emailreport();
	     */
         } catch (Exception e) {
  	       e.printStackTrace();
       }
	
}

}
