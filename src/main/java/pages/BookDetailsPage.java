package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import util.AbstractComponent;

public class BookDetailsPage extends AbstractComponent {

    WebDriver driver;

    //Constructor
    public BookDetailsPage(WebDriver driver) {
        super(driver);
        //Initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="[data-testid='x-atc-action']")
    WebElement addToCartBtn;

    @FindBy(id="x-msku__select-box-1000")
    WebElement dropDownTextBox;

    @FindBy(className="viicon-close")
    WebElement itemAddedPopup;

    @FindBy(id="gh-cart-n")
    WebElement cartNumber;

    By addToCartButton = By.cssSelector("[data-testid='x-atc-action']");

    //Locator for item added to cart popup
    By popup = By.className("vi-overlayTitleBar");

    By cartCount = By.id("gh-cart-n");

    //Method to click on add to cart button
    public void addToCart() {
        addToCartBtn.click();
    }

    public void waitForAddToCartBtnEnable(){
        waitForElementClickable(addToCartButton);
    }

    public void dropDownListAppear(){
        try{
            if(dropDownTextBox.isDisplayed()) {
                dropDownTextBox.click();
                Select dropdown = new Select(dropDownTextBox);
                dropdown.selectByValue("0");
            }
        }catch (Exception e){
            System.err.println("Caught Exception: " + e.getMessage());
        }
    }

    //Method to close down the item added to cart popup
    public void closeItemAddedPopup() {
        itemAddedPopup.click();
    }

    //Method to wait for item added to cart popup displayed
    public void waitForItemAddedToCartPopupDisplay() {
        waitForElementDisplay(popup);
    }

    //Method to wait for cart count number displayed
    public void waitForCartCountDisplay() {
        waitForElementDisplay(cartCount);
    }

    //Method to get the cart count number
    public String getCartCount(){
        return cartNumber.getText();
    }

}
