package web_driver_manager_sample_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirefoxTest {

    private WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @After
    public void teardown() {

        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void firefoxTest(){

        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get("https://www.hepsiburada.com/");
        By searchBox = By.xpath(".//div[@id='SearchBoxOld']//input");
        driver.findElement(searchBox).sendKeys("bilgisayar");
    }
}
