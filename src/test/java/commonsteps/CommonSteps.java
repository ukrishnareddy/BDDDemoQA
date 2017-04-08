package commonsteps;

import java.util.concurrent.TimeUnit;

import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.web.selenium.PerStoryWebDriverSteps;
import org.jbehave.web.selenium.PropertyWebDriverProvider;
import org.jbehave.web.selenium.WebDriverProvider;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.HomePage;

public class CommonSteps extends PerStoryWebDriverSteps{
	
	public WebDriverProvider driverProvider;
	
	public CommonSteps(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	@BeforeStory
	public void beforeStory(){
	  driverProvider.initialize();
	  driverProvider.get().get("http://demoqa.com");;
	  driverProvider.get().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	
	@AfterStories
	public void AfterStory(){
		driverProvider.end();;
	}
	
	@Given("customer open HomePage")
	public void verifyHomePage(){
		Assert.assertTrue("Home Page URL Is Wrong", driverProvider.get().getTitle().equals(HomePage.url));
		Assert.assertTrue("Home Page Title Is Wrong", driverProvider.get().getTitle().equals(HomePage.homePageTitle));
	}
	
	@When("I click on $Registration button")
	public void clickRegistration(String Name) throws Exception{
		WebElement registrationElement = driverProvider.get().findElement(HomePage.registrationLoc);
		if(registrationElement.isDisplayed() && registrationElement.isEnabled()){
			registrationElement.click();
			
		}
	}
	
	@Then("Registration page is opened")
	public void verifyPageOpened(){
		WebDriverWait wait = new WebDriverWait(driverProvider.get(), 60);
		wait.until(ExpectedConditions.titleContains(HomePage.registrationTitle));
		Assert.assertTrue("Regisration Title Is Wrong", driverProvider.get().getTitle().equals(HomePage.registrationTitle));
	}
}
