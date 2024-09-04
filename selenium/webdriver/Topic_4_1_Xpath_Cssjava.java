package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_4_1_Xpath_Cssjava {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");
    private String FirstName;

    @BeforeClass
    public void beforeClass() {
        System.out.println("before");
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Users\\admin\\AppData\\Local\\Mozilla Firefox\\firefox.exe"); //location where Firefox is installed
        System.out.println(options.getBinary().getPath());
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }

    @Test
    public void Register_01_Empty_Data() {
        System.out.println("tc 1");
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("tc 11");

        // Action
        driver.findElement(By.id("txtFirstname")).clear();
        driver.findElement(By.id("txtEmail")).clear();
        driver.findElement(By.id("txtCEmail")).clear();
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtCPassword")).clear();
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

        // Verify
        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");

    }

    @Test
    public void Register_02_Invalid_Email_Address() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("tc 2");

        driver.findElement(By.id("txtFirstname")).sendKeys("Phuong");
        driver.findElement(By.id("txtEmail")).sendKeys("123@");
        driver.findElement(By.id("txtCEmail")).sendKeys("123@");
        driver.findElement(By.id("txtPassword")).sendKeys("12345678");
        driver.findElement(By.id("txtCPassword")).sendKeys("12345678");
        driver.findElement(By.id("txtPhone")).sendKeys("0938618689");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");

    }
    @Test
    public void Register_03_Incorrect_Confirm_Email() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("Phuong");
        driver.findElement(By.id("txtEmail")).sendKeys("Phuong123@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("Phuong@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("12345678");
        driver.findElement(By.id("txtCPassword")).sendKeys("12345678");
        driver.findElement(By.id("txtPhone")).sendKeys("0938618689");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");

    }
    @Test
    public void Register_04_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("Phuong");
        driver.findElement(By.id("txtEmail")).sendKeys("Phuong123@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("Phuong123@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("1234");
        driver.findElement(By.id("txtCPassword")).sendKeys("1234");
        driver.findElement(By.id("txtPhone")).sendKeys("0938618689");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");

    }
    @Test
    public void Register_05_Incorrect_Confirm_Password() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("Phuong");
        driver.findElement(By.id("txtEmail")).sendKeys("Phuong123@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("Phuong123@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("12345678");
        driver.findElement(By.id("txtCPassword")).sendKeys("12345687");
        driver.findElement(By.id("txtPhone")).sendKeys("0938618689");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");

    }
    @Test
    public void Register_06_Invalid_Phone() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // phone les than 10 chars
        driver.findElement(By.id("txtFirstname")).sendKeys("Phuong");
        driver.findElement(By.id("txtEmail")).sendKeys("Phuong123@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("Phuong123@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("12345678");
        driver.findElement(By.id("txtCPassword")).sendKeys("12345678");
        driver.findElement(By.id("txtPhone")).sendKeys("093861868");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");

        // phone more than 11 chars
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("093861868311");

        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");

        // phone # Phone Center number
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("1234567890");

        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");

    }


    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}