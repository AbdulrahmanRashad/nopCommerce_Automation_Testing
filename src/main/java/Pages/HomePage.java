package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    public HomePage (WebDriver driver){
        this.driver = driver;
    }

    //Locators
    private By currencyDropDown = By.id("customerCurrency");
    private By logout_nav = By.className("ico-logout");
    private By productID1 = By.xpath("//div[@data-productid=('1')]");
    private By addProduct1ToCart =
            By.xpath("//div[@data-productid=('1')]//button[contains(text(),'Add to cart')]");

    private By addProduct4ToCart =
            By.xpath("//div[@data-productid=('4')]//button[contains(text(),'Add to cart')]");
    private By wishlistProduct4 = By.xpath("//div[@class='item-box'][2]//button[3]");
    private By addProduct18ToCart =
            By.xpath("//div[@data-productid=('18')]//button[contains(text(),'Add to cart')]");
    private By wishlistProduct18 = By.xpath("//div[@class='item-box'][3]//button[3]");
    private By wishlistNotification = By.xpath("//p[@class='content']");
    private By closeWishlistBtn = By.xpath("//span[@class='close']");
    private By wishlistQty = By.xpath("//span[@class='wishlist-qty']");
    private By goToCart = By.className("ico-cart");
    private By goToWishlist = By.className("ico-wishlist");

    private By searchField = By.id("small-searchterms");
    private By searchButton = By.xpath("//button[@type='submit']"); //classname "button-1 search-box-button"


    //Methods
    public RegisterPage clickRegister_Nav(){
        return new RegisterPage(driver);
    }
    public LoginPage clickLogin_Nav(){return new LoginPage(driver);}

    public HomePage clickLogout(){
        driver.findElement(logout_nav).click();
        return new HomePage(driver);
    }
    public void selectCurrency(String option){
        Select dropdownElement = new Select(driver.findElement(currencyDropDown));
        dropdownElement.selectByVisibleText(option);
    }
    public void scrollToProducts(){
        WebElement productsDiv = driver.findElement(productID1);
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script, productsDiv);
    }
    public ProductID1 clickProduct1Cart(){
        scrollToProducts();
        driver.findElement(addProduct1ToCart).click();
        return new ProductID1(driver);
    }
    public Boolean checkLoginSuccessful(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(logout_nav));
        return driver.findElement(logout_nav).isDisplayed();
    }
    public void searchProduct(String product){
        driver.findElement(searchField).sendKeys(product);
    }

    public CartPage goToEmptyCart(){
        driver.findElement(goToCart).click();
        return new CartPage(driver);
    }

    public void addProduct18toWishlist(){
        driver.findElement(wishlistProduct18).click();
    }
    public String getWishlistNotificationText(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(wishlistNotification));
        return driver.findElement(wishlistNotification).getText();
    }
    public void closeWishlistNotification(){
        driver.findElement(closeWishlistBtn).click();
    }
    public String getWishlistQty(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(wishlistQty));
        return driver.findElement(wishlistQty).getText();
    }
}
