package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AdidasProductPage extends AdidasBasePage {
    public AdidasProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='Laptops']")
    public WebElement laptops;

    @FindBy(xpath = "//a[.='Phones']")
    public WebElement phones;

    @FindBy(xpath = "//a[.='Monitors']")
    public WebElement monitors;

    @FindBy(xpath = "//a[@id='itemc']")
    public List<WebElement> categories;

    @FindBy(xpath = "//a[.='Sony vaio i5']")
    public WebElement sonyVaioI5;

    @FindBy(xpath = "//a[.='Dell i7 8gb']")
    public WebElement dellI78Gb;

    @FindBy(xpath = "//*[@id=\"tbodyid\"]/div/div/div/h4/a")
    public List<WebElement> AllLaptops;

    @FindBy(xpath = "//a[.='Add to cart']")
    public WebElement addToCart;


    public void chooseCategory(List<WebElement> categories, String categoryName) {
        for (WebElement each : categories) {
            if (categoryName.equalsIgnoreCase(each.getText())) {
                each.click();
                BrowserUtils.sleep(1);
                break;
            }
        }
    }


    public void addToTheCart(List<WebElement> items, String productName) {
        for (WebElement each : items) {
            if (productName.equalsIgnoreCase(each.getText())) {
                each.click();
                BrowserUtils.sleep(1);
                break;

            }
        }

    }

}
