package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_09_Defaul_Dropdownjava {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");
    private CharSequence confirmation;

    String firstName = "Phuong", lastName = "Anh", emailAddress = getEmailAddress();
    String companyName = "Selenium WebDriver", password = "123456";
    String day = "3", month = "July", year = "1996";
    By emailAddressBy = By.cssSelector("input#Email");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Users\\admin\\AppData\\Local\\Mozilla Firefox\\firefox.exe"); //location where Firefox is installed
        System.out.println(options.getBinary().getPath());
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void TC_01_Register() {
        driver.findElement(By.cssSelector("a.ico-register")).click();
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);

        // Day Dropdown
        Select dayDropdown = new Select(driver.findElement(By.name("DateOfBirthDay")));
        // Chon ngay
        dayDropdown.selectByVisibleText(day);

        // new Select(driver.findElement(By.name("DateOfBirthDay"))).selectByVisibleText("15");

        // Verify dropdown nay la Sigle (ko phai Multiple)
        Assert.assertFalse(dayDropdown.isMultiple());

        // Verify so luong item trong Dropdown la 32 item
        Assert.assertEquals(dayDropdown.getOptions().size(), 32);

        new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText("July");
        new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText("1996");

        driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#Company")).sendKeys(companyName);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys(password);

        driver.findElement(By.cssSelector("button#register-button")).click();
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(),"Your registration completed");
    }

    @Test
    public void TC_02_Login() {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//a[@class='ico-logout']")).click();

        // Login
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
        driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
        sleepInSecond(2);

        // Verify
        driver.findElement(By.xpath("//a[@class='ico-account']")).click();
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"), lastName);

        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(), day);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(), month);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(), year);

        Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"), emailAddress);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"), companyName);


    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getEmailAddress() {
        Random rand = new Random();
        return "phuonganh" + rand.nextInt(99999) + "@gmail.com";
    }

}