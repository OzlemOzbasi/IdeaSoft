package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.Content;
import pages.Parent;
import utilities.DriverSetup;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;

import java.time.Duration;

import static org.testng.Assert.assertEquals;


public class ShoppingSteps extends Content {

    WebDriver driver = DriverSetup.getDriver();


    @Given("Navigate to Fexx")
    public void navigateToFexx() {

        driver.get("https://testcase.myideasoft.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @When("Search for {string} in the search bar")
    public void searchForInTheSearchBar(String product) {

        clickFunction(searchBox);
        sendKeysFunction(searchBox,product);

    }


    @And("Click to {string}")
    public void clickTo(String element) throws InterruptedException {

        findAndClick(element);

        Thread.sleep(1000);

    }

    @And("Select {string} from the Kategoriler")
    public void selectFromTheKategoriler(String string) {

        sendKeysFunction(keyWord,"");
        clickFunction(category);

        WebElement dropdown = driver.findElement(By.cssSelector("select[name='category']"));

        Select selectMenu = new Select(dropdown);

        selectMenu.selectByVisibleText(string);

    }

    @And("Go to the details of the selected product")
    public void goToTheDetailsOfTheSelectedProduct() {

        clickFunction(productDetails);


    }

    @And("Add {int} product to cart")
    public void addProductToCart(int piece) {

        clickFunction(productPiece);

        WebElement dropdown = driver.findElement(By.cssSelector("select[name='qty-input']"));

        Select selectMenu = new Select(dropdown);

        selectMenu.selectByIndex(piece-1);


    }

    @And("Should be able to {string} confirm message")
    public void shouldBeAbleToConfirmMessage(String message) {

        String actualValue = addConfirm.getText();
        System.out.println(actualValue);
        assertEquals(actualValue,message);


    }

    @Then("Confirm that there are {int} product in the cart")
    public void confirmThatThereAreProductInTheCart(int piece) {

      //  String value = driver.findElement(By.cssSelector("input[value='5']")).getText();
        String value = confirmProductPiece.getAttribute("value");

        int intValue = Integer.parseInt(value);

        assertEquals(piece, intValue);


    }


}