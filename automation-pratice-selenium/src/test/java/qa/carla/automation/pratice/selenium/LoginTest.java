package qa.carla.automation.pratice.selenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class LoginTest {
	
	private WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com");
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	void loginIsValid() {
		driver.findElement(By.xpath("//a[contains(., ' Signup / Login')]"))
		.click();
		
		driver.findElement(By.name("email"))
		.sendKeys("roncarcla18@gmail.com");
		driver.findElement(By.name("password"))
		.sendKeys("123456");
		driver.findElement(By.xpath("//*[@id='form']/div/div/div[1]/div/form/button"))
		.click();
		
		WebElement tagMyLogger = driver.findElement(By.tagName("b"));
		String textTag = tagMyLogger.getText();
		assertTrue(textTag.equals("Carla Irene Ribeiro Franco"));
	}

}
