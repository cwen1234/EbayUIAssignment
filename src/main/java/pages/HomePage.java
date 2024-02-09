package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    //Constructor
    public HomePage(WebDriver driver) {
        //Initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(id="gh-ac")
    WebElement searchTxtBox;

    //Locators
    @FindBy(id="gh-btn")
    WebElement submitBtn;

    //Enter 'Book' into search text box and click on submit button
    public void SearchBook(String book) {
        searchTxtBox.sendKeys(book);
        submitBtn.click();
    }

}
