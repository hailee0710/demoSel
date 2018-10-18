package SeleniumGlueCode.Search;

import java.util.Date;

import com.vimalselvam.cucumber.listener.Reporter;

import SeleniumGlueCode.BaseStepDefinition.BaseStep;
import Utilities.DataProvider;
import Utilities.GetScreenShot;
import Utilities.PageObjectManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;

public class TestSearch extends BaseStep{
	
	@Before
	public void before(Scenario scenario) {
	    this.scenario = scenario;
	}
	
	@After
	public void tearDown() {
		if(scenario.isFailed()) {
			Reporter.setTestRunnerOutput(scenario.getStatus() + " --------------------------</br>");
			driver.close();
			}
	}
	
	@Given("^user is on HomePage$")
    public void user_is_on_HomePage() throws Throwable {  
		setUp("Start testing Search Feature");
       	Reporter.setTestRunnerOutput("user is on homepage </br>");
    }
	
	@When("^user enters Printed Summer Dress into search field$")
	public void user_enters_Printed_Summer_Dress_into_search_field() throws Throwable{
		Date date = new Date();
		dataProvider = new DataProvider(); 
		pageObjectManager = new PageObjectManager(driver);
    	homePage = pageObjectManager.getHomePage();
        homePage.enterSearchTerm(dataProvider.getData("\\Data\\Search_data.txt", 0));
        
        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, dateFormat.format(date)));
    	Reporter.setTestRunnerOutput("user enters Printed Summer Dress into search field </br>");

	}
	
	@When("^user clicks on Printed Summer Dress in suggestion$")
	public void user_clicks_on_Printed_Summer_Dress_in_suggestion() throws Throwable{
		Date date = new Date();
        Thread.sleep(5000);
        Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, dateFormat.format(date)));
        homePage.clickSuggestion();
        
        
    	Reporter.setTestRunnerOutput("user clicks on Printed Summer Dress in suggestion </br>");
        
	}
	
	@Then("^Printed Summer Dress PDP is displayed$")
	public void Printed_Summer_Dress_PDP_is_displayed() throws Throwable{
		Date date = new Date();
		productDetailsPage = pageObjectManager.getProductDetailsPage();
		Assert.assertEquals(dataProvider.getData("\\Data\\Search_data.txt", 0), productDetailsPage.getProductName());
		
		Reporter.addScreenCaptureFromPath(GetScreenShot.capture(driver, dateFormat.format(date)));
    	Reporter.setTestRunnerOutput("Printed Summer Dress PDP is displayed </br> --------------------------<br>");
    	driver.close();
	}
	
}
