package Pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage{
    private WebDriver driver;
    public CartPage(WebDriver driver){this.driver = driver;}

    //Locators
    private By cartTable = By.cssSelector(".cart");
    private By termsOfService = By.id("termsofservice");
    private By checkoutBtn = By.id("checkout");
    private By productSKU = By.className("sku-number");
    private By removeFirstItem = By.xpath("//tr[1]//button[@class='remove-btn']");
    private By removeSecondItem = By.xpath("//tr[1]//button[@class='remove-btn']");
    private By emptyCartText = By.className("no-data");

    public Boolean checkVisibilityOfCartTable(){
        return driver.findElement(cartTable).isDisplayed();
    }
    public void acceptTermsOfService(){
        driver.findElement(termsOfService).click();
    }
    public CheckoutPage clickCheckOut(){
        driver.findElement(checkoutBtn).click();
        return new CheckoutPage(driver);
    }
    public String getProductNameFromTable(){
        return driver.findElement(productSKU).getText();
    }
    public void removeItemFromCart(int tableRow){
        if(tableRow == 1){
            driver.findElement(removeFirstItem).click();
        }
        else if (tableRow == 2) {
            driver.findElement(removeSecondItem).click();
        }
    }
    public String getEmptyCartText(){
        return driver.findElement(emptyCartText).getText();
    }


}
