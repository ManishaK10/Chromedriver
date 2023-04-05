package com.m.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class LumaBag {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		// initialize ChromeDriver
		WebDriver driver = new ChromeDriver();
		// navigate to the web page
		driver.get("https://magento.softwaretestingboard.com/gear/bags.html");

		// maximize the browser window
		driver.manage().window().maximize();
		
		String firstWindow = driver.getWindowHandle();
		System.out.println("Main Page Title is: ");
		String HomePageTitle = driver.getTitle();
		System.out.println(HomePageTitle);
		System.out.println("-------------------------------------------------------------------");
		Thread.sleep(2000);
		if (driver.getTitle().equals("Bags-Gear")) {
			driver.close();
			System.out.println("test case pass");
		}
	}

}
