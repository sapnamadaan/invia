package de.urlaub.pom.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import de.urlaub.pom.pages.common.TopMenu;

public class BasePage {
	public WebDriver driver;
	public TopMenu menu;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		menu=PageFactory.initElements(driver, TopMenu.class);
	}
	
	
	
/*	public String verifyTitle(String expTitle) {
		return " ";
		
		public String verifyText(String locator, String expText) {
			
		}
			
		public String VerifyElementPresent() {
			
		}*/
	
	public TopMenu getMenu() {
		return menu;
		
	}

}
