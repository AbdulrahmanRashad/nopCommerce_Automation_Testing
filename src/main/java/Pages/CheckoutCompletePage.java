package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutCompletePage {
    private WebDriver driver;
    public WebDriverWait wait;
    public CheckoutCompletePage(WebDriver driver){
        this.driver=driver;
    }
    private By lastContinueBtn = By.xpath("//button[contains(.,'Continue')]");
    private By confirmationMsg = By.xpath("//strong[contains(.,'Your order has been successfully processed!')]");

    public String checkConfirmationMsg(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMsg));
        return driver.findElement(confirmationMsg).getText();
    }
    public HomePage clickLastContinueBtn(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(lastContinueBtn));
        driver.findElement(lastContinueBtn).click();
        return new HomePage(driver);
    }
}
