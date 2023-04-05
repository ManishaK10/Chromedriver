package com.m.selenium;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Select {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		co.setHeadless(true);
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("oppo");
		List<WebElement> list = driver.findElements(By.cssSelector("ul li.sbct"));
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().equalsIgnoreCase("oppo a17")) {
				list.get(i).click();
			}
		}

	}

}
