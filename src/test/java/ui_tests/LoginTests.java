package ui_tests;

import dto.UserLombok;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.Random;

import static utils.UserFactory.positiveUser;

public class LoginTests extends AppManager {
    LoginPage loginPage;
    @BeforeMethod
    public void goToLoginPage() {
        new HomePage(getDriver()).clickBtnLogin();
        loginPage = new LoginPage(getDriver());
    }

    @Test
    public void loginPositiveTest() {
        UserLombok user = UserLombok.builder()
                .username("nastyushas18.93@gmail.com")
                .password("Qwerty156!")
                .build();
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();

        loginPage.clickBtnOk();
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
        loginPage.clickBtnOk1();
    }
}