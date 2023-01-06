package qa.carla.automation.pratice.selenium.pages;

import org.openqa.selenium.By;

public class RegisterPage extends BasePage {
	//Locators
	private By signupLocator = By.xpath("//a[contains(., ' Signup / Login')]");
	private By nameLocator = By.name("name");
	private By emailAddressLocator = By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[3]");
	private By submitBtnLocator = By.xpath("//button[contains(., 'Signup')]");
	private By emailLocator = By.id("email");
	private By alertAdditionalInformationLocator = By.xpath("//span[contains(., '(Street address, P.O. Box, Company name, etc.)')]");
	private By messageLoginExistentLocator = By.xpath("//*[@id='form']/div/div/div[3]/div/form/p");
	
	//Locators you personal information
	private By genderFemaleLocator = By.id("id_gender2");
	private By passwordLocator = By.id("password");
	private By daysLocator = By.id("days");
	private By monthsLocator = By.id("months");
	private By yearsLocator = By.id("years");
	private By newsletterLocator = By.id("newsletter");
	private By receiveOffersLocator = By.id("optin");
	
	//Locators your address
	private By firstNameLocator = By.id("first_name");
	private By lastNameLocator = By.id("last_name");
	private By companyLocator = By.id("company");
	private By address1Locator = By.id("address1");
	private By address2Locator = By.id("address2");
	private By countryLocator = By.id("country");
	private By stateLocator = By.id("state");
	private By cityLocator = By.id("city");
	private By zipcodeLocator = By.id("zipcode");
	private By mobilePhoneLocator = By.id("mobile_number");
	private By registerBtnLocator = By.xpath("//button[contains(., 'Create Account')]");
	private By welcomeMessageLocator = By.cssSelector("#form > div > div > div > h2 > b");
	
	
	public void insertEmailToRegister() {
		if(super.isDisplayed(signupLocator)) {
			super.click(signupLocator);
			super.type("Carla Franco", nameLocator);
			super.type("kscorito@gmail.com", emailAddressLocator);
			super.click(submitBtnLocator);	
		} else {
			System.out.println("Campo para informar email não encontrado!");
		}
	}
	
	public String getEmailNewAccount() {
		super.waitVisibilityOfElementLocated(alertAdditionalInformationLocator);
		return super.getTextByAttribute(this.emailLocator, "value");
	}
	
	public void fillOutForm() {
		this.insertEmailToRegister();
		super.waitVisibilityOfElementLocated(alertAdditionalInformationLocator);
		if(super.isDisplayed(genderFemaleLocator)) {
			super.click(genderFemaleLocator);
			super.clear(nameLocator);
			super.type("Carla Franco", nameLocator);
			super.type("123456", passwordLocator);
			super.selectByValue(daysLocator, "10");
			super.selectByValue(monthsLocator, "1");
			super.selectByValue(yearsLocator, "1986");
			super.click(newsletterLocator);
			super.click(receiveOffersLocator);
			super.type("Carla", firstNameLocator);
			super.type("Franco", lastNameLocator);
			super.type("Furukawa", companyLocator);
			super.type("Elza Hoffman Lubbe, 1", address1Locator);
			super.type("Santa Isabel", address2Locator);
			super.selectByValue(countryLocator, "Canada");
			super.type("Espírito Santo", stateLocator);
			super.type("Domingos Martins", cityLocator);
			super.type("29.260-000", zipcodeLocator);
			super.type("(27) 9 9991-4216", mobilePhoneLocator);
			super.click(registerBtnLocator);	
			
		} else {
			System.out.println("Mensagem não encontrada!");
		}
		
	}
	
	public String getWelcomeMessage() {
		super.waitVisibilityOfElementLocated(welcomeMessageLocator);
		return super.getText(welcomeMessageLocator);
		
	}
	
	public String getMyLoginExistentMessage() {
		return super.getText(messageLoginExistentLocator);
	}
	
	public void fillOutFormInvalid() {
		super.click(signupLocator);
		super.type("Carla Franco", nameLocator);
		super.type("cacarfranco09_embu0z@kindle.com", emailAddressLocator);
		super.click(submitBtnLocator);	
		super.click(registerBtnLocator);	
		super.waitVisibilityOfElementLocated(registerBtnLocator);
	}

}
