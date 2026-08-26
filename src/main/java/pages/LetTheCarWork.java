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

    public void inputAddress(){
        inputAddress.click();
        inputAddress.sendKeys("Ashkelon");
    }

    public void inputManufacture(){
        inputManufacture.click();
        inputManufacture.sendKeys("BMW");
    }

    public void inputModel(){
        inputModel.click();
        inputModel.sendKeys("X5");
    }

    public void inputYear(){
        inputYear.click();
        inputYear.sendKeys("2024");
    }

    public void inputFuel(){
        Select select = new Select(inputFuel);
        select.selectByValue("Hybrid");
    }

    public void inputSeats(){
        inputSeats.click();
        inputSeats.sendKeys("4");
    }

    public void inputCarClass(){
         inputCarClass.click();
         inputCarClass.sendKeys("C");
    }

    public void inputCarRegistrationNumber(){
        inputCarRegistrationNumber.click();
        inputCarRegistrationNumber.sendKeys("1234567");
    }

    public void inputPrice(){
        inputPrice.click();
        inputPrice.sendKeys("200");
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
