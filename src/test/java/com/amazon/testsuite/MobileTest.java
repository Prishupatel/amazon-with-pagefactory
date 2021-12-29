package com.amazon.testsuite;

import com.amazon.customListeners.CustomListeners;
import com.amazon.pages.HomePage;
import com.amazon.pages.ProductPage;
import com.amazon.pages.SearchedPage;
import com.amazon.utility.Utility;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(CustomListeners.class)
public class MobileTest extends Utility {

    HomePage homePage;
    ProductPage productPage;
    SearchedPage searchedPage;

    @BeforeMethod
    public void inIt() {
        homePage = new HomePage();
        productPage = new ProductPage();
        searchedPage = new SearchedPage();
    }

    public void verifyUserShouldAddMobileInCartSuccessfully() throws InterruptedException {
        homePage.enterValuetosearch("mobile");
        searchedPage.clickOnProduct("SAMSUNG Galaxy S20 FE 5G Factory Unlocked Android Cell Phone 128GB US Version Smartphone Pro-Grade Camera 30X Space Zoom Night Mode, Cloud Mint Green");
        productPage.selectQtyFromDropDown("2");
        productPage.clickOnAddToCart();
        productPage.verifyLaptopAddToCartMessage("Added to Cart");

    }
}
