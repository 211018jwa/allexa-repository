package com.revature.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:/WebDrivers/chromedriver_win32/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:8080");
		
		WebElement addInput1 = driver.findElement(By.id("AddNum1"));
		WebElement addInput2 = driver.findElement(By.id("AddNum2"));
		WebElement addButton = driver.findElement(By.id("AddBtn"));
		
		addInput1.sendKeys("10.5");
		addInput2.sendKeys("15.3");
		addButton.click();
		
		driver.switchTo().frame("addResult");
		WebElement addOutput = driver.findElement(By.tagName("pre"));
		System.out.println("10.5 + 15.3 = " + addOutput.getText());
		
		driver.switchTo().defaultContent();
		
		WebElement subInput1 = driver.findElement(By.id("SubNum1"));
		WebElement subInput2 = driver.findElement(By.id("SubNum2"));
		WebElement subButton = driver.findElement(By.id("SubBtn"));
		
		subInput1.sendKeys("20.5");
		subInput2.sendKeys("15.3");
		subButton.click();
		
		driver.switchTo().frame("subResult");
		WebElement subOutput = driver.findElement(By.tagName("pre"));
		System.out.println("20.5 + 15.3 = " + subOutput.getText());
		
		driver.switchTo().defaultContent();
		
		WebElement mulInput1 = driver.findElement(By.id("MulNum1"));
		WebElement mulInput2 = driver.findElement(By.id("MulNum2"));
		WebElement mulButton = driver.findElement(By.id("MulBtn"));
		
		mulInput1.sendKeys("3.5");
		mulInput2.sendKeys("5.3");
		mulButton.click();
		
		driver.switchTo().frame("mulResult");
		WebElement mulOutput = driver.findElement(By.tagName("pre"));
		System.out.println("10.5 + 15.3 = " + mulOutput.getText());
		
		driver.switchTo().defaultContent();
		
		WebElement divInput1 = driver.findElement(By.id("DivNum1"));
		WebElement divInput2 = driver.findElement(By.id("DivNum2"));
		WebElement divButton = driver.findElement(By.id("DivBtn"));
		
		divInput1.sendKeys("12");
		divInput2.sendKeys("5");
		divButton.click();
		
		driver.switchTo().frame("divResult");
		WebElement divOutput = driver.findElement(By.tagName("pre"));
		System.out.println("10.5 + 15.3 = " + divOutput.getText());
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(5000);
		
		driver.quit();
	}
}
