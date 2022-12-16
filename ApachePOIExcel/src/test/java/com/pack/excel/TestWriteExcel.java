package com.pack.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestWriteExcel {

	public static void main(String[] args) throws Exception {
//Older Version of Excel
		/*HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("TestSheet");
		sheet.createRow(0);
		sheet.getRow(0).createCell(0).setCellValue("Anil");
		sheet.getRow(0).createCell(1).setCellValue("kumar");

		sheet.createRow(1);
		sheet.getRow(1).createCell(0).setCellValue("Abc");
		sheet.getRow(1).createCell(1).setCellValue("Xyz");

		File file = new File("C:\\Capgemini\\ApachePOIExcel\\src\\test\\ExcelFiles\\Test1.xls");
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		workbook.close();*/
		
		//New Version Of Excel
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("TestSheet");
		sheet.createRow(0);
		sheet.getRow(0).createCell(0).setCellValue("Anil");
		sheet.getRow(0).createCell(1).setCellValue("kumar");

		sheet.createRow(1);
		sheet.getRow(1).createCell(0).setCellValue("Abc");
		sheet.getRow(1).createCell(1).setCellValue("Xyz");

		File file = new File("C:\\Capgemini\\ApachePOIExcel\\src\\test\\ExcelFiles\\Test2.xlsx");
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		workbook.close();
	}

}
