package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogin {

	@FindBy(id = "txtUsername")
	WebElement objUsername;
	@FindBy(name = "txtPassword")
	WebElement objPassword;
	@FindBy(xpath="//input[@id='btnLogin']")
	WebElement objlogin;
	
	public void verifyloing(String user,String pass) {
		objUsername.sendKeys(user);
		objPassword.sendKeys(pass);
		objlogin.click();
		
	}
	
}
