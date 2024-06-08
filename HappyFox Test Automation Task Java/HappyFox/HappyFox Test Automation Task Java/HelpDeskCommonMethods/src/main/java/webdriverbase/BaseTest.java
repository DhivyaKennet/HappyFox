package webdriverbase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
    	
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\test\\Desktop\\D drive\\automation\\Chrome driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    
    @AfterSuite
    public void afterSuite() {
        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}


