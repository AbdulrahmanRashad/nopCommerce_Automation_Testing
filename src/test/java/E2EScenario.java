

import Pages.*;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.assertEquals;

public class E2EScenario extends OpenWebsite {
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public ProductID1 productID1;
    public CheckoutCompletePage checkoutComplete;
    private String firstName = "Abdulrahman";
    private String lastName = "Tahoun";
    private String email = "abdotahoun55588@gmail.com";
    private String pass = "3456734tt";
    @Test
    public void fullUserPurchaseScenario(){
        testSuccessfulRegister(firstName,lastName,email,pass);
        homePage.clickLogin_Nav();
        testSuccessfulLogin(email,pass);
        assertEquals(Optional.ofNullable(homePage.checkLoginSuccessful()),true,"Not Logged In");
        fillProductID1();
        assertEquals(Optional.ofNullable(cartPage.checkVisibilityOfCartTable()),true,"table not visible");
        cartPage.acceptTermsOfService();
        checkoutPage = cartPage.clickCheckOut();
        fillCheckout();
        checkoutComplete = checkoutPage.clickConfirmationContinueBtn();
        assertEquals(checkoutComplete.checkConfirmationMsg(),
                "Your order has been successfully processed!",
                "Msg Not matched");
        checkoutComplete.clickLastContinueBtn();
        }
    public void testSuccessfulRegister(String fname,String lname, String email,String pass) {
        RegisterPage registerPage = homePage.clickRegister_Nav();
        registerPage.navToRegister();
        registerPage.selectGender("male");
        registerPage.setFirstName(fname);
        registerPage.setLastName(lname);
        registerPage.selectDay("16");
        registerPage.selectMonth("December");
        registerPage.selectYear("1998");
        registerPage.setEmail(email);
        registerPage.setCompany("ITI");
        registerPage.newsCheckBox();
        registerPage.setPassField(pass);
        registerPage.setConfirmPass(pass);
        registerPage.clickRegisterButton();
        RegisterCompletePage registerCompletePage = registerPage.registerComplete();
        registerCompletePage.clickContinueAfterRegister();
    }
    public void testSuccessfulLogin(String email, String pass){
        LoginPage loginPage = homePage.clickLogin_Nav();
        loginPage.navToLogin();
        loginPage.setEmailField(email);
        loginPage.setPassField(pass);
        loginPage.setRememberCheck();
        loginPage.clickLogin();
    }
    public void fillProductID1() {
        productID1 = homePage.clickProduct1Cart();
        String option = "2.2 GHz Intel Pentium Dual-Core E2200"; //"2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]"
        productID1.selectProcessor(option); //Added WebDriverWait to selectProcessor Method because of NoSuchElementException
        productID1.selectRam(1);
        productID1.selectHDD();
        productID1.selectOS();
        productID1.clickAddToCart();
        assertEquals(productID1.getNotificationText(),
                "The product has been added to your shopping cart",
                "msg not matched");
        productID1.closeNotification();
        cartPage = productID1.navToCart();
    }
    public void fillCheckout(){
        checkoutPage.clickDeleteSavedAddress();
        checkoutPage.setFName(firstName);
        checkoutPage.setLName(lastName);
        checkoutPage.setEmail(email);
        checkoutPage.setCountry("Egypt");
        checkoutPage.setState("Other");
        checkoutPage.setCityField("Shebin");
        checkoutPage.setAddress1Field("Menoufia");
        checkoutPage.setPostalCodeField("123456");
        checkoutPage.setPhoneNumberField("123456");
        checkoutPage.setFaxNumberField("12345");
        checkoutPage.clickAddressContinueBtn();
        checkoutPage.clickShippingContinueBtn();
        checkoutPage.choosePaymentMethod();
        checkoutPage.clickPaymentMethodContinueBtn();
        checkoutPage.selectCreditType("Visa");
        checkoutPage.setCardHolder(firstName);
        checkoutPage.setCardNumber("5078034895265903");
        checkoutPage.selectExpireYear("2025");
        checkoutPage.setCardCode("123");
        checkoutPage.clickPaymentInfoContinueBtn();
        checkoutPage.clickConfirmationBtn();
    }
}
