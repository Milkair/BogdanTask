package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbayFactory {
	public static WebDriver driver;
	public static WebElement webElement = null;

	public EbayFactory(WebDriver driver) {
		this.driver = driver;
	}

	public static WebElement searchTextfield() {
		webElement = driver.findElement(By.id("gh-ac"));
		return webElement;
	}

	public static void typeIntoSearchTextField(String words) {
		searchTextfield().sendKeys(words);
	}

	public static WebElement searchButton() {
		webElement = driver.findElement(By.id("gh-btn"));
		return webElement;
	}

	public static void clickOnSearchButton() {
		searchButton().click();
	}

	public static void searchForAnyProducts(String words) {
		typeIntoSearchTextField(words);
		clickOnSearchButton();
	}

	public static WebElement locationOfResultOne() {
		webElement = driver.findElement(By.xpath("//*[@id='Results']//div//li[1]/h3"));
		return webElement;
	}

	public static String firstLinkText() {
		String linkText = locationOfResultOne().getText();
		return linkText;
	}

	public static void clickOnFirstResult(String linkText) {
		webElement = driver.findElement(By.linkText(linkText));
		webElement.click();
	}

	public static WebElement locationOfPrice() {
		webElement = driver.findElement(By.xpath(".//*[@class='u-flL w29 vi-price']/span[1]"));
		return webElement;
	}

	public static void priceOfTheItem() {
		String price = locationOfPrice().getText();
		System.out.println("Price of the item is: " + price);
		
	}

	public static void getUrl(String ebayUrl) {
		driver.get(ebayUrl);

	}
}
