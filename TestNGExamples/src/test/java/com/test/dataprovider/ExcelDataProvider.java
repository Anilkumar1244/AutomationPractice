package com.test.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	
	@DataProvider(name="loginTestData")
	public String[][] getData() throws Exception
	{
		File excelfile = new File("C:\\PracticeTestNG\\src\\test\\resources\\ExcelTest.xlsx");
		//System.out.println(excelfile.exists());
		FileInputStream fis = new FileInputStream(excelfile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		//System.out.println(sheet.getPhysicalNumberOfRows());
		//System.out.println(sheet.getLastRowNum());
		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[noOfRows-1][noOfColumns];
		for(int i=0;i<noOfRows-1;i++) {
			for(int j=0;j<noOfColumns;j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
				//System.out.println(df.formatCellValue(sheet.getRow(i+1).getCell(j)));
				//System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			}
		}
		workbook.close();
		fis.close();
		
		//for (String[] dataarr : data) {
			//System.out.println(Arrays.toString(dataarr));
		//}
		return data;
	}

}
