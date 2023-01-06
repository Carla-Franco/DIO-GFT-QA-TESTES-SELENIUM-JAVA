package qa.carla.automation.pratice.selenium.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import qa.carla.automation.pratice.selenium.pages.DressesPage;

class DressesPageTest {
	private DressesPage dressesPage;
	private final String URL = "https://automationexercise.com/";

	@BeforeEach
	void init() throws Exception {
		this.dressesPage = new DressesPage();
		this.dressesPage.visit("https://automationexercise.com/");	
	}

	@AfterEach
	void exit() throws Exception {
		this.dressesPage.quitWebDriver();
	}

	@Test
	void validAcessPageDress() {
		//when
		this.dressesPage.viewDressesPage();
		this.dressesPage.visit("https://automationexercise.com/#google_vignette");
		this.dressesPage.clickSubmenuDresses();	
		
		//then
		assertEquals("WOMEN - DRESS PRODUCTS", this.dressesPage.getTitlePage());
		assertFalse(this.URL.equals(dressesPage.getCurrentUrl()));
	}

}
