package com.compgoparts.utilities;

import java.util.LinkedList;

import org.testng.Assert;

import com.compgoparts.datainitialization.DataInt;



public class Util {
	
	public static String excep;


	public static LinkedList<Object[]> getLoginData(String sheetName1,Xls_Reader xls) {
	
		LinkedList<Object[]> logindata = new LinkedList<Object[]>();
	
		try {
			DataInt dataInitialization = null;
			int dataStartRowNum = 3;
			int totalRows = 0;
	
			while (!xls.getCellData(sheetName1, 0, dataStartRowNum + totalRows).equals("")) {
				
				totalRows++;
			}
	
			for (int i = dataStartRowNum; i <= (dataStartRowNum + totalRows); i++) {
	
				dataInitialization = new DataInt();
				Object obj[] = new Object[1];
	
				if (xls.getCellData(sheetName1, 0, i).equalsIgnoreCase("Login")) {
	                 dataInitialization.setEmail(xls.getCellData(sheetName1, 1, i));
	                 dataInitialization.setPassword(xls.getCellData(sheetName1, 2, i));
					
					obj[0] = dataInitialization;
					logindata.add(obj);
				}
			}
	
				} catch (Exception e) {
					 excep=e.toString();
					 Assert.fail(excep);
					 e.printStackTrace();
			
				}
			return logindata;
	
	    }
	

}
