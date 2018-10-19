package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//Get all elements of Home Page
public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//get Sign in
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	private WebElement signInBtn;
	
	public void clickSignIn() {
		
		signInBtn.click();
	}
	
	//get Search field
	@FindBy(id="search_query_top")
	private WebElement searchField;
	
	public void enterSearchTerm(String term) {
		searchField.sendKeys(term);
	}
	
	//get Suggestion
	@FindBy(xpath="/html/body/div[2]/ul/li[1]")
	private WebElement suggestion;
	
	public void clickSuggestion() {
		suggestion.click();
	}
}
