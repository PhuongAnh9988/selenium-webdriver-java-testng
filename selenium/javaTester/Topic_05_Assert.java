package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_05_Assert {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

//    @BeforeClass
//    public void beforeClass() {
//        if (osName.contains("Windows")) {
//            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//        } else {
//            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//        }
//
//        FirefoxOptions options = new FirefoxOptions();
//        options.setBinary("C:\\Users\\admin\\AppData\\Local\\Mozilla Firefox\\firefox.exe"); //location where Firefox is installed
//        System.out.println(options.getBinary().getPath());
//        driver = new FirefoxDriver(options);
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.get("https://www.facebook.com/");
//    }

    @Test
    public void verifyTestNG() {
        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/");

        // Kieu du lieu nhan vao la boolen (true/false)
        // Khi mong muon dkien tra ve la dung thi dung assertTrue de verify
        Assert.assertTrue(driver.getPageSource().contains(""));

        // Cac ham tra ve kieu du lieu boolean
        // Quy tac: bdau vs tien to laf isXXX
        driver.findElement(By.id("")).isDisplayed();
        driver.findElement(By.id("")).isEnabled();
        driver.findElement(By.id("")).isSelected();
        new Select(driver.findElement(By.id(""))).isMultiple();

        // Mong doi 1 dkien giong vs thuc te (tuyet doi)
        // Actual = Exxpected
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
        Assert.assertEquals(driver.findElement(By.id("")).getText(), "creat a new account");

        // Unit Test
        Object name = null;
        Assert.assertNull(name);


    }

    }




//    @AfterClass
//    public void afterClass() throws InterruptedException {
//        Thread.sleep(2000);
//        driver.quit();
//    }{
//}
