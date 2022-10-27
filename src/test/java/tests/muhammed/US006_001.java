package tests.muhammed;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.muhammedPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

import java.time.Duration;

public class US006_001 extends TestBaseReport {

    muhammedPage muhammedPage =new muhammedPage();

    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));


    @Test
    public void test006_01() {

        extentTest = extentReports.createTest("Urun listesi testi", "urun listelerimi gormeliyim");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("Siteye gidildi");

        actions.sendKeys(Keys.END).perform();
        jse.executeScript("arguments[0].scrollIntoView(true);", muhammedPage.MyCount);
        jse.executeScript("arguments[0].click();", muhammedPage.MyCount);
        // muhammedObject.MyCount.click();
        extentTest.info("My account butonuna tiklandi");

        muhammedPage.UsernameORemailAddress.sendKeys(ConfigReader.getProperty("validKullaniciAdiMUhammed"));
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("validSifreMuhammed")).perform();
        extentTest.info("Gecerli kullanici adi  ve sifre girildi");

        jse.executeScript("arguments[0].scrollIntoView(true);", muhammedPage.signinButton);
        jse.executeScript("arguments[0].click();", muhammedPage.signinButton);
        extentTest.info("Sign in butonuna tiklandi");

        // muhammedObject.signinButton.click();
        //muhammedObject.storeManagerLink.click();
        jse.executeScript("arguments[0].scrollIntoView(true);", muhammedPage.storeManagerLink);
        jse.executeScript("arguments[0].click();", muhammedPage.storeManagerLink);

        jse.executeScript("arguments[0].scrollIntoView(true);", muhammedPage.productLink);
        jse.executeScript("arguments[0].click();", muhammedPage.productLink);
        extentTest.info("Product sekmesine giris yapildi");

       // muhammedPage.editLink.click();
        jse.executeScript("arguments[0].scrollIntoView(true);", muhammedPage.editLink);
        jse.executeScript("arguments[0].click();", muhammedPage.editLink);
        extentTest.info("Edit butonuna tiklama yapildi");

        //muhammedPage.addNewCatagoryButton.click();
        jse.executeScript("arguments[0].scrollIntoView(true);", muhammedPage.addNewCatagoryButton);
        jse.executeScript("arguments[0].click();", muhammedPage.addNewCatagoryButton);
        extentTest.info("Add new butonuna tiklama yapildi");

        muhammedPage.categoryNameBox.sendKeys("Besin Takviyesi");

       // muhammedPage.addButton.click();
        jse.executeScript("arguments[0].scrollIntoView(true);", muhammedPage.addButton);
        jse.executeScript("arguments[0].click();", muhammedPage.addButton);

        wait.until(ExpectedConditions.alertIsPresent());

        Driver.getDriver().switchTo().alert().accept();
        // muhammedPage.besinTakviyesiClickButton.click();
        jse.executeScript("arguments[0].scrollIntoView(true);", muhammedPage.besinTakviyesiClickButton);
        jse.executeScript("arguments[0].click();", muhammedPage.besinTakviyesiClickButton);
        Assert.assertTrue(muhammedPage.besinTakviyesiClickButton.isSelected());




    }
}
