package steps;

import org.openqa.selenium.By;
import org.testng.Assert;

import Hooks.driverInit;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddCart extends driverInit {

	@Given("user Clicks login button with the user {string} and {string}")
	public void userClicksLoginButtonWithTheUserAnd(String name, String Password) {
		driver.findElement(By
				.xpath("//button[contains(@class,'mat-focus-indicator mat-icon-button')]/following-sibling::button[1]"))
				.click();
		driver.findElement(By.cssSelector("input[formcontrolname='username']")).sendKeys(name);
		driver.findElement(By.cssSelector("input[formcontrolname='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator mat-raised-button')]")).click();
	}

	@Given("user search for {string}")
	public void userSearchFor(String book) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.cssSelector("input[type='search']")).click();
		driver.findElement(By.cssSelector("input[type='search']")).sendKeys(book);
		driver.findElement(By.cssSelector("span.mat-option-text")).click();
	}

	@When("user clicks add to cart")
	public void userClicksAddToCart() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//button[contains(@class,'mat-focus-indicator mat-raised-button')]")).click();

	}

	@Then("the cart badge is updated")
	public void theCartBadgeIsUpdated() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions

		Thread.sleep(3000);
		String add = driver.findElement(By.id("mat-badge-content-0")).getText();
		Assert.assertEquals(Integer.parseInt(add) > 0, true);

	}

}
