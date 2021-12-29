package com.amazon.testsuite;

import com.amazon.customListeners.CustomListeners;
import com.amazon.pages.HomePage;
import com.amazon.pages.ProductPage;
import com.amazon.pages.SearchedPage;
import com.amazon.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LaptopTest extends TestBase {
    HomePage homePage;
    ProductPage productPage;
    SearchedPage searchedPage;

    @BeforeMethod
    public void inIt() {
        homePage = new HomePage();
        productPage = new ProductPage();
        searchedPage = new SearchedPage();
    }

    @Test
    public void verifyUserShouldAddLaptopInCartSuccessfully() throws InterruptedException {
        homePage.enterValuetosearch("laptop");
        searchedPage.clickOnProduct("ASUS L410 MA-DB04 Ultra Thin Laptop, 14” FHD Display, Intel Celeron N4020 Processor, 4GB RAM, 128GB Storage, NumberPad, Windows 10 Home in S Mode, Star Black");
        productPage.selectQtyFromDropDown("3");
        productPage.clickOnAddToCart();
        productPage.verifyLaptopAddToCartMessage("Added to Cart");

    }


}
