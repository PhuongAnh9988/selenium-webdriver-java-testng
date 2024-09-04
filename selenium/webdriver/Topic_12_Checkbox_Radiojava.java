package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_12_Checkbox_Radiojava {
    WebDriver driver;
    WebDriverWait expliciWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        expliciWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Default_Telerik_Checkbox() {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");

        By rearSideCheckbox = By.xpath("//label[text()='Rear side airbags']/preceding-sibling::span/input");
        By dualZoneCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");

        // Chon 2 checkbox nay
        // Case 1 neu nhu app nay mo ra ma checkbox da dc chon
        checkToElement(rearSideCheckbox);

        // Case 2 neu nhu app nay mo ra ma checkbox chua dc chon
        checkToElement(dualZoneCheckbox);

        // Verify checkbox da dc chon thanh cong
        Assert.assertTrue(driver.findElement(rearSideCheckbox).isSelected());
        Assert.assertTrue(driver.findElement(dualZoneCheckbox).isSelected());

        // Bo chon 2 checkbox nay
        uncheckToElement(rearSideCheckbox);
        uncheckToElement(dualZoneCheckbox);

        // Verify checkbox da dc bo chon thanh cong
        Assert.assertFalse(driver.findElement(rearSideCheckbox).isSelected());
        Assert.assertFalse(driver.findElement(dualZoneCheckbox).isSelected());

    }

    @Test
    public void TC_02_Defaul_Telerik_Radio() {
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");

        By twoPetrolRadio = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input");
        By twoDieselRadio = By.xpath("//label[text()='2.0 Diesel, 103kW']/preceding-sibling::span/input");

        // Click chon 1 trong 2
        checkToElement(twoPetrolRadio);

        // Verify
        Assert.assertTrue(driver.findElement(twoPetrolRadio).isSelected());
        Assert.assertFalse(driver.findElement(twoDieselRadio).isSelected());

        checkToElement(twoDieselRadio);

        // Verify
        Assert.assertFalse(driver.findElement(twoPetrolRadio).isSelected());
        Assert.assertTrue(driver.findElement(twoDieselRadio).isSelected());

    }

    @Test
    public void TC_03_Select_All_Checkbox() {
        driver.get("https://automationfc.github.io/multiple-fields/");

        List<WebElement> allCheckboxes = driver.findElements(By.cssSelector("div.form-single-colum input.form-checkbox"));

        // Chon het tat ca cac checkbox trong man hinh do
        for (WebElement checkbox : allCheckboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
                sleepInSeconds(1);
            }
        }

        // Veify het tat ca cac checkbox
        for (WebElement checkbox : allCheckboxes) {
            Assert.assertTrue(checkbox.isSelected());
        }

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        allCheckboxes = driver.findElements(By.cssSelector("div.form-single-colum input[type='checkbox']"));

        // Chon 1 checkbox/radio nao do trong tat ca cac checkbox/radio
        for (WebElement checkbox: allCheckboxes) {
            if (checkbox.getAttribute("value").equals("Heart Attack") && !checkbox.isSelected()); {
                checkbox.click();
                sleepInSeconds(3);
            }
        }

        // Verify het tat ca cac checkbox
        for (WebElement checkbox : allCheckboxes) {
            if (checkbox.getAttribute("value").equals("Heart Attack")) {
                Assert.assertTrue(checkbox.isSelected());
            } else {
                Assert.assertFalse(checkbox.isSelected());
            }
        }

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
    public void checkToElement(By byXpath) {
        // Neu nhu element chua dc chon thi moi click
        if (!driver.findElement(byXpath).isSelected()) {
            driver.findElement(byXpath).click();
            sleepInSeconds(2);
        }
    }

    public void uncheckToElement(By byXpath) {
        // Neu nhu element dc chon roi thi click lan nua thanh bo chon
        if (driver.findElement(byXpath).isSelected()) {
            driver.findElement(byXpath).click();
            sleepInSeconds(2);
        }
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}