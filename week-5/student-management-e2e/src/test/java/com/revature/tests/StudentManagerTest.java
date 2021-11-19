package com.revature.tests;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.revature.page.StudentManagerHomePage;

public class StudentManagerTest {
	
	private WebDriver driver;
	public StudentManagerHomePage homePage;
	
	@BeforeEach
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", "C:/WebDrivers/chromedriver_win32/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://localhost:8080");
	}
	
	@AfterEach
	public void tearDown() {
		driver.quit()
	}
	
	@Test
	public void addStudentPossitive() {
		homePage.firstNameInput.sendKeys("Bach");
		homePage.lastNameInput.sendKeys("Tran");
		homePage.classificationSelect.selectByVisibleText("Sophmore");
		homePage.ageInput.sendKeys("20");
		
		List<WebElement> dataCells = mostRecentAddition.findElements(By.tagName("td"));
		
		WebElement idTdElement = dataCells.get(0);
		WebElement firstNameTdElement = dataCells.get(1);
		WebElement lastNameTdElement =  dataCells.get(2);
		WebElement classificationTdElement = dataCells.get(3);
		WebElement ageTdElement = dataCells.get(4);
	}
}
