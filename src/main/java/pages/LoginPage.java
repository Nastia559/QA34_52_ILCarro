package pages;

import dto.UserLombok;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//input[@id='email']")
    WebElement inputEmail;
    @FindBy(xpath = "//input[@id='password']")
    WebElement inputPassword;
    @FindBy(xpath = "//button[contains(text(),'Y’alla')]")
    WebElement btnYalla;
    @FindBy(xpath = "//h1[text()='Logged in']")
    WebElement popUpSuccessLogin;
    @FindBy(xpath = "//h1[text()='Login failed']")
    WebElement popUpLoginFailed;
    @FindBy(xpath = "//button[normalize-space()='Ok']")
    WebElement btnOk;
    @FindBy(xpath = "//h2[@class='message']")
    WebElement errorMessage;
    @FindBy(xpath = "//button[normalize-space()='Ok']")
    WebElement btnOk1;

    public void typeLoginForm(UserLombok user) {
        inputEmail.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
    }

    public void clickBtnYalla() {
        btnYalla.click();
    }

    public void clickBtnOk() {
        btnOk.click();
    }

    public boolean isLoginPageDisplayed() {
        return inputEmail.isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    public void clickBtnOk1() {
        btnOk1.click();
    }
    public boolean isPopUpSuccessLoginDisplayed() {
        return isElementDisplayed(popUpSuccessLogin);
    }

    public boolean isPopUpLoginFailedDisplayed() {
        return isElementDisplayed(popUpLoginFailed);
    }
    public boolean isBtnYallaEnabled() {
        return btnYalla.isEnabled();
    }
}

