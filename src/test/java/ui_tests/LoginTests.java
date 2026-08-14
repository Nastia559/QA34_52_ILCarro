package ui_tests;

import dto.UserLombok;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import static utils.PropertiesReader.*;

import java.util.Random;

import static utils.UserFactory.positiveUser;

public class LoginTests extends AppManager {
    LoginPage loginPage;
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void goToLoginPage() {
        new HomePage(getDriver()).clickBtnLogin();
        loginPage = new LoginPage(getDriver());
    }

    @Test
    public void loginPositiveTest() {
        UserLombok user = UserLombok.builder()
                .username(getProperty("base.properties", "email"))
                .password(getProperty("base.properties", "password"))
                .build();
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();
        Assert.assertTrue(loginPage.isPopUpSuccessLoginDisplayed());
    }

    @Test
    public void loginNegativeEmailTest() {
        UserLombok user = UserLombok.builder()
                .username("nastyushas18.93gmail.com")
                .password("Qwerty156!")
                .build();
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }

    @Test
    public void loginNegativePasswordTest() {
        UserLombok user = UserLombok.builder()
                .username("nastyushas18.93@gmail.com")
                .password("Qwety156!")
                .build();
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @Test
    public void loginNegativeWrongEmailTest() {
        UserLombok user = UserLombok.builder()
                .username("astyushas18.93@gmail.com")
                .password(getProperty("base.properties", "password"))
                .build();
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();
        Assert.assertTrue(loginPage.isPopUpLoginFailedDisplayed());
    }

    @Test
    public void loginNegativeWrongPasswordTest() {
        UserLombok user = UserLombok.builder()
                .username(getProperty("base.properties", "email"))
                .password("QWerty156!")
                .build();
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();
        Assert.assertTrue(loginPage.isPopUpLoginFailedDisplayed());
    }

    @Test
    public void loginNegativeEmptyAllFieldsWithoutClickInFieldsTest(){
        loginPage.clickBtnYalla();
        Assert.assertFalse(loginPage.isBtnYallaEnabled());
    }

    @Test
    public void loginNegativeEmptyAllFieldsWithClickInFieldsTest(){
        UserLombok user = UserLombok.builder()
                .username("")
                .password("")
                .build();
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();
        softAssert.assertFalse(loginPage.isBtnYallaEnabled(), "validate isBtnYallaEnabled");
        System.out.println("test working");
        softAssert.assertTrue(loginPage.isTextInErrorPresent("Email is required"),
                "validate message: Email is required");
        softAssert.assertTrue(loginPage.isTextInErrorPresent("Password is required"),
                "validate message: Password is required");
        softAssert.assertAll();
    }
}