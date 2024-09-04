package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_11_Buttonjava {
    WebDriver driver;
    WebDriverWait expliciWait;
    String registerBackgroundRGB;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        expliciWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Egov_Button() {
        driver.get("https://egov.danang.gov.vn/reg");
        WebElement registerButton = driver.findElement(By.cssSelector("input.egov-button"));

        // Verify button bi disable khi chua click vao checkbox
        Assert.assertFalse(registerButton.isEnabled());

        driver.findElement(By.cssSelector("input#chinhSach")).click();
        sleepInSeconds(2);

        // Verify button da dc enable sau khi click vao checkbox
        Assert.assertTrue(registerButton.isEnabled());

        // Lay ra ma mau nen cua button
        String registerBackgroundRGB = registerButton.getCssValue("background-color");
        System.out.println("Background color RGB = " + registerBackgroundRGB);

        // Covert tu kieu string (ma RGB) qua kieu Color
        Color registerBackgroundColour = Color.fromString(registerBackgroundRGB);

        // Convert qua kieu Hexa
        String registerBackgroundHexa = registerBackgroundColour.asHex();
        System.out.println("Background color Hexa = " + registerBackgroundHexa);

        Assert.assertEquals(registerBackgroundHexa, "#ef5a00");

    }

    @Test
    public void TC_02_Fahasa_Button() {
        driver.get("https://www.fahasa.com/customer/account/create");

        // chuyen qua tab Dang nhap
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
        sleepInSeconds(2);

        WebElement loginButton = driver.findElement(By.cssSelector("button.fhs-btn-login"));

        // Verify login button is disabled
        Assert.assertFalse(loginButton.isEnabled());

        // Veify login button = background
        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(), "#000000");

        // Nhap Email/ Pass
        driver.findElement(By.cssSelector("input#login_username")).sendKeys("panh@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456");
        sleepInSeconds(2);

        // Verify login button is enabled
        Assert.assertTrue(loginButton.isEnabled());

        // Verify login button = background
        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(), "#c92127");

    }

    @AfterClass
    public void afterClass() { driver.quit(); }
    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}