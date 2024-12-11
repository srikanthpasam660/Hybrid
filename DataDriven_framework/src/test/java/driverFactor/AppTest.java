package driverFactor;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Config.Base;
import applicationLayer.AddEmpy;
import utilities.ExcelFileUtil;

public class AppTest extends Base{
 String inputpath ="./FileInput/fileinput.xlsx";
 String Outpath ="E:\\Live_Project\\DataDriven_framework\\Fileoutput\\DataDrivenReport.xlsx";
 String TcSheet = "Emp";
 ExtentReports reports;
 ExtentTest logger;
 @Test
 public void starttest()throws Throwable {
	 reports = new  ExtentReports("./target/reports/AddEmp.html");
	 ExcelFileUtil xl = new ExcelFileUtil(inputpath);
	 int rc = xl.rowCount(TcSheet);
	 logger=reports.startTest("Validate Add Emp");
		logger.assignAuthor("srikanth");
	 for(int i=1; i<=rc;i++) {
		 
		 String Fname = xl.getCellData(TcSheet, i, 0);
		 String Mname = xl.getCellData(TcSheet, i, 1);
		 String Lname = xl.getCellData(TcSheet, i, 2);
		 logger.log(LogStatus.INFO,Fname+"  "+ Mname+"  "+Lname);
		 
		 AddEmpy emp = PageFactory.initElements(driver, AddEmpy.class);
		 
		 Boolean res = emp.verifyEmp(Fname, Mname, Lname);
		 if(res) {
			 xl.setCellData(TcSheet, i,3, "pass",Outpath);
			 logger.log(LogStatus.PASS,"Add Employee Success" );
		 }
		 else {
			 xl.setCellData(TcSheet, i, 3,"Fail",Outpath);
			 logger.log(LogStatus.FAIL,"Add Employee Fail");
		 }
		 reports.endTest(logger);
		 reports.flush();
	 }
	 }
	 
 }
	

