package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;

    public void initializeDriver() throws IOException {

        // Set properties
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
                + "//src//main//java//resource//config.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");

        // Open browser
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "/Users/chewwenlee/Downloads/chromedriver-mac-arm64/chromedriver");
            driver = new ChromeDriver();
        }

        // Navigate to ebay website
        driver.get(prop.getProperty("url"));
    }

    @BeforeMethod
    public void launchWebApp() throws IOException {
        initializeDriver();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
