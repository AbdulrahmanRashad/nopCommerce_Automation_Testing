package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }
    private WebDriverWait wait;
    //Locators
    private By deleteSavedAddress = By.id("delete-billing-address-button");
    //AddressDetails
    private By fName = By.id("BillingNewAddress_FirstName");
    private By LName = By.id("BillingNewAddress_LastName");
    private By emailField = By.id("BillingNewAddress_Email");
    private By countryField = By.id("BillingNewAddress_CountryId");
    private By stateField = By.id("BillingNewAddress_StateProvinceId");
    private By stateFieldChildLocator =
            By.xpath("By.xpath(//select[@id='BillingNewAddress_StateProvinceId']//option[@value='53'])");
    private By cityField = By.id("BillingNewAddress_City");
    private By address1Field = By.id("BillingNewAddress_Address1");
    private By postalCodeField = By.id("BillingNewAddress_ZipPostalCode");
    private By phoneNumberField = By.id("BillingNewAddress_PhoneNumber");
    private By faxNumberField = By.id("BillingNewAddress_FaxNumber");
    private By addressContinueNavBar = By.id("billing-buttons-container");
    private By addressContinueBtn = By.xpath("//button[contains(@onclick, 'Billing.save()')]");

    private By country_select = By.xpath("//select[@name='BillingNewAddress.CountryId']");
    private By State_select = By.xpath("//select[@name='BillingNewAddress.StateProvinceId']");
    //ShippingDetails
    private By groundShippingMethod = By.id("shippingoption_0");
    //private By loginButton = By.xpath("//button[contains(@class,'login-button')]");
    private By shippingContinueNavBar = By.id("shipping-method-buttons-container");
    private By shippingContinueBtn = By.xpath("//button[contains(@onclick,'ShippingMethod.save()')]");

    //PaymentMethod
    private By paymentMethodCC = By.id("paymentmethod_1");
    private By paymentContinueNavBar = By.id("payment-method-buttons-container");
    private By paymentMethodContinueBtn = By.xpath("//button[contains(@onclick,'PaymentMethod.save()')]");

    //CreditCardDetails
    private By creditCardType = By.id("CreditCardType");
    private By cardHolder = By.id("CardholderName");
    private By cardNumber = By.id("CardNumber");
    private By expireYear = By.id("ExpireYear");
    private By cardCode = By.id("CardCode");
    private By paymentInfoContinueNavBar = By.id("payment-info-buttons-container");
    private By paymentInfoContinueBtn = By.xpath("//button[contains(@onclick,'PaymentInfo.save()')]");

    //ConfirmPurchase
    private By cartTableOfContent = By.xpath("//button[contains(@onclick,'ConfirmOrder.save()')]");
    private By confirmationContinueNavBar = By.id("confirm-order-buttons-container");
    private By confirmationContinueBtn = By.xpath("//button[contains(@onclick,'ConfirmOrder.save()')]");

    //Methods
    private Select findDropDownElement(By date){
        return new Select(driver.findElement(date));
    }
    public void clickDeleteSavedAddress(){
        //wait.until(ExpectedConditions.elementToBeClickable(deleteSavedAddress));
        if(driver.findElement(deleteSavedAddress).isDisplayed()){
            driver.findElement(deleteSavedAddress).click();
        }
    }
    //AddressDetails
    public void setFName(String firstName) {
        wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(fName));
        driver.findElement(fName).clear();
        driver.findElement(fName).sendKeys(firstName);
    }
    public void setLName(String lastName){
        driver.findElement(LName).clear();
        driver.findElement(LName).sendKeys(lastName);
    }
    public void setEmail(String email){
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }
    public void setCountry(String companyName){
        findDropDownElement(country_select).selectByVisibleText(companyName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
    public void setState(String StateName){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(countryField));
        findDropDownElement(State_select).selectByVisibleText(StateName);
    }
    public void setCountryField(int countryIndex){
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(stateField,stateFieldChildLocator));
        Select chooseCountry = new Select(driver.findElement(countryField));
        chooseCountry.selectByIndex(countryIndex);
    }
    public void setStateField(int stateIndex) {
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(stateField,stateFieldChildLocator));
        Select chooseState = new Select(driver.findElement(stateField));
        chooseState.selectByIndex(stateIndex);
    }
    public void setCityField(String city){
        driver.findElement(cityField).sendKeys(city);
    }
    public void setAddress1Field (String address){
        driver.findElement(address1Field).sendKeys(address);
    }
    public void setPostalCodeField(String postal){
        driver.findElement(postalCodeField).sendKeys(postal);
    }
    public void setPhoneNumberField(String phoneNumber){
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }
    public void setFaxNumberField(String faxNumber){
        driver.findElement(faxNumberField).sendKeys(faxNumber);
    }
    public void clickAddressContinueBtn(){
        driver.findElement(addressContinueNavBar).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.findElement(addressContinueBtn).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }
    //ShippingDetails
    public void clickShippingContinueBtn() {
        driver.findElement(shippingContinueNavBar).click();
        driver.findElement(shippingContinueBtn).click();
    }
    //PaymentMethod
    public void choosePaymentMethod() {
        wait.until(ExpectedConditions.elementToBeClickable(paymentMethodCC));
        driver.findElement(paymentMethodCC).click();
    }
    public void clickPaymentMethodContinueBtn(){

        driver.findElement(paymentContinueNavBar).click();
        driver.findElement(paymentMethodContinueBtn).click();
    }

    //CreditCardDetails
    public void selectCreditType(String option) {
        //Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(creditCardType));
        Select select = new Select(driver.findElement(creditCardType));
        select.selectByVisibleText(option);
    }
    public void setCardHolder(String cardHolderName){
        driver.findElement(cardHolder).sendKeys(cardHolderName);
    }
    public void setCardNumber(String cardNum){
        driver.findElement(cardNumber).sendKeys(cardNum);
    }
    public void selectExpireYear(String year){
        Select select = new Select(driver.findElement(expireYear));
        select.selectByVisibleText(year);
    }
    public void setCardCode(String code){
        driver.findElement(cardCode).sendKeys(code);
    }
    public void clickPaymentInfoContinueBtn(){

        driver.findElement(paymentInfoContinueNavBar).click();
        driver.findElement(paymentInfoContinueBtn).click();
    }

    public void clickConfirmationBtn(){

        driver.findElement(confirmationContinueNavBar).click();
        driver.findElement(confirmationContinueBtn).click();
    }

    //ConfirmPurchase
    public CheckoutCompletePage clickConfirmationContinueBtn() {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationContinueBtn));
        driver.findElement(confirmationContinueNavBar).click();
        driver.findElement(confirmationContinueBtn).click();
        return new CheckoutCompletePage(driver);
    }

}
