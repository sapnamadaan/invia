package de.urlaub.pom.testcases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import de.urlaub.pom.pages.HotelPage;
import de.urlaub.pom.pages.HotelPage2;
import de.urlaub.pom.pages.LaunchPage;
import de.urlaub.pom.pages.MainPage;

public class ClientTest {

	
	/**
	 * Approach 1
	 * 
	 */
	@Test
	public void testBookingResult() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		LaunchPage launchPage = PageFactory.initElements(driver, LaunchPage.class);	
		MainPage mainPage = launchPage.gotoMainPage();	
		driver.manage().window().maximize();
		HotelPage hotelPage=mainPage.gotoHotelPage();
		hotelPage.searchHotel("Madrid","25/11/2019","29/11/2019");	
	}
	
	
	/**
	 * Approach 2
	 */
	@Test
	public void testAgain() {				
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LaunchPage launchPage = PageFactory.initElements(driver, LaunchPage.class);		
		MainPage mainPage = launchPage.gotoMainPage();		
		driver.manage().window().maximize();
		//Got To Hotel Page
		HotelPage2 hotelPage=mainPage.gotoHotelPage2();
		//Select City
		hotelPage.setCity("Madrid");	
		//Select Check In Date
		hotelPage.setCheckInDate("25/11/2019");
		//Select Check Out Date
		hotelPage.setCheckOutDate("29/11/2019");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//Click on Search Button
		hotelPage.clickOnSearchButton();
		//Select Five Start Hotel
		hotelPage.setFiveStartRating();
		//Change Price ascending 
		hotelPage.sortPrice();
		//Change Price descending 
		hotelPage.sortPrice();
	}

}
