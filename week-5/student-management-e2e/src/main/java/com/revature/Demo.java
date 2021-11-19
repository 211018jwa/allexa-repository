package com.revature;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo {
	
	public static void main(String[] args) {
		
		WebElement firstNameInput = driver.findElement(By.xpath("//input[@id='first-name']"));
		WebElement lastNameInput = driver.findElement(By.xpath("//input[@id='last-name']"));
		
		WebElement dropDownElement = driver.findElement(By.xpath("//input[@id='classification']"));
		Select classificationSelect = new Select(dropDownElement);
		
		WebElement ageInput = driver.findElement(By.xpath("//input[@id='age']"));
		WebElement addStudentButton = driver.findElement(By.xpath("//input[@id='student-submit']"));
		
		int numOfElements = driver.findElements(By.xpath("//div[@class='table-container']/table/tbody/tr")).size();
		
		addStudentButton.click();
		
		String mostRecentTrXpath = "//div[@class='table-container']/table/tbody/tr[" + (numOfElements + 1) + "]";
		
		WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wdw.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(mostRecentTrXpath))));
		
		WebElement mostRecentAddition = driver.findElement(By.xpath("//div[@class='table-container']/table/tbody/tr[last()]"));
		
		System.out.println("Most recently added student: ");
		for(int i = 0; i < dataCells.size(); i++) {
			WebElement e = dataCells.get(i);
			System.out.println();
		}
		
	}
}
