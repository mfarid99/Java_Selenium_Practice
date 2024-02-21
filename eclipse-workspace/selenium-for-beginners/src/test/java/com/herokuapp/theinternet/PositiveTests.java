package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PositiveTests {
	
	@Test
	public void loginTest() {
		// create driver
		System.out.println("Test Started");
		WebDriver driver = new ChromeDriver();
		sleep(2);

//		String url = "https://the-internet.herokuapp.com/login";
//		driver.get(url);
//		sleep(2);
		
		String url = "https://accounts.salesloft.com/sign_in";
		driver.get(url);

		driver.manage().window().maximize();
		sleep(2);
//		WebElement username = driver.findElement(By.id("username"));
//		username.sendKeys("tomsmith");
		System.out.println("Browser Opened");
//		driver.close();
		WebElement username = driver.findElement(By.id("user_email"));
		username.sendKeys("jasdeep@triblio.com");
		sleep(2);
		WebElement next = driver.findElement(By.cssSelector(".btn.sl-button-accent.btn-lg.responsive-1"));
		next.click();
		sleep(2);
		WebElement password = driver.findElement(By.id("user_password"));
		password.sendKeys("Triblio1234");
		sleep(2);
		WebElement signin = driver.findElement(By.cssSelector(".btn.sl-button-accent.btn-lg.responsive-1"));
		signin.click();
		sleep(5);
		System.out.println("logged in");
		WebElement cadence = driver.findElement(By.xpath("/html/body/main/div[3]/div/nav/ul/li[2]/div/a"));
		cadence.click();
		sleep(5);
		String expectedSalesloftUrl = "https://app.salesloft.com/app/cadences_v2/";
		String actualSalesloftUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedSalesloftUrl, actualSalesloftUrl, "Cadence Url was not reached" );
		
		WebElement cadenceHeader = driver.findElement(By.xpath("//h1[@class='CadenceHeader__Header-sc-ba9d8c2b-1 kfHgcT']"));
		Assert.assertTrue(cadenceHeader.isDisplayed(), "Cadence button visible");
		String expectedHeader = cadenceHeader.getText();
		Assert.assertEquals(expectedHeader, "Cadences", "Cadences is not visible");
		

//		WebElement password = driver.findElement(By.id("password"));
//		password.sendKeys("SuperSecretPassword!");
//		sleep(2);

//		WebElement loginButton = driver.findElement(By.className("radius"));
//		loginButton.click();
//		sleep(2);
		
//		String expectedUrl = "https://the-internet.herokuapp.com/secure";
//		String actualUrl = driver.getCurrentUrl();
//		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected url");
//		
//
//		WebElement logoutButton = driver.findElement(By.xpath("//a[@class=\"button secondary radius\"]"));
//		WebElement message = driver.findElement(By.cssSelector("div#flash"));
		

		
		
		sleep(5);
		driver.quit();
		System.out.println("Browser Closed");
	}

	/**
	 * slows down tests for given number of seconds
	 * @param seconds
	 */
	private void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
}
