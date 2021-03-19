package web_driver_manager_sample_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ChromeFirefoxTest {

    protected WebDriver chrome;
    protected WebDriver firefox;

    @Before
    public void setUp(){

        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.chromedriver().setup();
        chrome = new ChromeDriver();
        firefox = new FirefoxDriver();
    }

    @After
    public void teardown() {
        if (chrome != null) {
            chrome.quit();
        }
        if (firefox != null) {
            firefox.quit();
        }
    }

    @Test
    public void chromeFirefoxTest(){

        int timeout = 30;
        String url = "https://www.hepsiburada.com/";


        chrome.manage().timeouts().implicitlyWait(timeout, SECONDS);
        firefox.manage().timeouts().implicitlyWait(timeout, SECONDS);

        chrome.get(url);
        firefox.get(url);
    }
}
