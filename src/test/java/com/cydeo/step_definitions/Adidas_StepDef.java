package com.cydeo.step_definitions;

import com.cydeo.pages.AdidasBasePage;
import com.cydeo.pages.AdidasCartPage;
import com.cydeo.pages.AdidasProductPage;
import com.cydeo.pages.BasePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Adidas_StepDef {

    AdidasProductPage adidasProductPage = new AdidasProductPage();
    AdidasBasePage adidasBasePage = new AdidasBasePage();
    AdidasCartPage adidasCartPage = new AdidasCartPage();
    Faker faker = new Faker();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);


    @Given("user is on the {string} page")
    public void user_is_on_the_product_page(String menuOption) {
        //adidasBasePage.homeBtn.click();
        adidasBasePage.toChooseMainOption(adidasBasePage.topMenu, menuOption);
    }

    @When("user navigates to {string} section, adds {string} to the cart and accepts pop up confirmation")
    public void user_navigates_to_section_adds_to_the_cart_and_accepts_pop_confirmation(String sectionName, String productName) {
        adidasProductPage.chooseCategory(adidasProductPage.categories, sectionName);
        adidasProductPage.addToTheCart(adidasProductPage.AllLaptops, productName);

        //BrowserUtils.sleep(1);
        wait.until(ExpectedConditions.elementToBeClickable(adidasProductPage.addToCart));
        adidasProductPage.addToCart.click();
        BrowserUtils.sleep(1);
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();


    }

    @When("user navigates to {string} and deletes {string} from cart")
    public void user_navigates_to_and_deletes_from_cart(String mainOption, String productName) {
        adidasProductPage.toChooseMainOption(adidasProductPage.topMenu, mainOption);
        adidasCartPage.deleteItem(adidasCartPage.itemsInCart, productName);
    }

    @When("user clicks on {string}")
    public void user_clicks_on(String string) {
        adidasCartPage.placeOrderButton.click();

        //BrowserUtils.sleep(3);
    }

    @Then("user fill in all web form fields and clicks on {string}")
    public void user_fill_in_all_web_form_fields_and_clicks_on(String string) {
        //BrowserUtils.sleep(1);
        wait.until(ExpectedConditions.elementToBeClickable( adidasCartPage.nameInput));
        adidasCartPage.nameInput.sendKeys(faker.name().fullName());
        adidasCartPage.countryInput.sendKeys(faker.country().name());
        adidasCartPage.cityInput.sendKeys(faker.address().city());
        adidasCartPage.cardInput.sendKeys(faker.finance().creditCard());
        adidasCartPage.monthInput.sendKeys("03");
        adidasCartPage.yearInput.sendKeys("2024");
        adidasCartPage.purchaseBtn.click();


    }


//    @And("user navigates to home page")
//    public void userNavigatesToHomePage() {
//        adidasBasePage.homeBtn.click();
//    }

    @And("user sees purchase amount {int} and clicks Ok")
    public void userSeesPurchaseAmountAndClicksOk(int expectedPurchaseAmount) {
        //BrowserUtils.sleep(1);
        wait.until(ExpectedConditions.visibilityOf(adidasCartPage.purchaseConfirmation));
        int actualPurchaseAmount = adidasCartPage.getPurchaseAmount(adidasCartPage.purchaseConfirmation.getText());
        Assert.assertEquals(expectedPurchaseAmount, actualPurchaseAmount);

        adidasCartPage.okBtn.click();


    }
}
