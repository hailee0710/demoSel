package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {
	
	public CreateAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="id_gender1")
	private WebElement title;
	
	@FindBy(id="customer_firstname")
	private WebElement fname;
	
	@FindBy(id="customer_lastname")
	private WebElement lname;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="passwd")
	private WebElement passwd;
	
	@FindBy(id="days")
	private WebElement selectDays;
	
	@FindBy(id="months")
	private WebElement selectMonths;
	
	@FindBy(id="years")
	private WebElement selectYears;
	
	@FindBy(id="address1")
	private WebElement address;
	
	@FindBy(id="city")
	private WebElement city;
	
	@FindBy(id="id_state")
	private WebElement selectState;
	
	@FindBy(id="postcode")
	private WebElement postcode;
	
	@FindBy(id="days")
	private WebElement select;
	
	@FindBy(id="phone_mobile")
	private WebElement phone_mobile;
	
	@FindBy(id="submitAccount")
	private WebElement submitAccount;
	
	//select title
	public void selectTitle() {
		
		title.click();
	}
	
	//fill in first name
	public void enterFirstName(String strFName) {
		
		fname.sendKeys(strFName);
	}
	
	//fill in last name
	public void enterLastName(String strLName) {
			
		lname.sendKeys(strLName);
	}
		
	//fill in email
	public void enterEmail(String strEmail) {
			
		email.sendKeys(strEmail);
	}		

	//fill in Password
	public void enterPassword(String strPasswd) {
				
		passwd.sendKeys(strPasswd);
	}
	//Select date
	public void selectDate(String strDate) {
						
		Select days = new Select(selectDays);
		days.selectByValue(strDate);
	}
	
	//Select month
	public void selectMonth(String strMonth) {
						
		Select months = new Select(selectMonths);
		months.selectByValue(strMonth);
	}	
	
	//Select year
	public void selectYear(String strYear) {
						
		Select years = new Select(selectYears);
		years.selectByValue(strYear);
	}
	
	//fill in address
	public void enterAddress(String strAddress) {
		
		address.sendKeys(strAddress);
	}
	
	//fill in City
	public void enterCity(String strCity) {
			
		city.sendKeys(strCity);
	}
	
	//select state
	public void selectState(String strState) {
		
		Select states = new Select(selectState);
		states.selectByVisibleText(strState);
	}
	
	//fill in postcode
	public void enterPostcode(String strPostcode) {
			
		postcode.sendKeys(strPostcode);
	}
	
	//fill in Mobile Phone
	public void enterMobile(String strMobile) {
			
		phone_mobile.sendKeys(strMobile);
	}
	
	//click on Register button
	public void clickRegisterBtn() {
		
		submitAccount.click();
	}
	
}
