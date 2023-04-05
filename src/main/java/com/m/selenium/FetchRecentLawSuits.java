package com.m.selenium;


import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchRecentLawSuits {
	public static void main(String[] args) throws InterruptedException {
		// set the path of the chromedriver.exe file

		WebDriverManager.chromedriver().setup();
		// initialize ChromeDriver
		WebDriver driver = new ChromeDriver();
		// navigate to the web page
		driver.get("https://www.accessibility.com/digital-lawsuits");

		// maximize the browser window
		driver.manage().window().maximize();

		String firstWindow = driver.getWindowHandle();
		System.out.println("Main Page Title is: ");
		String HomePageTitle = driver.getTitle();
		System.out.println(HomePageTitle);
		System.out.println("-------------------------------------------------------------------");
		Thread.sleep(2000);

		// locating the section of that contains the links of all recent lawsuits
		
		WebElement OpenRecentlawsuits = driver
				.findElement(By.xpath("//div[@id='hs_cos_wrapper_module_1588269158057329']"));

		List<WebElement> TotalRecentLS = OpenRecentlawsuits.findElements(By.tagName("a"));
		System.out.println("In This URL Number of Recent lawsuits are:" + TotalRecentLS.size());
		System.out.println("-------------------------------------------------------------------");
		
		System.out.println("Opening Each Recent law Suits Page in new Browser tab");
		for (int i = 0; i < TotalRecentLS.size(); i++) {
			String OpenTabs = Keys.chord(Keys.CONTROL, Keys.ENTER);
			TotalRecentLS.get(i).sendKeys(OpenTabs);
		}
		System.out.println("-------------------------------------------------------------------");
		System.out.println("All law suits successfully opened in new tab of browser");
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			driver.switchTo().window(window);
			Thread.sleep(2000);
			System.out.println("-------------------------------------------------------------------");
			System.out.println("Next Law Suits Here:");
			
			// Write Here Code & logic to Get Plintiff & Defendent info of recent lawsuits 
			
			//For Plintiff- 
			List<WebElement> FetchPlintiffinfo = driver.findElements(By.className("plaintiff_content"));
			for (WebElement getplaintiff_content : FetchPlintiffinfo) {
			System.out.println("-------------------------------------------------------------------");
			System.out.println("Plintiff Info For: " + driver.getTitle());
			System.out.println(getplaintiff_content.getText());
			
			}

			//For Defendent- 
			List<WebElement> FetchDefendedntinfo = driver.findElements(By.className("defendant_content"));
			for (WebElement getdefendant_content : FetchDefendedntinfo) {
			System.out.println("-------");
			System.out.println("Defedent Info for: " + driver.getTitle());
			System.out.println(getdefendant_content.getText());
			}

			if (driver.getTitle().equals("Digital Accessibility Lawsuits")) {
				driver.close();
				System.out.println("Main Page for all Recent Law suit closed & Opening next Law suit page in new tab");
			}
		}
	}
}