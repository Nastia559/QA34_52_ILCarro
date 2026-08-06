package ui_tests;

import dto.UserLombok;
import manager.AppManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.Random;

public class LoginTests extends AppManager
{
    @BeforeMethod
    public void goToLoginPage()
    {
        new HomePage(getDriver()).clickBtnLogin();
    }
    @Test
    public void loginPositiveTest()
    {
    //    int i = new Random().nextInt(1000);
        UserLombok user = UserLombok.builder()
                .username("nastyushas18.93@gmail.com")
                .password("Qwerty156!")
                .build();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();

        loginPage.clickBtnOk();
    }
}