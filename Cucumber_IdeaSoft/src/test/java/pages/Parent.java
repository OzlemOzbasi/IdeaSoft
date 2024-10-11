package pages;

import utilities.DriverSetup;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Parent {

    public void sendKeysFunction(WebElement element, String value) {

        waitUntilVisible(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(value);
    }


    public void waitUntilVisible(WebElement element) {

        WebDriverWait wait = new WebDriverWait(DriverSetup.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void scrollToElement(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) DriverSetup.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }



    public void clickFunction(WebElement element)
    {
        waitUntilClickable(element);
        scrollToElement(element);
        element.click();
    }



    public void waitUntilClickable(WebElement element) {

        WebDriverWait wait = new WebDriverWait(DriverSetup.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }








}
