package ui_tests;

import dto.Car;
import dto.UserLombok;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LetTheCarWorkPage;
import pages.LoginPage;
import pages.PopUpPage;
import utils.enums.HeaderMenu;

import java.time.LocalDate;

import static utils.CarFactory.*;

import static utils.PropertiesReader.getProperty;


public class AddNewCarTests extends AppManager {
    LoginPage loginPage;
    LetTheCarWorkPage letTheCarWorkPage;

    @BeforeMethod
    public void goToLetTheCarWorkPage() {
//        new HomePage(getDriver()).clickBtnLogin();
//        loginPage = new LoginPage(getDriver());
        loginPage = new HomePage(getDriver())
                .clickHeaderButtons(HeaderMenu.LOGIN);
        UserLombok user = UserLombok.builder()
                .username(getProperty("base.properties", "email"))
                .password(getProperty("base.properties", "password"))
                .build();
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();
        new PopUpPage(getDriver()).clickBtnOk();
        letTheCarWorkPage = new HomePage(getDriver())
                .clickHeaderButtons(HeaderMenu.LET_THE_CAR_WORK);
    }

    @Test
    public  void addNewCarPositiveTest(){
        Car car = positiveCar();
        System.out.println(car);
        letTheCarWorkPage.typeAddNewCarForm(car);
        letTheCarWorkPage.downloadImage("cat1.jpg");
        letTheCarWorkPage.clickBtnSubmitWithJS();
        Assert.assertTrue(new PopUpPage(getDriver())
                .isTextInPopUpMessagePresent("{\"city\":\"must not be blank\"}"));
    }

    @Test
    public void positiveAddCarTest(){
        logger.info("Adding car");
        letTheCarWorkPage.clickLinkLetTheCarWork();
        letTheCarWorkPage.inputAddress("Ashkelon");
        letTheCarWorkPage.inputManufacture("BMW");
        letTheCarWorkPage.inputModel("X5");
        letTheCarWorkPage.inputYear("2024");
        letTheCarWorkPage.inputFuel("Hybrid");
        letTheCarWorkPage.inputSeats(4);
        letTheCarWorkPage.inputCarClass("C");
        letTheCarWorkPage.inputCarRegistrationNumber("L1234567");
        letTheCarWorkPage.inputPrice(200.0);
        letTheCarWorkPage.clickBtnSubmitWithJS();
        Assert.assertTrue(letTheCarWorkPage.isTextInErrorPresent("Car adding failed"),
                "validate message: Car adding failed");
    }

    // HW. Negative Tests
    // 1. Only click btn Submit (без заполнения)
    // 2. click all fields and btnSubmit
    // 3. leave one field blank and other fields type with valid data
    // 4. wrong year
}
