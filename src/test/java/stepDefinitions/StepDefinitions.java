package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {

    WebDriver driver;

    @Given("I have navigated to the item site on Clas Ohlson")
    public void i_have_navigated_to_the_item_site_on_clas_ohlson() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver(); // Starta chrome
        driver.get("https://www.clasohlson.com/se/Superlim-Loctite-Precision,-5-g/p/25-1544");
        driver.manage().window().maximize(); // Gör fönstret stort
        Thread.sleep(1000);
    }

    @And("I have selected {int} item(s) to the cart")
    public void i_have_selected_item_s_to_the_cart(int quantity) throws InterruptedException {

        WebElement quantityBox = driver.findElement(By.xpath("/html/body/main/div[4]/div[1]/div[3]/section[2]/div/div[2]/div[2]/div[2]/div[2]/input"));
        quantityBox.clear();
        quantityBox.sendKeys(Integer.toString(quantity));
        //   quantityBox.sendKeys(Keys.ENTER);
        // quantityBox.submit();
        Thread.sleep(1000);


    }

    @When("I click on add to the cart")
    public void i_click_on_add_to_the_cart() throws InterruptedException {
        WebElement addToCartBox = driver.findElement(By.xpath("/html/body/main/div[4]/div[1]/div[3]/section[2]/div/div[2]/div[4]/div[2]/div[2]/button"));
        addToCartBox.click();
        Thread.sleep(1000);
    }

    @Then("the result should be {int} item(s) in the cart")
    public void the_result_should_be_item_s_in_the_cart(int quantity) {
        WebElement cartQuantity = driver.findElement(By.xpath("/html/body/main/div[2]/header/nav[1]/div/div[2]/div/ul/li[2]/div/div/div/div[1]/a/div/div[1]"));

        System.out.println("Quantity: " + cartQuantity.getAttribute("textContent"));
        Assert.assertEquals(quantity, Integer.parseInt(cartQuantity.getAttribute("textContent")));

        driver.quit();
    }
}
