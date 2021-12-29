package com.amazon.pages;

import com.amazon.customListeners.CustomListeners;
import com.amazon.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class SearchedPage extends Utility {


    public SearchedPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    List<WebElement> allResult; //h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']

    @FindBy(xpath = "//a[contains(@class,'s-pagination-item s-pagination-next')]")
    WebElement nextButton;


    public void clickToNextPage() {
        clickOnElement(nextButton);
        CustomListeners.test.log(Status.PASS,"click on next button " +nextButton.getText() + "<br>");
        Reporter.log("click on next button " + "<br>" );
    }

    public boolean searchItemOnFirstPage(String item) {
        boolean result = false;
        for (WebElement element : allResult) {
            if (element.getText().equalsIgnoreCase(item)) {
                System.out.println("*****************Your selected Item found ******************* : " + element.getText());
                clickOnElement(element);
                result = true;
                break;
            }
        }
        return result;
    }

    public void clickOnProduct(String product) throws InterruptedException {
        List<WebElement> result = allResult;
        boolean isDisplay = false;
        int totalpages = 20;
        for (int i = 0; i < totalpages; i++) {
            for (WebElement name : allResult) {
                Thread.sleep(1000);
                if (name.getText().equalsIgnoreCase(product)){
                    Thread.sleep(1000);
                    name.click();
                    isDisplay=true;
                    break;
                }
            }
            if (!isDisplay){
                clickOnElement(nextButton);
            }else {
                break;
            }
        }
    }


}
