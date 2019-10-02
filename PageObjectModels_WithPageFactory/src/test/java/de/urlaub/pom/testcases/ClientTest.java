package de.urlaub.pom.testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import de.urlaub.pom.pages.HotelPage;
import de.urlaub.pom.pages.LaunchPage;
import de.urlaub.pom.pages.MainPage;

public class ClientTest {

	/**
	 * Test Case 1
	 */
	@Test
	public void testSearchHotel() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LaunchPage launchPage = PageFactory.initElements(driver, LaunchPage.class);
		MainPage mainPage = launchPage.gotoMainPage();
		driver.manage().window().maximize();
		// Got To Hotel Page
		HotelPage hotelPage = mainPage.gotoHotelPage();
		// Select City
		hotelPage.setCity("Madrid");
		// Select Check In Date
		hotelPage.setCheckInDate("25/11/2019");
		// Select Check Out Date
		hotelPage.setCheckOutDate("29/11/2019");		
		// Click on Search Button
		hotelPage.clickOnSearchButton();		
		// Select Five Start Hotel
		hotelPage.setFiveStartRating();
		// Change Price ascending
		hotelPage.sortPrice();
		// Change Price descending
		hotelPage.sortPrice();
	
	}

}
