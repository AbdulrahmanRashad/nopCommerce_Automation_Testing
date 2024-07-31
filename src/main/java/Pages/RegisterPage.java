package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    private WebDriver driver;
    private By register = By.className("ico-register");
    private By registerText = By.xpath("//div[@class='page-title']/h1");
    //Gender Selection Start
    private String genderMale = "gender-male";
    private String genderFemale = "gender-female";
    private By genderCheckM = By.id(genderMale);
    private By genderCheckF = By.id(genderFemale);
    //Gender Selection End

    private By firstName = By.id("FirstName");
    private By firstNameError = By.id("FirstName-error");
    private By lastName = By.id("LastName");
    private By lastNameError = By.id("LastName-error");

    //Date Selection Start
    private By date_day = By.xpath("//select[@name='DateOfBirthDay']");
    private By date_month = By.xpath("//select[@name='DateOfBirthMonth']");
    private By date_year = By.xpath("//select[@name='DateOfBirthYear']");
    //Date Selection End
    private By emailField = By.id("Email");
    private By companyField = By.id("Company");
    private By checkBox = By.id("Newsletter");
    private By passField = By.id("Password");
    private By confirmPass = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");
    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }
    public void navToRegister(){
        driver.findElement(register).click();
    }
    public void selectGender(String gender){
        if(gender.equals("M")||gender.equals("male"))
           driver.findElement(genderCheckM).click();
        if(gender.equals("F")||gender.equals("female"))
            driver.findElement(genderCheckF).click();
    }
    public void setFirstName(String fName){
        driver.findElement(firstName).sendKeys(fName);
    }
    public void setLastName(String lName){
        driver.findElement(lastName).sendKeys(lName);
    }
    private Select findDropDownElement(By date){
        return new Select(driver.findElement(date));
    }
    public void selectDay(String option){
        findDropDownElement(date_day).selectByVisibleText(option);
    }
    public void selectMonth(String option){
        findDropDownElement(date_month).selectByVisibleText(option);
    }
    public void selectYear(String option){
        findDropDownElement(date_year).selectByVisibleText(option);
    }
    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public void setCompany(String companyName){
        driver.findElement(companyField).sendKeys(companyName);
    }

    public void newsCheckBox(){
        driver.findElement(checkBox).click();
    }
    public void setPassField (String password){
        driver.findElement(passField).sendKeys(password);
    }
    public void setConfirmPass(String password){
        driver.findElement(confirmPass).sendKeys(password);
    }
    public void clickRegisterButton(){
        driver.findElement(registerButton).click();
    }
    public RegisterCompletePage registerComplete(){
        return new RegisterCompletePage(driver);
    }
    public String getRegisterText(){
        return driver.findElement(registerText).getText();
    }
    public String getFirstNameErrorMsg(){
        return driver.findElement(firstNameError).getText();
    }
    public String getLastNameErrorMsg(){
        return driver.findElement(lastNameError).getText();
    }
}
