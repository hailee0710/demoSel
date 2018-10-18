package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {
	
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div/div/div[3]/h1")
	private WebElement productName;
	
	//get product name
	public String getProductName() {
		return productName.getText();
	}
}
