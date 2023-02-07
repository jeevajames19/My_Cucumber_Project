package Hooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Myhooks extends driverInit {


	
	
	@Before
	public void Before(Scenario scenario) {
		System.out.println("before scenerio");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// Write code here that turns the phrase above into concrete actions
		driver.navigate().to("https://bookcart.azurewebsites.net/");
		Options manage = driver.manage();
		manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());

	}

	@After("@cleancart")
	public void clearcart(Scenario scenario) throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//button[contains(@class,'mat-focus-indicator mat-icon-button')])[2]")).click();	
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[contains(@class,'mat-focus-indicator mat-elevation-z4')])[1]")).click();
		Thread.sleep(3000);
		String text=driver.findElement(By.tagName("mat-card-title")).getText();
		String 	actutext=text.trim();
		String exptext="Shopping cart is empty";
		Assert.assertEquals(actutext,exptext );
		
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "pic");
	
	}
	@After
	public void After(Scenario scenario) {
		System.out.println("after scenerio");
		Boolean status = scenario.isFailed();
		System.out.println(status);
		if (status) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "pic");
		}

		driver.quit();

	}
	@AfterStep
	public void BStep(Scenario scenario) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "pic");
		
	}
	@AfterStep
	public void AStep(Scenario scenario) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "pic");
			
	}

	
}
