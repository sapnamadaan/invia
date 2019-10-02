package de.urlaub.pom.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import de.urlaub.pom.base.BasePage;
import de.urlaub.pom.util.DateSelector;
import de.urlaub.pom.util.URConstants;

public class HotelPage extends BasePage {
	@FindBy(xpath = URConstants.HOTEL_SEARCH_STADT_TEXT_INPUT)
	public WebElement HOTEL_SEARCH_STADT_TEXT_INPUT;

	@FindBy(xpath = URConstants.HOTEL_SEARCH_BOOK_TEXT_ENTRY_DATE)
	public WebElement HOTEL_SEARCH_BOOK_TEXT_ENTRY_DATE;

	@FindBy(xpath = URConstants.HOTEL_SEARCH_BOOK_TEXT_END_DATE)
	public WebElement HOTEL_SEARCH_BOOK_TEXT_END_DATE;

	@FindBy(xpath = URConstants.KINDER_TEXT_INPUT)
	public WebElement KINDER_TEXT_INPUT;

	@FindBy(xpath = URConstants.ZIMMER_TEXT_INPUT)
	public WebElement ZIMMER_TEXT_INPUT;

	@FindBy(xpath = URConstants.ANGEBOTE_SUCHEN_BUTTON)
	public WebElement ANGEBOTE_SUCHEN_BUTTON;

	@FindBy(xpath = URConstants.HOTEL_SEARCH_BOOK_DEPART_DATE)
	public WebElement ANGEBOTE_SDEPAR_BUTTON;

	@FindBy(xpath = URConstants.FIVE_STAR_RATING)
	public WebElement FIVE_STAR_RATING;

	@FindBy(xpath = URConstants.PREIS_BUTTON)
	public WebElement PREIS_BUTTON;

	@FindBy(xpath = URConstants.RESULT_FIRST_FRAME)
	public WebElement RESULT_FIRST_FRAME;

	public HotelPage(WebDriver driver) {
		super(driver);
	}

	public void setCity(String city) {
		HOTEL_SEARCH_STADT_TEXT_INPUT.sendKeys(city);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='aiduac-group 1']//li//li")));
		List<WebElement> autoSuggest = driver.findElements(By.xpath("//ul[@class='aiduac-group 1']//li//li"));
		driver.switchTo().activeElement();
		for (WebElement a : autoSuggest) {
			if (a.getText().contains(city)) {
				a.click();
				break;
			}
		}
	}

	public void setCheckInDate(String checkInDate) {
		DateSelector.selectCalender(checkInDate, HOTEL_SEARCH_BOOK_TEXT_ENTRY_DATE, this.driver);
	}

	public void setCheckOutDate(String checkOutDate) {
		DateSelector.selectCalender(checkOutDate, HOTEL_SEARCH_BOOK_TEXT_END_DATE, this.driver);
	}

	public void clickOnSearchButton() {
		ANGEBOTE_SUCHEN_BUTTON.click();
	}

	public void setFiveStartRating() {			
		FIVE_STAR_RATING.click();
	}

	public void sortPrice() {
		PREIS_BUTTON.click();
		
	}

}
