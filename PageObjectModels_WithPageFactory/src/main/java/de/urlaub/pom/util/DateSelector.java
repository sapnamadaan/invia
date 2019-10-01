package de.urlaub.pom.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DateSelector {
	
	public static void selectCalender(String setDateStr, WebElement calender,WebDriver driver) {
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
