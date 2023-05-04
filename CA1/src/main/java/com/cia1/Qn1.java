package com.cia1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Qn1 {

	public static void main(String[] args) throws InterruptedException {

		EdgeOptions co=new EdgeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.edgedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("1234567895");
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).submit();
		driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("asdfg1234");
		driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).submit();
		
		WebElement el=driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		el.sendKeys("Samsung");
		el.submit();
//		js.executeScript("window.scrollBy(0,1000)");
//		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();
		Thread.sleep(3000);
		driver.get("https://www.amazon.in/sspa/click?ie=UTF8&spc=MTozMjg5NzcyOTY2MTUzMTU3OjE2ODMxOTMwOTU6c3BfYXRmOjIwMTQ4MDkzMDAxNjk4OjowOjo&url=%2FSamsung-Storage-Battery-Octa-Core-Processor%2Fdp%2FB0BZCSMP95%2Fref%3Dsr_1_1_sspa%3Fkeywords%3DSamsung%26qid%3D1683193095%26sr%3D8-1-spons%26sp_csd%3Dd2lkZ2V0TmFtZT1zcF9hdGY%26psc%3D1");
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
		Thread.sleep(2000);
		System.out.println("Item Added to cart");
		driver.get("https://www.amazon.in/gp/cart/view.html?ref_=nav_cart");
//		driver.findElement(By.xpath("//*[@id=\"nav-cart-count-container\"]/span[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]")).click();////*[@id="a-autoid-0-announce"]
		driver.findElement(By.xpath("//*[@id=\"quantity_2\"]")).click();
		System.out.println("Cart updated!!");
		driver.get("https://www.amazon.in/gp/cart/view.html?ref_=nav_cart");
		Thread.sleep(2000);
		System.out.println("Successfully Deleted!!!");
		driver.findElement(By.xpath("//*[@id=\"sc-buy-box-ptc-button\"]/span/input")).click();
		System.out.println("Redirected to Proceed to buy");
		driver.findElement(By.xpath("//*[@id=\"shipToThisAddressButton\"]/span/input")).click();
		Thread.sleep(7000);
		String s1=driver.findElement(By.xpath("//*[@id=\"subtotals-marketplace-table\"]/table/tbody/tr[6]/td[2]")).getText();
		System.out.println("Thr price is- "+s1);
		
		

	}

}
