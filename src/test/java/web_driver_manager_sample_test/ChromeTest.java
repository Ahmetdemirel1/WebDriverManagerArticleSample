package web_driver_manager_sample_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromeTest {

    private WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {

        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void chromeTest(){

        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get("https://www.hepsiburada.com/");
        By searchBox = By.xpath(".//div[@id='SearchBoxOld']//input");
        driver.findElement(searchBox).sendKeys("bilgisayar");
    }
}
