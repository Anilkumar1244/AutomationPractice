package com.test.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LogDiffInformation {

	public static void main(String[] args) throws Exception {
		ExtentReports extentReports = new ExtentReports();
		//Relative Path
		File file = new File("Report.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		//Absolute Path
		//ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Capgemini\\MavenExtentReportPractice\\Report.html");
		extentReports.attachReporter(sparkReporter);

		//Text(Bold,Italic)
		extentReports
		.createTest("Text Based Data")
		.log(Status.INFO, "Info")
		.log(Status.INFO, "<b>Info</b>")//<b>-->Bold
		.log(Status.INFO, "<i>Info</i>")//<i?-->Italic
		.log(Status.INFO, "<b><i>Info</i></b>");

		String XMLData = "<menu id=\"file\" value=\"File\">\r\n"
				+ "  <popup>\r\n"
				+ "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\r\n"
				+ "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\r\n"
				+ "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\r\n"
				+ "  </popup>\r\n"
				+ "</menu>";
		
		String JSONData = "{\"menu\": {\r\n"
				+ "  \"id\": \"file\",\r\n"
				+ "  \"value\": \"File\",\r\n"
				+ "  \"popup\": {\r\n"
				+ "    \"menuitem\": [\r\n"
				+ "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n"
				+ "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
				+ "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n"
				+ "    ]\r\n"
				+ "  }\r\n"
				+ "}}";
		
		//XML
		extentReports
		.createTest("XML Based Data")
		.info(MarkupHelper.createCodeBlock(XMLData,CodeLanguage.XML));
		
		//JSON
		extentReports
		.createTest("XML Based Data")
		.log(Status.INFO,MarkupHelper.createCodeBlock(JSONData,CodeLanguage.JSON));

		//Collection(List)
		List<String> listData = new ArrayList<String>();
		listData.add("Anil");
		listData.add("kumar");
		listData.add("ABC");
		
		//Collection(Map)
		Map<Integer, String> mapData = new HashMap<Integer, String>();
		mapData.put(101,"Anil");
		mapData.put(102,"kumar");
		mapData.put(103,"ABC");
		
		//Collection(Set)
		Set<Integer> setData = mapData.keySet();
		
		extentReports
		.createTest("List Based Data")
		.info(MarkupHelper.createOrderedList(listData))
		.info(MarkupHelper.createUnorderedList(listData));

		extentReports
		.createTest("Map Based Data")
		.info(MarkupHelper.createOrderedList(mapData))
		.info(MarkupHelper.createUnorderedList(mapData));

		extentReports
		.createTest("Set Based Data")
		.info(MarkupHelper.createOrderedList(setData))
		.info(MarkupHelper.createUnorderedList(setData));

		//Highlighted any Message
		extentReports
		.createTest("Highlight Log Test")
		.info("This is not a highlighted Message")
		.info(MarkupHelper.createLabel("This is a highlighted Message", ExtentColor.GREEN));
		
		//Exception
		try {
			int i = 5/0;
		} catch (Exception e) {
			extentReports
			.createTest("Exception Log Test1")
			.fail(e);
		}
		
		Throwable t = new RuntimeException("This is a custom Exception");
		extentReports
		.createTest("Exception Log Test2")
		.fail(t);
		
		extentReports.flush();
		Desktop.getDesktop().browse(new File("Report.html").toURI());

	}

}
