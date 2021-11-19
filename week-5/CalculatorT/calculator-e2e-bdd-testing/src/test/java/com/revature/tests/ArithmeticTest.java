package com.revature.tests;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ArithmeticTest {
	
	private WebDriver driver;

	@Given("I am at the calculator page")
	public void i_am_at_the_calculator_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver_win32/chromedriver.exe");
		
	    driver = new ChromeDriver();
	    
	    driver.get("http://ec2-18-219-69-82.us-east-2.compute.amazonaws.com:8080/");
	}

	@When("I type in the number {double} into the left add input")
	public void i_type_in_the_number_into_the_left_add_input(Double double1) {
	    WebElement leftAddInput = driver.findElement(By.xpath("//form[@target='addResult']/input[@name='number1']"));
	    
	    leftAddInput.sendKeys("" + double1); // "" + double1 -> convert to a string
	}

	@When("I type in the number {double} into the right add input")
	public void i_type_in_the_number_into_the_right_add_input(Double double1) {
	    WebElement rightAddInput = driver.findElement(By.xpath("//form[@target='addResult']/input[@name='number2']"));
	    
	    rightAddInput.sendKeys("" + double1);
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
	
	@Then("I should see an error message in the addition output area of {string}")
	public void i_should_see_an_error_message_in_the_addition_output_area_of(String string) {
	    driver.switchTo().frame("addResult");
	    WebElement addOutput = driver.findElement(By.tagName("pre"));
	    
	    String actual = addOutput.getText();
	    
	    Assertions.assertEquals(string, actual);
	    
	    driver.quit();
	}
	
	@When("I type in the number {double} into the left subtract input")
	public void i_type_in_the_number_into_the_left_subtract_input(Double double1) {
		 WebElement leftSubInput = driver.findElement(By.xpath("//form[@target='subResult']/input[@name='number1']"));
		    
		 leftSubInput.sendKeys("" + double1); // "" + double1 -> convert to a string
	}

	@When("I type in the number {double} into the right subtract input")
	public void i_type_in_the_number_into_the_right_subtract_input(Double double1) {
		WebElement rightSubInput = driver.findElement(By.xpath("//form[@target='subResult']/input[@name='number2']"));
	    
		 rightSubInput.sendKeys("" + double1); // "" + double1 -> convert to a string
	}

	@When("I click the subtract button")
	public void i_click_the_subtract_button() {
		WebElement subButton = driver.findElement(By.xpath("//button[text()='Subtract Numbers']"));
	    
	    subButton.click();
	}

	@Then("I should see an subtraction result of {double}")
	public void i_should_see_an_subtraction_result_of(Double double1) {
	    driver.switchTo().frame("subResult");
	    WebElement subOutput = driver.findElement(By.tagName("pre"));
	    
	    String actual = subOutput.getText();
	    
	    Assertions.assertEquals("" + double1, actual);
	    
	    driver.quit();
	}
	
	@Then("I should see an error message in the subtraction output area of {string}")
	public void i_should_see_an_error_message_in_the_subtraction_output_area_of(String string) {
		driver.switchTo().frame("subResult");
	    WebElement subOutput = driver.findElement(By.tagName("pre"));
	    
	    String actual = subOutput.getText();
	    
	    Assertions.assertEquals(string, actual);
	    
	    driver.quit();;
	}

	@When("I type in the number {double} into the left multiply input")
	public void i_type_in_the_number_into_the_left_multiply_input(Double double1) {
		 WebElement leftMultInput = driver.findElement(By.xpath("//form[@target='multResult']/input[@name='number1']"));
		    
		 leftMultInput.sendKeys("" + double1); // "" + double1 -> convert to a string
	}

	@When("I type in the number {double} into the right multiply input")
	public void i_type_in_the_number_into_the_right_multiply_input(Double double1) {
		WebElement rightMultInput = driver.findElement(By.xpath("//form[@target='multResult']/input[@name='number2']"));
	    
		 rightMultInput.sendKeys("" + double1); // "" + double1 -> convert to a string
	}

	@When("I click the multiply button")
	public void i_click_the_multiply_button() {
		WebElement multButton = driver.findElement(By.xpath("//button[text()='Multiply Numbers']"));
	    
	    multButton.click();
	}

	@Then("I should see an multiplication result of {double}")
	public void i_should_see_a_multiplication_result_of(Double double1) {
	    driver.switchTo().frame("multResult");
	    WebElement multOutput = driver.findElement(By.tagName("pre"));
	    
	    String actual = multOutput.getText();
	    
	    Assertions.assertEquals("" + double1, actual);
	    
	    driver.quit();
	}
	
	@Then("I should see an error message in the multiplication output area of {string}")
	public void i_should_see_an_error_message_in_the_multiplication_output_area_of(String string) {
		driver.switchTo().frame("multResult");
	    WebElement multOutput = driver.findElement(By.tagName("pre"));
	    
	    String actual = multOutput.getText();
	    
	    Assertions.assertEquals(string, actual);
	    
	    driver.quit();;
	}
}
