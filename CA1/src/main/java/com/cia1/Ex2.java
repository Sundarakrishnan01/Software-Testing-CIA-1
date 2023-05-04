package com.cia1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ex2 {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		String url = "https://www.amazon.in/";
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(4000);

		WebElement search = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		search.sendKeys("Apple airpods");
		search.sendKeys(Keys.ENTER);
		
		Thread.sleep(6000);

		boolean isDisplayed = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div")).isDisplayed();
		
		if(isDisplayed) {
			System.out.println("Corresponding Product is displayed !");
		}
		else {
			System.out.println("Corresponding Product is not displayed !");
		}
		
		List<WebElement> product = new ArrayList<WebElement>();
		
		product = driver.findElements(By.className("a-size-medium"));
		
		for(int i=0; i<6; i++) {
			System.out.println(product.get(i).getText());
		}
		
		driver.findElement(By.xpath("//*[@id=\"n/1388921031\"]/span/a/span")).click();
		
		Thread.sleep(5000);
		
		boolean isCategorized = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[1]")).isDisplayed();
		
		if(isCategorized) {
			System.out.println("Category wise displayed");
		}
		else {
			System.out.println("Category wise not displayed");
		}
		
		
		driver.findElement(By.xpath("//*[@id=\"p_36/1318506031\"]/span/a/span")).click();		
		
		Thread.sleep(4000);
		
		boolean isPrice = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[1]")).isDisplayed();
		
		if(isPrice) {
			System.out.println("Price wise displayed");
		}
		else {
			System.out.println("Price wise not displayed");
		}
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//*[@id=\"p_n_format_browse-bin/30678584031\"]/span/a/div/label/i")).click();
		
		boolean isBrand = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[1]")).isDisplayed();
		
		if(isBrand) {
			System.out.println("Top brands is displayed");
		}
		else {
			System.out.println("Top brands is not displayed");
		}
		
		Thread.sleep(4000);
		
		driver.quit();
		
	}

}