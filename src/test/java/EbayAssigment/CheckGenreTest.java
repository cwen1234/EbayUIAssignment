package EbayAssigment;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BookListPage;
import pages.HomePage;

public class CheckGenreTest extends BaseTest {

   @Test
    public void CheckGenreTest() {

        // Search for ‘book’
        HomePage homePage = new HomePage(driver);
        homePage.SearchBook("book");

        // Wait for all the books displayed on page
        BookListPage bookListPage = new BookListPage(driver);
        bookListPage.getBookList();

        // Select one of the Genre checkbox "Fantasy"
        driver.findElement(By.xpath("//input[@aria-label=\"Fantasy\"]")).click();

        WebElement link = driver.findElement(By.className("srp-carousel-list__item-link"));
        String trimGenreTitle = link.getText().substring(0,7);

        // Verify the filter icon is displayed
        Assert.assertTrue(link.isDisplayed());
        Assert.assertEquals(trimGenreTitle, "Fantasy");

    }


}
