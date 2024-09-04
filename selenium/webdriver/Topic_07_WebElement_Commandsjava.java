package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_07_WebElement_Commandsjava<Dimension> {
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

    @Test
    public void TC_01_Element() {
        // Dung de xoa du lieu trong 1 filed cho phep nhap (editable)
        // TeTexeTeTextbox/ TextArea/ Dropdown (Editable)
        // Thuong dc sd trc ham sendKyes
        driver.findElement(By.id("")).clear();

        // Dung de nhap lieu vao cac filed ben tren
        driver.findElement(By.id("")).sendKeys("");

        // Dung de click len element
        driver.findElement(By.id("")).click();

        // Tim tu node cha vao node con
        driver.findElement(By.id("form-validate")).findElement(By.id("firstname"));
        driver.findElement(By.id("form-validate")).findElements(By.cssSelector("input"));

        driver.findElement(By.cssSelector("form#form-validate input#firstname"));

        // Tra ve 1 element khop vs dkien
        WebElement fullNameTextbox = driver.findElement(By.id(""));

        // Tra ve nhieu element khop vs dkien
        List<WebElement> textboxs = driver.findElements(By.cssSelector(""));

        // Dung de verify 1 checkbox/ radio/ dropdpwn (default dc dc chon hay chua)
        Assert.assertTrue(driver.findElement(By.id("")).isSelected());
        Assert.assertTrue(driver.findElement(By.id("")).isSelected());

        // Dropdown (defaul/ custom)
        Select select = new Select(driver.findElement(By.id("")));

        // Dung de verify 1 element bat ki co hien thi hay k
        Assert.assertTrue(driver.findElement(By.id("")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.id("")).isDisplayed());

        // Dung de verify 1 element co dc thao tac len hay k (phai read-only)
        Assert.assertTrue(driver.findElement(By.id("")).isEnabled());
        Assert.assertFalse(driver.findElement(By.id("")).isEnabled());

        // HTML Emlement
        // <input type ="text" id="firstname" name="firstname" value=""
        // title="First Name" maxlength="255" class="input-text required-entry">
        driver.findElement(By.id("")).getAttribute("title");
        driver.findElement(By.id("")).getAttribute("type");
        driver.findElement(By.id("")).getAttribute("id");

        //Tab Accesibility/ Properties trong Elements
        driver.findElement(By.id("")).getAccessibleName();
        driver.findElement(By.id("")).getDomAttribute("checked");
        driver.findElement(By.id("")).getDomProperty("baseURI");
        driver.findElement(By.id("")).getDomProperty("outerHTML");

        //Tab Styles trong Elements(GUI)
        // Font/ Size/ Color/ Background/...
        driver.findElement(By.id("")).getCssValue("background-color");
        // rgb(46,138,184)
        driver.findElement(By.id("")).getCssValue("");
        driver.findElement(By.id("")).getCssValue("font-size");
        driver.findElement(By.id("")).getCssValue("text-transform");

        // Vi tri cua element so vs do phan giai man hinh
        Point nameTextboxLocation = driver.findElement(By.id("")).getLocation();
        nameTextboxLocation.getX();
        nameTextboxLocation.getY();

        // Chieu cao + rong
        Dimension addressSize = (Dimension) driver.findElement(By.id("")).getSize();

        // Location + Size
        Rectangle nameTextboxRect = driver.findElement(By.id("")).getRect();

        // Location
        Point namePoint = nameTextboxRect.getPoint();

        // Size
        Dimension nameSize = (Dimension) nameTextboxRect.getDimension();
//        nameSize.getHeight();
//        nameSize.getWidth();

        // Shadow Element (JavascriptExecutor)
//        driver.findElement((By.id("")).getShadowRoot();

        // Tu id/ class/ name/ css/ xpath co the truy  ra ngc lai tagname HTML
        driver.findElement(By.cssSelector("#firstname")).getTagName();
        driver.findElement(By.id("firstnane")).getTagName();
        driver.findElement(By.cssSelector("form-instructions")).getTagName();

        // Element A => dau ra cua no la tagname cua elemnent A
        String formLisTag = driver.findElement(By.xpath("//*[@class='form-list']")).getTagName();

        // Dau vao cua Element B se nhan tagname cua element A la tham so
        driver.findElement(By.xpath("" + formLisTag));
        driver.findElement(By.cssSelector("address.copyright")).getText();

        // Chup hinh bi loi va luu duoi dang nao
        // BYTE
        // FILE (luu thanh 1 hinh co kich thuoc o trong o cung: .png/ .jpg/...)
        // BASE64 (Hinh dang text)
        driver.findElement(By.cssSelector("address.copyright")).getScreenshotAs(OutputType.FILE);
        driver.findElement(By.cssSelector("address.copyright")).getScreenshotAs(OutputType.BASE64);
        driver.findElement(By.cssSelector("address.copyright")).getScreenshotAs(OutputType.BYTES);

        // Form (element nao la the form hoac nam trong the form)
        // Hvi giong phim Enter
        // Register/ Login/ Search/...
        driver.findElement(By.id("")).submit();
        

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