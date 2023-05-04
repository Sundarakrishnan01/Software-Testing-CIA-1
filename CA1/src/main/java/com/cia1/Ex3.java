package com.cia1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ex3 {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new EdgeDriver();
		String url = "https://www.amazon.in/";
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(4000);
		
//		driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"nav-signin-tooltip\"]/a/span")).click();
		
		Thread.sleep(5000);
		
		WebElement email = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
		email.sendKeys("9876543210");
		email.sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		WebElement password = driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
		password.sendKeys("asdf@123");
		password.sendKeys(Keys.ENTER);
			
		Thread.sleep(5000);
		

		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();
		
//		driver.findElement(By.xpath("//*[@id=\"nav-al-your-account\"]/a[1]/span")).click();
		
		String message = "Your Account";
		
		String actualMessage = driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[1]/h1")).getText();
//		System.out.print(actualMessage);
		
		if(message.equals(actualMessage)) {
			System.out.println("Your Account page is displayed");
		}
		else{
			System.out.println("Your Account page is not displayed");
		}
		
		Thread.sleep(4000);
		
		driver.get("https://www.amazon.in/gp/css/order-history?ref_=nav_AccountFlyout_orders");
		
		String Ordermessage = "Your Orders";
		
		String actualOrderMessage = driver.findElement(By.xpath("//*[@id=\"a-page\"]/section/div/div[2]/div[1]/h1")).getText();
		
		if(Ordermessage.equals(actualOrderMessage)) {
			System.out.println("Your Order page is displayed");
		}
		else{
			System.out.println("Your Order page is not displayed");
		}
		
		String orders = driver.findElement(By.xpath("//*[@id=\"a-page\"]/section/div/div[4]/form/label")).getText();
		
		System.out.println(orders);
		
		driver.findElement(By.xpath("//*[@id=\"a-page\"]/section/div/div[3]/ul/li[4]/a")).click();
		
		String cancelled = driver.findElement(By.xpath("//*[@id=\"ordersContainer\"]/div[1]/div")).getText();
		
		System.out.println(cancelled);
		
		Thread.sleep(4000);
	}

}