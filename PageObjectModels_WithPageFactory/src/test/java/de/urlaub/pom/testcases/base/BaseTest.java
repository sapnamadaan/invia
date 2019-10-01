package de.urlaub.pom.testcases.base;

import javax.xml.stream.XMLEventReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import de.urlaub.pom.util.ExtentManager;
import de.urlaub.pom.util.URConstants;

public class BaseTest {
	
	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest test;
	//public XMLEventReader xls = new XMLEventReader(URConstants.DATA_XLS_PATH);

	
	WebDriver driver;

	public void init(String bType)
	{
		if(bType.equals("Mozilla"))
			driver=new FirefoxDriver();
		else if(bType.contentEquals("Chrome"))
			System.setProperty("webDriver.chrome.driver",URConstants.CHROME_DRIVER_EXE );
			driver=new ChromeDriver();
	}
	
	
	

}
