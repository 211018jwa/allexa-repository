package com.revature.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class StudentManagerHomePage {
	WebElement firstNameInput = driver.findElement(By.xpath("//input[@id='first-name']"));
	WebElement lastNameInput = driver.findElement(By.xpath("//input[@id='last-name']"));
	
	WebElement dropDownElement = driver.findElement(By.xpath("//input[@id='classification']"));
	Select classificationSelect = new Select(dropDownElement);
	
	WebElement ageInput = driver.findElement(By.xpath("//input[@id='age']"));
	WebElement addStudentButton = driver.findElement(By.xpath("//input[@id='student-submit']"));
}
