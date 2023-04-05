package com.m.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		// initialize ChromeDriver
		WebDriver driver = new ChromeDriver();
		// navigate to the web page
		driver.get("https://www.google.com/");

		// maximize the browser window
		driver.manage().window().maximize();
		
		WebElement tb = driver.findElement(By.cssSelector("#input"));
		tb.sendKeys("automation");
		
		List<WebElement> selectDrop =driver.findElements(By.xpath("/(//ul//li//b)[4]"));
		for(int i=0;i<selectDrop.size();i++) {
			System.out.println(selectDrop.get(i).getText());
			if (selectDrop.get(i).getText().contains("tools")) {
				selectDrop.get(i).click();
			}
		}
	
	}

}
