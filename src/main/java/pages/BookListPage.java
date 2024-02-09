package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.AbstractComponent;

public class BookListPage extends AbstractComponent {

    WebDriver driver;

    //Constructor
    public BookListPage(WebDriver driver) {
        super(driver);
        //Initialization
        this.driver = driver;
//        PageFactory.initElements(driver, this);
    }

    //Locator for book list content
    By BookListContent = By.id("mainContent");

    //Method to wait for all the books displaying on Book List page
    public void getBookList() {
        waitForElementDisplay(BookListContent);
    }
}
