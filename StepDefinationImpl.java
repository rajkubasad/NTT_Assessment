package rahulshettyacademy.StepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.pageObjects.CartPage;
import rahulshettyacademy.pageObjects.CheckoutPage;
import rahulshettyacademy.pageObjects.ConfirmationPage;
import rahulshettyacademy.pageObjects.LandingPage;
import rahulshettyacademy.pageObjects.ProductCatalogue;
import rahulshettyacademy.testComponents.BaseTest;

public class StepDefinationImpl {

	@Given("I am on the ESPN Cricinfo homepage")
	public void I_am_on_the_ESPN_Cricinfo_homepage() throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		 // Navigate to ESPN Cricinfo homepage
		driver.get("https://www.espncricinfo.com/");
		
		 // Verify homepage title
        String expectedTitle = "ESPNcricinfo";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertTrue(expectedTitle, actualTitle)
	}

	@when("I view the live cricket scores")
	public void I_view_the_live_cricket_scores() {
		WebElement liveScoreElement = driver.findElement(By.xpath("//div[@class='scorebox']//a"));
		String initialScore = liveScoreElement.getText().trim();
		try {
			Thread.sleep(5000); // Wait for 5 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("the score should update dynamically every few seconds")
	public void the_score_should_update_dynamically_every_few_seconds(String string) {
		String updatedScore = liveScoreElement.getText().trim();
		Assert.assertNotEquals("Live score update verification", initialScore, updatedScore);

		// Close the browser
		driver.quit();
	}

}
