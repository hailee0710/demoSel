package Utilities;

import org.openqa.selenium.WebDriver;

import PageFactory.CreateAccountPage;
import PageFactory.HomePage;
import PageFactory.LoginPage;
import PageFactory.MyAccountPage;
import PageFactory.ProductDetailsPage;

public class PageObjectManager {

	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private MyAccountPage myAccountPage;
	private CreateAccountPage createAccountPage;
	private ProductDetailsPage productDetailsPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}
	
	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;

	}
	
	public MyAccountPage getMyAccountPage() {
		return (myAccountPage == null) ? myAccountPage = new MyAccountPage(driver) : myAccountPage;

	}
	
	public CreateAccountPage getCreateAccountPage() {
		return (createAccountPage == null) ? createAccountPage = new CreateAccountPage(driver) : createAccountPage;

	}
	
	public ProductDetailsPage getProductDetailsPage() {
		return (productDetailsPage == null) ? productDetailsPage = new ProductDetailsPage(driver) : productDetailsPage;

	}
}
