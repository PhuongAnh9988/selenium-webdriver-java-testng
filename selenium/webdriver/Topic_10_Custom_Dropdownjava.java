package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_10_Custom_Dropdownjava {
    WebDriver driver;

    // Trang thai cu the element: Visible/ Invisible/ Presence/ Number/ Clickable...
    WebDriverWait expliciWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        expliciWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Ko ro rang cho 1 trang thai cu the nao cua element
        // Cho viec tim element - findElement(s)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_JQuery() {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        selectItemInDropdown("span#speed-button", "ul#speed-menu div", "Faster");
        sleepInSeconds(3);

        selectItemInDropdown("span#files-button", "ul#files-menu div", "ui.jQuery.js");
        sleepInSeconds(3);

        selectItemInDropdown("span#number-button", "ul#number-menu div", "10");
        sleepInSeconds(3);

        selectItemInDropdown("span#salutation-button", "ul#salutation-menu div", "Dr");
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(), "Faster");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#files-button>span.ui-selectmenu-text")).getText(), "ui.jQuery.js");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(), "10");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(), "Dr");


//        // 1 click vao 1 the de hien thi het cac item ben trong dropdown
//        driver.findElement(By.cssSelector("span#number-button")).click();
//        sleepInSeconds(5);
//
//        // 2.1 Hien thi ra het tat ca cac item
//        // 2.2 Chi hien thi 1 phan va dang load them
//        // Cho cho hien thi ra het tat ca cac item trong dropdown
//
//        // Co case item k visible het tat ca (Angular/ React/...)
//        expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#number-menu div")));
//
//        // allItems dang luu tru 19 item ben trong
//        // 19 WebElement
//        List<WebElement> allItems = driver.findElements(By.cssSelector("ul#number-menu div"));
//        for (WebElement item : allItems) {
//            // Neu trg hop element click chon xog roi cac item con lai se k con trog HTML nua thi ham getText se bi fail
//            String textItem = item.getText();
//            System.out.println("Text item = " + textItem);
//
//            // String
//            if (textItem.equals("8")) {
//                item.click();
//                break; // Thoat vong lap (for/ while/ do-while/ switch-case)
//            }
//
//        }
//        // 3.1 Neu nhu item can chon hien thi thi click vao
//        // 3.2 Neu nhu item can chon nam ben duoi thi 1 so trg hop can scroll xg de hien thi len roi moi chon (Angular/ React...)
//        // 4 Trc khi click can kiem tra neu nhu text cua item can chon thi click vao

    }

    @Test
    public void TC_02_React() {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

        selectItemInDropdown("i.dropdown.icon", "div.item>span.text", "Christian");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Christian");
        sleepInSeconds(3);

        selectItemInDropdown("i.dropdown.icon", "div.item>span.text", "Jenny Hess");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Jenny Hess");
        sleepInSeconds(3);

        selectItemInDropdown("i.dropdown.icon", "div.item>span.text", "Justen Kitsune");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Justen Kitsune");
        sleepInSeconds(3);
    }
    @Test
    public void TC_03_VesJS() {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");

        selectItemInDropdown("li.dropdown-toggle", "ul.dropdown-menu a", "Second Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Second Option");
        sleepInSeconds(3);

        selectItemInDropdown("li.dropdown-toggle", "ul.dropdown-menu a", "First Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "First Option");
        sleepInSeconds(3);

        selectItemInDropdown("li.dropdown-toggle", "ul.dropdown-menu a", "Third Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Third Option");
        sleepInSeconds(3);

    }

    @Test
    public void TC_04_Editable() {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");

         selectItemInEditableDropdown("input.search", "div.item span", "Algeria");
         Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Algeria");
         sleepInSeconds(3);

    }

    @Test
    public void TC_05_NopCommerce() {
        driver.get("https://demo.nopcommerce.com/register");

        selectItemInDropdown("select[name='DateOfBirthDay']", "select[name='DateOfBirthDay']>option", "18");
        Assert.assertTrue(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']>option[value='18']")).isSelected());
        sleepInSeconds(3);

        selectItemInDropdown("select[name='DateOfBirthMonth']", "select[name='DateOfBirthMonth']>option", "September");
        Assert.assertTrue(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']>option[value='9']")).isSelected());
        sleepInSeconds(3);

        selectItemInDropdown("select[name='DateOfBirthYear']", "select[name='DateOfBirthYear']>option", "1995");
        Assert.assertTrue(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']>option[value='1995']")).isSelected());
        sleepInSeconds(3);


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

    // Nhung du lieu dung de truyen vao se xem la tham so

    public void selectItemInDropdown(String parentCss, String childItemCss, String itemTextExpected) {
        driver.findElement(By.cssSelector(parentCss)).click();
        expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childItemCss)));
        List<WebElement> allItems = driver.findElements(By.cssSelector(childItemCss));
        for (WebElement item : allItems) {
            if (item.getText().equals(itemTextExpected)) {
                item.click();
                break;
            }
        }
    }

    public void selectItemInEditableDropdown(String parentCss, String childItemCss, String itemTextExpected) {
        driver.findElement(By.cssSelector(parentCss)).clear();
        driver.findElement(By.cssSelector(parentCss)).sendKeys(itemTextExpected);
        sleepInSeconds(1);

        List<WebElement> allItems = expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childItemCss)));
        for (WebElement item : allItems) {
            if (item.getText().equals(itemTextExpected)) {
                item.click();
                break;
            }
        }
    }
}