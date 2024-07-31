package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterCompletePage {
    private WebDriver driver;
    private By registerComplete = By.cssSelector("div.result");
    private By continueButton = By.xpath("//a[contains(.,'Continue')]");

    public RegisterCompletePage(WebDriver driver){
        this.driver = driver;
    }
    public String registerCompleteText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerComplete));
        return driver.findElement(registerComplete).getText();
    }
    public HomePage clickContinueAfterRegister(){
        driver.findElement(continueButton).click();
        return new HomePage(driver);
    }

}
