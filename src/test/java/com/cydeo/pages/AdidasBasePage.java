package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdidasBasePage {

    public AdidasBasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='nav-link']")
    public List<WebElement> topMenu;

    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[1]/a")
    public WebElement homeBtn;

    public void toChooseMainOption(List<WebElement> mainMenu, String string){
        for(WebElement eachOption : mainMenu){
            if(eachOption.getText().contains(string)){
                eachOption.click();
                BrowserUtils.sleep(1);
                break;
            }
        }
    }


}
