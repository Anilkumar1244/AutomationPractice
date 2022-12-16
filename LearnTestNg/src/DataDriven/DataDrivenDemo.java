package DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import pomWithPageFactory.Utility;

public class DataDrivenDemo {
	
	public static void validateLoginData(String filePath,String fileName,String sheetName) throws IOException
	{
		String baseUrl="http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
		String expectedTitle="Web Orders";
		String actualTitle=null;
		
		String uName=null;
		String passwd=null;
		
		WebDriver driver=Utility.launchApplication(1, baseUrl);
		
		File file=new File(filePath + "\\" + fileName);
		 
		FileInputStream inp=new FileInputStream(file);
		
		FileOutputStream out=null;
		Workbook wBook=null;
		
		String fileExtn=fileName.substring(fileName.indexOf("."));
		System.out.println(fileExtn);
		
		if(fileExtn.equals(".xlsx"))
		{
			wBook=new XSSFWorkbook(inp);
		}
		else
		{
			wBook=new HSSFWorkbook(inp);
		}
		
		//Sheet sheet=wBook.getSheet(sheetName);
		
	}

	public static void main(String[] args) {
		

	}

}
