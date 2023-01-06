package qa.carla.automation.pratice.selenium.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import qa.carla.automation.pratice.selenium.pages.RegisterPage;

class RegisterPageTest {
	private RegisterPage registerPage;
	private final String URL = "https://automationexercise.com";

	@BeforeEach
	void init() throws Exception {
		this.registerPage = new RegisterPage();
		this.registerPage.visit(this.URL);	
	}

	@AfterEach
	void exit() throws Exception {
		this.registerPage.quitWebDriver();
	}

	//@Test
	void acessRegister() {
		//when
		this.registerPage.insertEmailToRegister();
		
		//then
		String expected = "kscorito@gmail.com";
		String actual = this.registerPage.getEmailNewAccount();
		assertEquals(expected, actual);
	}
	
	//@Test
	void registerIsValid() {
		//when
		this.registerPage.fillOutForm();
		
		//then
		String expected = "ACCOUNT CREATED!";
		String actual = this.registerPage.getWelcomeMessage();
		assertEquals(expected, actual);
		
		assertFalse(this.URL.equals(this.registerPage.getCurrentUrl()));
	}
	
	@Test
	void registerExistentInBase() {
		//when
		this.registerPage.insertEmailToRegister();
		
		//then
		assertEquals("Email Address already exist!", this.registerPage.getMyLoginExistentMessage());
	}
	
	@Test
	void registerInvalid() {
		//when
		this.registerPage.fillOutFormInvalid();
		
		//then
		assertFalse(this.URL.equals(this.registerPage.getCurrentUrl()));
	
	}

}
