package com.revature.tests;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNumbersTest {
	
	private WebDriver driver;

	@Given("I am at the calculator page")
	public void i_am_at_the_calculator_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver_win32/chromedriver.exe");
		
	    driver = new ChromeDriver();
	    
	    driver.get("http://localhost:8080/");
	}

	@When("I type in the number {int} into the left add input")
	public void i_type_in_the_number_into_the_left_add_input(Integer int1) {
	    WebElement leftAddInput = driver.findElement(By.xpath("//form[@target='addResult']/input[@name='number1']"));
	    
	    leftAddInput.sendKeys("" + int1);
	}

	@When("I type in the number {int} into the right add input")
	public void i_type_in_the_number_into_the_right_add_input(Integer int1) {
	    WebElement rightAddInput = driver.findElement(By.xpath("//form[@target='addResult']/input[@name='number2']"));
	    
	    rightAddInput.sendKeys("" + int1);
	}

	@When("I click the add button")
	public void i_click_the_add_button() {
	    WebElement addButton = driver.findElement(By.xpath("//button[text()='Add Numbers']"));
	    
	    addButton.click();
	}

	@Then("I should see an addition result of {double}")
	public void i_should_see_a_result_of(Double double1) {
		driver.switchTo().frame("addResult"); // Switch into the inside of the iframe
		WebElement addOutput = driver.findElement(By.tagName("pre"));
		
		String actual = addOutput.getText();
		
		Assertions.assertEquals("" + double1, actual);
		
		driver.quit();
	}
	
	@When("I type in the number {double} into the left add input")
	public void i_type_in_the_number_into_the_left_add_input(Double double1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I type in the number {double} into the right add input")
	public void i_type_in_the_number_into_the_right_add_input(Double double1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I should see an error message in the addition output area of {string}")
	public void i_should_see_an_error_message_in_the_addition_output_area_of(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
}
