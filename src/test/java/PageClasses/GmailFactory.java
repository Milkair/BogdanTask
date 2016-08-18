package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailFactory {

	public static WebDriver driver;
	public static WebElement webElement = null;

	public GmailFactory(WebDriver driver) {
		this.driver = driver;
	}

	public static WebElement emailTextField() {
		webElement = driver.findElement(By.id("Email"));
		return webElement;
	}

	public static void enterEmail(String email) {
		emailTextField().sendKeys(email);
	}

	public static WebElement nextButton() {
		webElement = driver.findElement(By.id("next"));
		return webElement;
	}

	public static void clickOnNextButton() {
		nextButton().click();
	}

	public static void enterEmailAddress(String emailAddress) {
		emailTextField().sendKeys(emailAddress);
		clickOnNextButton();
	}

	public static WebElement passwordTextField() {
		webElement = driver.findElement(By.id("Passwd"));
		return webElement;
	}

	public static void enterPassword(String passwd) {
		passwordTextField().sendKeys(passwd);
	}

	public static WebElement signInButton() {
		webElement = driver.findElement(By.id("signIn"));
		return webElement;
	}

	public static void clickSignInButton() throws InterruptedException {
		signInButton().click();
		Thread.sleep(5000);
	}

	public static void enterPasswordCredentials(String passwd) throws InterruptedException {
		passwordTextField().sendKeys(passwd);
		signInButton().click();
		Thread.sleep(5000);
	}

	public static WebElement userIcon() {
		webElement = driver.findElement(By.xpath("//div[@id='gb']/div[1]//a[starts-with(@class,'gb_b gb_8a gb_R')]"));
		return webElement;
	}

	public static void clickOnUserIcon() {
		userIcon().click();
	}

	public static WebElement valentinFomchenko() {
		webElement = driver.findElement(By.xpath("//div[@id='gb']//div[text()='Valentin Fomchenko']"));
		return webElement;
	}

	public static String getUserName() throws InterruptedException {
		userIcon().click();
		Thread.sleep(2000);
		String userName = valentinFomchenko().getText();
		return userName;
	}

	public static WebElement errorMessage() {
		webElement = driver.findElement(By.xpath(".//*[@id='errormsg_0_Passwd']"));
		return webElement;
	}

	public static String returnErrorMessage() {
		String errorMessage = errorMessage().getText();
		return errorMessage;
	}

	public static void getUrl(String gmailUrl) {
		driver.get(gmailUrl);
	}

}
