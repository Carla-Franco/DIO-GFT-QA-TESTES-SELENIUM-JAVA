package qa.carla.automation.pratice.selenium.pages;

import org.openqa.selenium.By;

public class DressesPage extends BasePage{
	//Locators
	private By menuWomenLocator = By.cssSelector("#accordian > div:nth-child(1) > div.panel-heading > h4 > a");
	private By submenuWomenLocator = By.cssSelector("#Women > div > ul > li:nth-child(1) > a");
	private By titlePageDressesLocator = By.xpath("//h2[contains(., 'Women - Dress Products')]");
	
	public void viewDressesPage() {
		if(super.isDisplayed(menuWomenLocator)) {
			super.actionMoveToElementPerform(menuWomenLocator);
			super.actionMoveToElementClickPerform(menuWomenLocator);
			
			
		} else {
			System.out.println("Menu Women não encontrado!");
		}
	}
	
	public void clickSubmenuDresses() {
		super.actionMoveToElementClickPerform(menuWomenLocator);
		super.actionMoveToElementClickPerform(submenuWomenLocator);		
	}
	
	public String getTitlePage() {
		
		return super.getText(titlePageDressesLocator);
	}
	
	

}
