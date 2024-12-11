package Config;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import applicationLayer.AdminLogin;
import applicationLayer.AdminLogout;

public class Base {
	public static WebDriver driver;
	public static Properties conpro;
	 @BeforeTest
	 public static void setup()throws Throwable
	 {
		 conpro = new Properties();
		 conpro.load(new FileInputStream("./PropertyFile\\EnvironmentalVarible.properties"));
		 if(conpro.getProperty("Browser").equalsIgnoreCase("firefox")){
			  driver = new ChromeDriver();
			  driver.manage().window().maximize();
			  driver.get(conpro.getProperty("url"));
			   
			  AdminLogin login = PageFactory.initElements(driver, AdminLogin.class );
			  login.verifyloing("Admin","Qedge123!@#");
		 }
		 else if(conpro.getProperty("Browser").equalsIgnoreCase("firefox")) {
		 driver = new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.get(conpro.getProperty("url"));
		   
		  AdminLogin login = PageFactory.initElements(driver, AdminLogin.class );
		 }
		 else {
			 Reporter.log("invalid Browser", true);
		}
	 }
	 @AfterTest
	 public static void tearDown() throws Throwable
	 {
	 	AdminLogout logout = PageFactory.initElements(driver, AdminLogout.class);
	 	logout.adminLogout();
	 	driver.quit();
	 
	 }
}
