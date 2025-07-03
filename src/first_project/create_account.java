package first_project;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;






public class create_account {
	WebDriver driver =new ChromeDriver();
	String website ="https://automationteststore.com/";
	
	
	
	@BeforeTest
	
	public void setup()
	{
		driver.get(website);
		driver.manage().window().maximize();
		
	}	
	
	@Test(priority = 1)
	
	public void signup() {
		
		
		//driver.findElement(By.id("customer_menu_top")).click();
		
	driver.navigate().to("https://automationteststore.com/index.php?rt=account/create");	
	driver.findElement(By.id("AccountFrm_firstname")).sendKeys("mohammad");
	driver.findElement(By.id("AccountFrm_lastname")).sendKeys("ahmad");

	String [] emaillogin= {"mohammad12@gmail.com","mohammad21@gmail.com","mohammad31@gmail.com"};
	Random rand2 =new Random();
	int r2 =rand2.nextInt(emaillogin.length);
	
	driver.findElement(By.id("AccountFrm_email")).sendKeys(emaillogin[r2]);
	driver.findElement(By.id("AccountFrm_address_1")).sendKeys("amman");
	driver.findElement(By.id("AccountFrm_city")).sendKeys("amman");
	driver.findElement(By.id("AccountFrm_postcode")).sendKeys("12345");
	WebElement theselectItem = driver.findElement(By.id("AccountFrm_zone_id"));
	Select myselect =new Select(theselectItem);
	
	myselect.selectByIndex(3);
	//driver.findElement(By.id("AccountFrm_zone_id")).sendKeys("Aberdeen");
	
	String [] namelogin= {"ahmad1","mohammad1","suhieb1","rami1","sameer1","yosef1","khaled1","noor1","roaa1","samar"};
	Random rand =new Random();
	int r =rand.nextInt(namelogin.length);
	;
	driver.findElement(By.id("AccountFrm_loginname")).sendKeys(namelogin[r]);
	driver.findElement(By.id("AccountFrm_password")).sendKeys("12345");
	driver.findElement(By.id("AccountFrm_confirm")).sendKeys("12345");
	driver.findElement(By.id("AccountFrm_agree")).click();
	driver.findElement(By.id("AccountFrm_newsletter1")).click();
	driver.findElement(By.className("lock-on-click")).click();
	}

	
	//mohammad
	@Test (priority = 2)
	public void login () {
		
		driver.navigate().to("https://automationteststore.com/index.php?rt=account/login");
		WebElement name =driver.findElement(By.id("loginFrm_loginname"));
		name.sendKeys("mohammad");
		WebElement pass = driver.findElement(By.id("loginFrm_password"));
		pass.sendKeys("12345");
		driver.findElement(By.xpath("//*[@id=\"loginFrm\"]/fieldset/button")).click();
		
	} 
	
	@Test (priority = 3)
	
	public void AddToCart() {
		
		driver.findElement(By.xpath("//*[@id=\"categorymenu\"]/nav/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[2]/div[1]/div[2]/div[3]/a")).click();
		driver.findElement(By.id("option344747")).click();
		driver.findElement(By.xpath("//*[@id=\"product\"]/fieldset/div[6]/ul/li/a")).click();
		
		driver.findElement(By.id("cart_checkout1")).click();
		driver.findElement(By.id("checkout_btn")).click();
	}
	
	
	

	@AfterTest
	
	public void closeingbrowser() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.close();
		
	}
	
	
	
	

}
