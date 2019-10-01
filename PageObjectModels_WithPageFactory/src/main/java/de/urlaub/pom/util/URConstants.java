package de.urlaub.pom.util;

public class URConstants {
	
	//paths
	public static final String CHROME_DRIVER_EXE="D:\\chromedriver.exe";
	public static final String REPORTS_PATH="D:\\Urlaub\\Reports";
	public static final String WARNING_OK_BUTTON= "//button[@id='CybotCookiebotDialogBodyButtonAccept']";
	public static final String HOTEL_SEARCH_STADT_TEXT_INPUT="//input[@id='base[searchTerm]']";
	public static final String HOTEL_SEARCH_BOOK_TEXT_ENTRY_DATE="//div[@class='datepicker-input-wrapper datepicker-input-wrapper-start']//div[@class='datepicker-trigger']";
	public static final String HOTEL_SEARCH_BOOK_DEPART_DATE = "//*[@id=\"depDate\"]";
	public static final String HOTEL_SEARCH_BOOK_TEXT_END_DATE="//div[@class='datepicker-input-wrapper datepicker-input-wrapper-end']//div[@class='datepicker-trigger']";
	public static final String KINDER_TEXT_INPUT="//input[@id='travellerSummary']";
	public static final String ZIMMER_TEXT_INPUT="//select[@id='base[numberOfRooms]']";
	public static final String ANGEBOTE_SUCHEN_BUTTON="//input[@id='submit']";
	public static final String FIVE_STAR_RATING="//span[contains(@class,'select-icon hc-icon-star-50')]";
	public static final String PREIS_BUTTON="//li[contains(text(),'Preis')]\")";
	public static final String RESULT_FIRST_FRAME="//body[contains(@class,'laDE ltDE lsDE lDEDE has-banner-ads-enabled js noIE has-feature-fuh-linkout')]/div[@id='wrap']/div[@id='main']/main[@id='pageWrapper']/div[contains(@class,'row')]/div[contains(@class,'small-12 xlarge-9 small-order-1 xlarge-order-2 columns content js-ad-offset-top')]/div[contains(@class,'lastUnit contentWrapperWithSidebar row')]/div[contains(@class,'content-unit hotelResults small-12 columns')]/div[contains(@class,'row')]/div[@id='hotel-list']/div[contains(@class,'js-baseFrame-container')]/div[contains(@class,'js-baseFrame-hotelBoxList')]/div[1]/div[2]/div[1]/div[1]\")))";
	
	//locators
	public static final String HotelMenu="//a[@title='Hotel']";

	
	//URLs
	public static final String MAINPAGE_URL ="https://www.ab-in-den-urlaub.de";
	public static final String DATA_XLS_PATH = null;
	
}
