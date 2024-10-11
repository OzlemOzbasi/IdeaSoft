package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class Content extends Parent{



    public Content() {
        PageFactory.initElements( DriverSetup.getDriver(), this );
    }

    @FindBy(css = "input[type='text']")
    public WebElement searchBox;


    @FindBy(css = "div[class='search']  svg[fill='none']" )
    public WebElement searchButton;



    @FindBy(css = "input[name='label']" )
    public WebElement keyWord;



    @FindBy(css = "select[name='category']" )
    public WebElement category;



    @FindBy(css = "button[type='submit']" )
    public WebElement search;


    @FindBy(css = "img[class='lazyload']" )
    public WebElement productDetails;



    @FindBy(css = "select[name='qty-input']" )
    public WebElement productPiece;


    @FindBy(css = "a[class='add-to-cart-button']" )
    public WebElement addToCartButton;


    @FindBy(css = "div[class='shopping-information-cart-inside']" )
    public WebElement addConfirm;


    @FindBy(css = "div[class='cart-amount']" )
    public WebElement goToCart;


    @FindBy(css = "input[value='5']" )
    public WebElement confirmProductPiece;




    WebElement myElement;
    public void findAndClick(String strElement){


        switch (strElement)
        {
            case "searchButton" : myElement =searchButton; break;
            case "Ara" : myElement =search; break;
            case "Sepete Ekle" : myElement =addToCartButton; break;
            case "Sepet" : myElement =goToCart; break;

        }

       waitUntilClickable(myElement);
       clickFunction(myElement);
    }



}
