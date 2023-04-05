package com.m.selenium;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

	public static void main(String[] args) {
		
		
		
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manisha\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://www.wikipedia.org/");
        WebElement englishButton =  driver.findElement(By.id("js-link-box-en"));
        englishButton.click();
        String expectedTitle = "Welcome to Wikipedia,"; 
        
        WebElement titleOfEnglishPage = driver.findElement(By.id("mp-welcome"));
        
        if(titleOfEnglishPage.getText().equals(expectedTitle)) {
        	
        	System.out.println("Pass");
        }else {
        	System.out.println("Fail");
        }
        
       

       


	}

}
