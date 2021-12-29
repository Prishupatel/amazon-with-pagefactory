package com.amazon.pages;

import com.amazon.customListeners.CustomListeners;
import com.amazon.utility.Utility;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class ProductPage extends Utility {


    public ProductPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "add-to-cart-button")
    WebElement addToCartButton;

    @FindBy(id = "quantity")
    WebElement selectQty;

    @FindBy(xpath = "//div[@id='attachDisplayAddBaseAlert']//h4[@class='a-alert-heading'][normalize-space()='Added to Cart']")
    WebElement laptopAddToCartMessage;

    @FindBy(xpath = "//div[@id='attachDisplayAddBaseAlert']//h4[@class='a-alert-heading'][normalize-space()='Added to Cart']")
    WebElement mobileAddToCartMessage;

    public void selectQtyFromDropDown(String qty) {
       selectByValueFromDropDown(selectQty,qty);
        CustomListeners.test.log(Status.PASS,"selecting quantity : " +selectQty.getText());
        Reporter.log("Selecting quantity " + "<br>");
    }

    public void clickOnAddToCart(){
        clickOnElement(addToCartButton);
        CustomListeners.test.log(Status.PASS,"click on add to cart button : " +addToCartButton.getText());
        Reporter.log("click on add to cart button" + "<br>");

    }

    public void verifyLaptopAddToCartMessage(String message) throws InterruptedException {
        Thread.sleep(1000);
        String actualString = getTextFromElement(laptopAddToCartMessage);
        System.out.println("text of message: " + actualString);
        Assert.assertTrue(actualString.contains((message)));
        CustomListeners.test.log(Status.PASS,"verify laptop added to cart message: " +laptopAddToCartMessage.getText());
        Reporter.log("verify laptop added to cart message" + "<br>");



    }
    public void verifyMobileAddToCartMessage(String message) throws InterruptedException {
        Thread.sleep(2000);
        String actualString =getTextFromElement(mobileAddToCartMessage);
        System.out.println("text of message: " + actualString);
        Assert.assertTrue(actualString.contains((message)));
        CustomListeners.test.log(Status.PASS,"verify mobile added to cart : " +mobileAddToCartMessage.getText() );
        Reporter.log("verify mobile added to cart : " + "<br>");

    }


}
