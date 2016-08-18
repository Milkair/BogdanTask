package BogdanTest;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageClasses.EbayFactory;
import PageClasses.GmailFactory;

public class NewTest {
	WebDriver driver;
	String gmailUrl;
	String ebayUrl;
	GmailFactory gmailFactory;
	EbayFactory ebayFactory;
	
	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		ebayUrl = "https://ebay.com";
		gmailUrl = "https://gmail.com";
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		gmailFactory = new GmailFactory(driver);
		ebayFactory = new EbayFactory(driver);
	}

	@Test
	public void ebayTestGuitarSearch() throws InterruptedException {
		ebayFactory.getUrl(ebayUrl);
		ebayFactory.searchForAnyProducts("Electric Guitar");
		ebayFactory.clickOnFirstResult(ebayFactory.firstLinkText());
		Thread.sleep(1000);
		ebayFactory.priceOfTheItem();
	}

	@Test
	public void gmailPositiveLoginTestNameInv() throws InterruptedException {
		gmailFactory.getUrl(gmailUrl);
		driver.get(gmailUrl);
		gmailFactory.enterEmailAddress("ValentineTest1");
		gmailFactory.enterPasswordCredentials("Pass123!");
		Assert.assertEquals("Valentin Fomchenko", gmailFactory.getUserName());
	}

	@Test
	public void gmailNegativeLoginTest() throws InterruptedException {
		gmailFactory.getUrl(gmailUrl);
		gmailFactory.enterEmailAddress("ValentinTest");
		gmailFactory.enterPasswordCredentials("Pass123!");
		Assert.assertTrue(gmailFactory.errorMessage().isDisplayed());
	}

	@Test
	public void gmailNegativeLoginTestPswInv() throws InterruptedException {
		gmailFactory.getUrl(gmailUrl);
		gmailFactory.enterEmailAddress("ValentineTest1");
		gmailFactory.enterPasswordCredentials("Pass13");
		Assert.assertEquals("The email and password you entered don't match.", gmailFactory.returnErrorMessage());
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}

