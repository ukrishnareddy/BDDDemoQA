package PageObjects;

import org.openqa.selenium.By;

public class HomePage {
	
	public static String homePageTitle = "Demoqa | Just another WordPress site";
	public static String url = "http://demoqa.com/";
	
	
	public static String registrationName = "Registration";
	public static By registrationLoc = By.xpath(".//*[@id='menu-item-374']/a[text()='Registration']");
	
	public static String registrationTitle = "Registration | Demoqa";
	
	public HomePage(){
	
	}
}
