package com.amazon.pages;

import com.amazon.customListeners.CustomListeners;
import com.amazon.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }


    @CacheLookup
    @FindBy(css = "#twotabsearchtextbox")
    WebElement searchBar;

    @FindBy(css = "#nav-search-submit-button")
    WebElement searchIcon;




    public void enterValuetosearch(String item) {
        sendTextToElement(searchBar, item);
        clickOnElement(searchIcon);
        CustomListeners.test.log(Status.PASS,"Enter text in search box ");
        Reporter.log("Enter text in search box and click " +searchBar + "<br>");
    }


}
