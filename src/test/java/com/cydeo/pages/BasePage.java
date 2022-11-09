package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {


        @FindBy(xpath = "//button[text()='View all orders']")
        public WebElement navItemButton;

        @FindBy(css = "a[href='/products'] button")
        public WebElement navItemButton2;

        @FindBy(css = "a[href='/orders'] button")
        public WebElement navItemButton3;

        @FindBy(xpath = "//button[text()='Logout']")
        public WebElement logoutButton;

        public BasePage() {
            PageFactory.initElements(Driver.getDriver(), this);
        }
    }

