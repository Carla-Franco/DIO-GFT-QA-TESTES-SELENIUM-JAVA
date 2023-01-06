package qa.carla.automation.pratice.selenium.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
	//Locators
	private By signupLocator = By.xpath("//a[contains(., ' Signup / Login')]");
	private By emailAddressLocator = By.name("email");
	private By passwordLocator = By.name("password");
	private By submitBtnLocator = By.xpath("//*[@id='form']/div/div/div[1]/div/form/button");
	private By tagMyAccountLocator = By.tagName("b");
	private By messageLoginInvalidLocator = By.xpath("//*[@id='form']/div/div/div[1]/div/form/p");
	
	public void signin() {
		if(super.isDisplayed(signupLocator)) {
			super.click(signupLocator);
			super.type("roncarcla18@gmail.com", emailAddressLocator);
			super.type("123456", passwordLocator);
			super.click(submitBtnLocator);
		} else {
			System.out.println("Acesso ao login não encontrado!");
		}
	}
	
	public String getMyAccountMessage() {
		return super.getText(tagMyAccountLocator);
	}
	
	public void signinInvalidd() {
		if(super.isDisplayed(signupLocator)) {
			super.click(signupLocator);
			super.type("123@email.com", emailAddressLocator);
			super.type("123456", passwordLocator);
			super.click(submitBtnLocator);
		} else {
			System.out.println("Acesso ao login não encontrado!");
		}
	}
	
	public String getMyLoginInvalidMessage() {
		return super.getText(messageLoginInvalidLocator);
	}

}
