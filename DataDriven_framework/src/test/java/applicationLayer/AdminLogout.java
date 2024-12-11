package applicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Config.Base;

public class AdminLogout extends Base {
	public AdminLogout(WebDriver driver){
		this.driver = driver;
	}

	@FindBy(linkText = "Welcome Suresh")
	WebElement objtxt;
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement objLogout;
	public void adminLogout() throws Throwable {
		 objtxt.click();
		 Thread.sleep(2000);
		 objLogout.click();
		
	}
	
		
	}

