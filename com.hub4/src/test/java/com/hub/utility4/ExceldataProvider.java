package com.hub.utility4;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExceldataProvider {
	XSSFWorkbook wb;
	
	public  ExceldataProvider()
	{
		File src=new File("./TestData2/Data.xlsx");
		try {
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		} 
	     catch (Exception e) {
	    	 System.out.println("Unable to read Excel file "+e.getMessage());
			
		}
	}
	
	public String getStringData(int sheetIndex,int row,int column) 
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(String sheetName,int row,int column) 
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
    public double getNumericalData(String sheetName,int row,int column)
    {
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();

    }

}
