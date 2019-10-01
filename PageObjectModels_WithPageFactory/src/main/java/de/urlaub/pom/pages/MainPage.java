package de.urlaub.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import de.urlaub.pom.base.BasePage;
import de.urlaub.pom.util.URConstants;

public class MainPage extends BasePage {

	@FindBy(xpath = URConstants.HotelMenu)
	public WebElement HotelMenu;

	@FindBy(xpath = URConstants.WARNING_OK_BUTTON)
	public WebElement WARNING_OK_BUTTON;

	MainPage(WebDriver driver) {
		super(driver);
	}

	public HotelPage gotoHotelPage() {
		//if (WARNING_OK_BUTTON.isDisplayed()) {
			//WARNING_OK_BUTTON.click();
		//}
		HotelMenu.click();
		return PageFactory.initElements(driver, HotelPage.class);

	}
	
	public HotelPage2 gotoHotelPage2() {
		//if (WARNING_OK_BUTTON.isDisplayed()) {
			//WARNING_OK_BUTTON.click();
		//}
		HotelMenu.click();
		return PageFactory.initElements(driver, HotelPage2.class);

	}

}
