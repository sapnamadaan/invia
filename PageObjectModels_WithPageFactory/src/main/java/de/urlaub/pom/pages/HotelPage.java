package de.urlaub.pom.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import de.urlaub.pom.base.BasePage;
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

	public void searchHotel(String city, String checkInDate, String checkOutDate) {
		HOTEL_SEARCH_STADT_TEXT_INPUT.sendKeys(city);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		HOTEL_SEARCH_STADT_TEXT_INPUT.sendKeys(Keys.ARROW_DOWN);
		HOTEL_SEARCH_STADT_TEXT_INPUT.sendKeys(Keys.ENTER);

		selectCalender(checkInDate, HOTEL_SEARCH_BOOK_TEXT_ENTRY_DATE);
		selectCalender(checkOutDate, HOTEL_SEARCH_BOOK_TEXT_END_DATE);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ANGEBOTE_SUCHEN_BUTTON.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		

		wait.until(ExpectedConditions.visibilityOf(RESULT_FIRST_FRAME));

		FIVE_STAR_RATING.click();
		PREIS_BUTTON.click();
		PREIS_BUTTON.click();

	}

	private void selectCalender(String setDateStr, WebElement calender) {
		calender.click();
		String currDateStr = driver.findElement(By.className("months-wrapper")).getText();
		Date setDate;
		try {
			setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDateStr);
			Date currDate = new SimpleDateFormat("MMMM yyyy", Locale.GERMAN).parse(currDateStr);
			int monthDiff = Months
					.monthsBetween(new DateTime(currDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1))
					.getMonths();
			boolean isFuture = true;
			if (monthDiff < 0) {
				isFuture = false;
				monthDiff = -1 * monthDiff;
			}
			for (int i = 0; i < monthDiff; i++) {
				if (isFuture) {
					driver.findElement(
							By.xpath("//span[@class='month-button month-button-next icon-arrow-right-bold']")).click();
				} else {
					driver.findElement(
							By.xpath("//span[@class='month-button month-button-prev icon-arrow-left-bold inactive']"))
							.click();
				}

			}
			String day = new SimpleDateFormat("dd").format(setDate);
			List<WebElement> elements = driver.findElements(By.xpath("//td[@class='day day-" + day + "']"));
			elements.forEach(e -> {

				try {
					Date checkDate = new SimpleDateFormat("yyyy-MM-dd").parse(e.getAttribute("data-date"));
					if (checkDate.compareTo(setDate) == 0) {
						e.click();
						if (e.isDisplayed())
							e.click();
					}
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
