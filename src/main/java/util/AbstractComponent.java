package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class AbstractComponent {

    WebDriver driver;

    public AbstractComponent(WebDriver driver){
        this.driver = driver;
    }

    public void waitForElementDisplay(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForElementClickable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForNewTabOpen(){
        String originalWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for(String handle : windowHandles){
            if (!handle.equals(originalWindowHandle)){
                driver.switchTo().window(handle);
            }
        }
    }


}
