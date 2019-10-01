package de.urlaub.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import de.urlaub.pom.base.BasePage;
import de.urlaub.pom.util.URConstants;

public class LaunchPage extends BasePage {
	
	
	public LaunchPage(WebDriver driver) {
		super(driver);
		
	}
	
	public MainPage gotoMainPage()
	{
		driver.get(URConstants.MAINPAGE_URL);
		MainPage mpage = new MainPage(driver);
		PageFactory.initElements(driver,mpage);
		return mpage;
	}
	
	

}
