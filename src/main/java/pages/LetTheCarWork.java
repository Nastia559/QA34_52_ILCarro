package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class LetTheCarWork extends BasePage{
    public LetTheCarWork(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory
                (driver, 10), this);
    }

    @FindBy(xpath = "//a[normalize-space()='Let the car work']")
    WebElement linkLetTheCarWork;
    @FindBy(id = "pickUpPlace")
    WebElement inputAddress;
    @FindBy(id = "make")
    WebElement inputManufacture;
    @FindBy(id = "model")
    WebElement inputModel;
    @FindBy(id = "year")
    WebElement inputYear;
    @FindBy(id = "fuel")
    WebElement inputFuel;
    @FindBy(id = "seats")
    WebElement inputSeats;
    @FindBy(id = "class")
    WebElement inputCarClass;
    @FindBy(id = "serialNumber")
    WebElement inputCarRegistrationNumber;
    @FindBy(id = "price")
    WebElement inputPrice;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnSubmit;
    @FindBy(xpath = "//mat-dialog-container//h1[@class='title']")
    WebElement errorMessage;

    public void clickLinkLetTheCarWork(){
        linkLetTheCarWork.click();
    }

    public void inputAddress(String address){
        inputAddress.click();
        inputAddress.sendKeys(address);
    }

    public void inputManufacture(String manufacture){
        inputManufacture.click();
        inputManufacture.sendKeys(manufacture);
    }

    public void inputModel(String model){
        inputModel.click();
        inputModel.sendKeys(model);
    }

    public void inputYear(int year){
        inputYear.click();
        inputYear.sendKeys(String.valueOf(year));
    }

    public void inputFuel(String fuel){
        Select select = new Select(inputFuel);
        select.selectByValue(fuel);
    }

    public void inputSeats(int seats){
        inputSeats.click();
        inputSeats.sendKeys(String.valueOf(seats));
    }

    public void inputCarClass(String carClass){
         inputCarClass.click();
         inputCarClass.sendKeys(carClass);
    }

    public void inputCarRegistrationNumber(String registrationNumber){
        inputCarRegistrationNumber.click();
        inputCarRegistrationNumber.sendKeys(registrationNumber);
    }

    public void inputPrice(float price){
        inputPrice.click();
        inputPrice.sendKeys(String.valueOf(price));
    }


    public void clickBtnSubmitWithJS() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector(\"button[type='submit']\")" +
                        ".removeAttribute('disabled');");
        btnSubmit.click();
    }

    public boolean isTextInErrorPresent(String text) {
        return errorMessage.getText().contains(text);
    }
}
