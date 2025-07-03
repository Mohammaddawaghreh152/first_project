package first_project;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class my_first_test {
	
WebDriver driver=new ChromeDriver()	;


String thewebsite ="https://www.saucedemo.com/";


//String username ="standard_user";

//String password ="secret_sauce";
@BeforeTest

public void setup() {
	
	driver.get(thewebsite);
	driver.manage().window().maximize();
	
}


@Test(priority = 1)

public void login() {
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	driver.findElement(By.name("login-button")).click();
	
}
@Test (priority = 2)
public void addToCart() {
	
	driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	
}

@Test (priority = 3)
public void checkout() throws InterruptedException {
String[] first_name = {"ahmad","mohammad","suhieb","rami","sameer"};

String[] last_name = {"yosef","khaled","noor","roaa","samar"};

Random rand=new Random();

int randomfirstname =rand.nextInt(first_name.length);
int randomlastname =rand.nextInt(last_name.length);
System.out.println(randomfirstname);
System.out.println(randomlastname);
driver.navigate().to("https://www.saucedemo.com/cart.html");
	Thread.sleep(2000);
	driver.navigate().back();
	Thread.sleep(1000);
	driver.navigate().forward();
	driver.findElement(By.name("checkout")).click();

	WebElement first_name_input=driver.findElement(By.id("first-name"));
	WebElement last_name_input=driver.findElement(By.id("last-name"));
	WebElement postal_input=driver.findElement(By.id("postal-code"));
	first_name_input.sendKeys(first_name[randomfirstname]);
	last_name_input.sendKeys(last_name[randomlastname]);
	
	
}

@AfterTest
public void closingTheBrouser() {
	
	
	
}

}