package qa.carla.automation.pratice.selenium.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

import qa.carla.automation.pratice.selenium.pages.RegisterPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    
	@Order(1)
	@Test
	void acessRegister() {
		//when
		this.registerPage.insertEmailToRegister();
		
		//then
		String expected = "roncarcla@yahoo.com.br";
		String actual = this.registerPage.getEmailNewAccount();
		assertEquals(expected, actual);
	}
	
	@Order(3)
	@Test
	void registerValid() {
		//when
		this.registerPage.fillOutForm();
		
		//then
		String expected = "ACCOUNT CREATED!";
		String actual = this.registerPage.getWelcomeMessage();
		assertEquals(expected, actual);
		
		assertFalse(this.URL.equals(this.registerPage.getCurrentUrl()));
	}
	
	@Order(4)
	@Test
	void registerExistentInBase() {
		//when
		this.registerPage.insertEmailToRegister();
		
		//then
		assertEquals("Email Address already exist!", this.registerPage.getMyLoginExistentMessage());
	}
	
	@Order(2)
	@Test
	void registerInvalid() {
		//when
		this.registerPage.fillOutFormInvalid();
		
		//then
		assertFalse(this.URL.equals(this.registerPage.getCurrentUrl()));
	
	}
	
	@Order(5)
	@Test
	void deleteAccountValid() {
		//when
		this.registerPage.deleteAccount();
		this.registerPage.visit("https://automationexercise.com/delete_account");
		
		//then
		assertEquals("ACCOUNT DELETED!", this.registerPage.getDeleteMessage());
		assertFalse(this.URL.equals(this.registerPage.getCurrentUrl()));
	}

}
