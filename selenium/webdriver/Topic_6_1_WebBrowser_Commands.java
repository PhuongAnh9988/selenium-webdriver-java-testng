package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Topic_6_1_WebBrowser_Commands {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

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
        driver.get("https://www.facebook.com/");
    }
//        driver = new FirefoxDriver();
//        driver = new ChromeDriver();
//        driver = new EdgeDriver();
//        driver = new SafariDriver();
//
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().window().maximize();

    @Test
    public void TC_01_() throws MalformedURLException {
        // Mở ra 1 page Url bất kì
        driver.get("https://www.facebook.com/");

        // Neu cos 1 tab/window thi tinh nag tuong tu nhu quit
        // Nhieu hown 1 tab thi se dong cai dang action
        driver.close();

        // Dong browser (ko care bn tab/window)
        driver.quit();

        // Tra ve 1 element neu nhu tim thay nhieu hon 1 thi cung chi lay 1 (thao tac voi cai dau tien)
        WebElement emailAddressTextbox = driver.findElement(By.id("email"));

        // no se di tim vs loai By nao tra ve 1 danh sach element neu nhu dc tim thay ( list WebElement)
        // Ko dc tim thay - ko bi fail - tra ve 1 list rong (0 element)
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        // Tai sao lai can phai lay du lieu ra de lam gi?
        String loginPageUrl = driver.getCurrentUrl();
        driver.getPageSource();
        driver.getTitle();
        driver.getWindowHandle();
        driver.getWindowHandles();

        // Cookies - Framework
        driver.manage().getCookies();

        // Get ra nhung log o Dev Tool
        driver.manage().logs().get(LogType.DRIVER);

        // Apply cho viec tim element (findElement/findElements)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Cho cho page dc load xog
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        // Selenium 4 moi co
        driver.manage().timeouts().getImplicitWaitTimeout();
        driver.manage().timeouts().getPageLoadTimeout();
        driver.manage().timeouts().getScriptTimeout();

        // Chay full man hinh
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();
        driver.manage().window().minimize();

        // Tesst GUI
        // Test Responsive (Resolution)
        driver.manage().window().setSize(new Dimension(1366, 768));

        driver.manage().window().getSize();

        // Set cho browser o vtri nao so vs do phan giai man hinh (run tren man hinh co kich thuoc bn)
        driver.manage().window().setPosition(new Point(0, 0));

        // Dieu huong trang web
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();

        // Thao tac vs history cua web page(back/foward)
        driver.navigate().to("https://www.facebook.com/");
        driver.navigate().to(new URL("https://www.facebook.com/"));
        driver.get("https://www.facebook.com/");

        // Alert/ Window (tab)/ Frame (iFrame)
        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("Test");

        // Laays ra ID cua cua so/ tab hien tai
        // Handle Window/ Tab
        String homePageWindowID = driver.getWindowHandle();
        driver.switchTo().window(homePageWindowID);

        Set<String> allWindowIDs = driver.getWindowHandles();

        // Switch ve HTML chua frame trc do
        driver.switchTo().parentFrame();






        // Neu chi dung 1 lan thi k khai bao bien
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");

        // Dung lai nhieu lan (tu 2 lan tro len)
        Assert.assertEquals(loginPageUrl, "https://www.facebook.com/");



    }

    @Test
    public void TC_02_() {

    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}