package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static java.lang.Integer.parseInt;

public class AdidasCartPage extends AdidasBasePage {

    public AdidasCartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//tr[@class='success']")
    public List<WebElement> itemsInCart;

    @FindBy(xpath = "//button[.='Place Order']")
    public WebElement placeOrderButton;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement nameInput;

    @FindBy(xpath = "//input[@id='country']")
    public WebElement countryInput;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement cityInput;

    @FindBy(xpath = "//input[@id='card']")
    public WebElement cardInput;

    @FindBy(xpath = "//input[@id='month']")
    public WebElement monthInput;

    @FindBy(xpath = "//input[@id='year']")
    public WebElement yearInput;

    @FindBy(xpath = "//button[.='Purchase']")
    public WebElement purchaseBtn;

    @FindBy(xpath = "/html/body/div[10]/p")
    public WebElement purchaseConfirmation;

    @FindBy(xpath = "//button[@class='confirm btn btn-lg btn-primary']")
    public WebElement okBtn;


    public void deleteItem(List<WebElement> itemsInCart, String productName) {
        if (itemsInCart != null) {
            for (WebElement eachItem : itemsInCart) {
                if (eachItem.getText().contains(productName)) {
                    Driver.getDriver().findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[.='" + productName + "']/following-sibling::td[2]/a")).click();
                    BrowserUtils.sleep(1);
                    break;
                }
            }
        }
    }

    public int getPurchaseAmount(String str) {
        str = str.substring(str.indexOf("A"), str.indexOf("D"));
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                temp += str.charAt(i);
            }
        }
        System.out.println(temp);
        return parseInt(temp);
    }
}
