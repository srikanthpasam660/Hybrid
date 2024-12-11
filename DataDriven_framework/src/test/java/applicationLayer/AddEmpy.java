
package applicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import Config.Base;

public class AddEmpy  extends Base{
public AddEmpy(WebDriver driver) {
	this.driver = driver;
}
@FindBy(xpath = "//b[normalize-space()='PIM']")
WebElement objPIM;
@FindBy(linkText ="Add Employee")
WebElement objAdd;
@FindBy(name = "firstName")
WebElement objfirstName;
@FindBy(name = "middleName")
WebElement objmiddleName;
@FindBy(name = "lastName")
WebElement objlastName;
@FindBy(xpath = "//input[@id='employeeId']")
WebElement objeid;
@FindBy(xpath = "//input[@id='btnSave']")
WebElement objSave;
@FindBy(xpath = "//input[@id='personal_txtEmployeeId']")
WebElement objid;
public boolean verifyEmp(String firstName,String middleName,String lastName ) {
 
	Actions act = new Actions(driver);
	act.moveToElement(objPIM).click().perform();
	act.moveToElement(objAdd).click().perform();
	 objfirstName.sendKeys(firstName);
	 objmiddleName.sendKeys(middleName);
	 objlastName.sendKeys(lastName);
	 boolean res=false;
	 String Exp_Data = objeid.getAttribute("Value");
	 objSave.click();
	 String Act_data =objid.getAttribute("value");
		if(Act_data.equals(Exp_Data))
		{
			return true;
		}
		else
		{
			return false;
		}
	 
		 
	}
	}
	
	
	
	

