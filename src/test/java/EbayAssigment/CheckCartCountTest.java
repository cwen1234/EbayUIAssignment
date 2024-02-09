package EbayAssigment;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.BookDetailsPage;
import pages.BookListPage;
import pages.HomePage;

import java.util.List;
import static org.testng.Assert.assertEquals;

public class CheckCartCountTest extends BaseTest {

    @Test
    public void checkCartCount() {

        // 1. Open browser
        // 2. Navigate to ebay.com website (HomePage)
        // Above scenarios are handling under BaseTest.java
        
        // 3. Search for ‘book’
        HomePage homePage = new HomePage(driver);
        homePage.SearchBook("book");

        // Wait for all the books displayed on page
        BookListPage bookListPage = new BookListPage(driver);
        bookListPage.getBookList();

        // 4. Click on the first book in the list
        List<WebElement> books = driver.findElements(By.className("s-item__title"));
        books.get(1).click();

        // Wait for new tab opens
        bookListPage.waitForNewTabOpen();

        // Wait for Add to Cart button displayed
        BookDetailsPage bookDetailPage = new BookDetailsPage(driver);
        bookDetailPage.waitForAddToCartBtnEnable();

        // Check if book selection dropdown list appears in Book Details page
        // If yes, select the first item from the dropdown before clicking Add to Cart
        // If no, can skip this step and proceed to Add to Cart
        bookDetailPage.dropDownListAppear();

        // 5. In the item listing page, click on ‘Add to cart’
        bookDetailPage.addToCart();

        // Wait for item added to cart popup page loads
        bookDetailPage.waitForItemAddedToCartPopupDisplay();

        // Close the item added to cart popup
        bookDetailPage.closeItemAddedPopup();

        // Wait for the count number on the cart icon displayed
        bookDetailPage.waitForCartCountDisplay();

        // 6. Verify the cart has been updated and displays the number of items in the cart
        assertEquals(bookDetailPage.getCartCount(), "1");

    }
}
