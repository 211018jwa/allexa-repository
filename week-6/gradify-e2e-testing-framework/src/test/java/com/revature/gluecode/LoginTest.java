package com.revature.gluecode;

import org.openqa.selenium.WebDriver;

import com.revature.page.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {
	
	private WebDriver driver;
	private LoginPage loginPage;
	
	@Given("I am at the login page")
	public void i_am_at_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I type in a username of {string}")
	public void i_type_in_a_username_of(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I type in a password of {string}")
	public void i_type_in_a_password_of(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I click the login button")
	public void i_click_the_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("i should see a message of {string}")
	public void i_should_see_a_message_of(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
