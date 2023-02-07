package steps;

import org.openqa.selenium.By;
import org.testng.Assert;

import Hooks.driverInit;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends driverInit  {
	
	@Given("user Clicks login button")
	public void userClicksLoginButton() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator mat-icon-button')]/following-sibling::button[1]")).click();
	}
	// @Given("user enters user name as jeeva@19")
	// public void userEntersUserNameAsJeeva() {
	// // Write code here that turns the phrase above into concrete actions
	// driver.findElement(By.cssSelector("input[formcontrolname='username']")).sendKeys("jeeva@19");
	// }
	// @Given("user enters Password as Ramujee@19")
	// public void userEntersPasswordAsRamujee() {
	// // Write code here that turns the phrase above into concrete actions
	// driver.findElement(By.cssSelector("input[formcontrolname='password']")).sendKeys("Ramujee@19");

	@Given("user enters user name as {string}")
	public void userEntersUserNameAs(String username) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.cssSelector("input[formcontrolname='username']")).sendKeys(username);
	}

	@Given("user enters Password as {string}")
	public void userEntersPasswordAs(String password) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.cssSelector("input[formcontrolname='password']")).sendKeys(password);
	}

	@When("user click on the login button")
	public void userClickOnTheLoginButton() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator mat-raised-button')]")).click();
	}

	@Then("Login shoud be success")
	public void loginShoudBeSuccess() {
		// Write code here that turns the phrase above into concrete actions
		String actualname = driver
				.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]"))
				.getText();
		String exp = "account_circle jeeva@19 arrow_drop_down";
		Assert.assertEquals(actualname, exp);
	}

	@When("Login shoud not be success")
	public void loginShoudNotBeSuccess() {
		// Write code here that turns the phrase above into concrete actions

		String alert = driver.findElement(By.cssSelector("mat-error[role='alert']")).getText();
		Boolean alerttext = driver.findElement(By.cssSelector("mat-error[role='alert']")).isDisplayed();
		System.out.println(alert);
		Assert.assertTrue(alerttext);
			}
}
