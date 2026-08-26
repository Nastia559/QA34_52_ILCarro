package ui_tests;

import dto.UserLombok;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LetTheCarWork;
import pages.LoginPage;

import static utils.PropertiesReader.getProperty;


public class LetTheCarWorkTests extends AppManager {
    LoginPage loginPage;
    LetTheCarWork letTheCarWork;

    @BeforeMethod
    public void loginPositiveTest() {
        new HomePage(getDriver()).clickBtnLogin();
        loginPage = new LoginPage(getDriver());

        UserLombok user = UserLombok.builder()
                .username(getProperty("base.properties", "email"))
                .password(getProperty("base.properties", "password"))
                .build();
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();

        letTheCarWork = new LetTheCarWork(getDriver());
    }

    @Test
    public void positiveAddCar(){
        logger.info("Adding car");
        letTheCarWork.clickLinkLetTheCarWork();
        letTheCarWork.inputAddress("Ashkelon");
        letTheCarWork.inputManufacture("BMW");
        letTheCarWork.inputModel("X5");
        letTheCarWork.inputYear(2024);
        letTheCarWork.inputFuel("Hybrid");
        letTheCarWork.inputSeats(4);
        letTheCarWork.inputCarClass("C");
        letTheCarWork.inputCarRegistrationNumber("L1234567");
        letTheCarWork.inputPrice(200);
        letTheCarWork.clickBtnSubmitWithJS();
        Assert.assertTrue(letTheCarWork.isTextInErrorPresent("Car adding failed"),
                "validate message: Car adding failed");
    }
}
