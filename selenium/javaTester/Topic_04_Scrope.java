package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_04_Scrope {
    WebDriver driver;
    private String homePageUrl;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
    }
}



