package tests.ahmet.US004;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AhmetPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class TC_003 extends TestBaseReport {
    AhmetPage ahmetPage = new AhmetPage();
    Actions actions;
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    //Test Case: Stok fazlası urun eklenememeli ve Update cart ile rakam ortalamaları güncellenmeli
    @Test
    public void test003() throws InterruptedException {
        extentTest = extentReports.createTest("URL", "Web Otomasyon Raporlama");
        //Belirtilen URL' e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("belirtilen URL'e gidildi");

        //Giris yap' a tiklanir
        ahmetPage.anaSayfaSignInLink.click();
        extentTest.info("'Sign in' linkine tıklandı");

        //Gecerli kullanici bilgileri girilir
        ahmetPage.signInUsernameBox.sendKeys("a.palta1314@hotmail.com");
        ahmetPage.signInPasswordBox.sendKeys("Ahmet1314.,");
        extentTest.info("'Geçerli email ve password' girildi");

        //Giris yap' a tiklanir.
        ahmetPage.signInOnayButton.click();
        extentTest.info("'Sign in' linkine tıklandı");

        //My Account sayfasina gidilir
        ahmetPage.signOutLink.click();
        extentTest.info("My Account sayfasına giris yapıldı");

        //Acilan sayfada order bolumune tiklanir
        ahmetPage.ordersLink.click();
        extentTest.info("Acilan sayfada order bolumune tıklandı");

        //Acilan sayfada go shop butonuna tiklanir
        jse.executeScript("arguments[0].scrollIntoView(true);",ahmetPage.goShopButton);
        jse.executeScript("arguments[0].click();", ahmetPage.goShopButton);
        extentTest.info("Acilan sayfada go shop butonuna tıklandı");
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        //Rastgele 5 urun secilir ve sepete eklenir
        for (int i=0 ;i<=4;i++) {
            jse.executeScript("arguments[0].scrollIntoView(true);",ahmetPage.addCart);
            jse.executeScript("arguments[0].click();", ahmetPage.addCart);
            Thread.sleep(2000);
        }
        extentTest.info("Rastgele 5 urun secildi ve sepete eklendi");


        //Cart ' a click yapılır
        jse.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        Thread.sleep(3000);
        ahmetPage.cardLink.click();
        extentTest.info("Cart'a click yapıldı");

        //Burada açılan segmede view cart'a tiklanir.
        ahmetPage.viewCartLink.click();
        Thread.sleep(2000);
        extentTest.info("view cart'tıklandı");

        //Arti butonu ile urun miktari arttirilir
        String ilkdeger1=ahmetPage.productSubtotalAlani.getText();
        ahmetPage.productplusButton.click();
        Thread.sleep(1000);
        extentTest.info("Arti butonuna tiklandi");

        //Update cart'a tiklanir
        jse.executeScript("arguments[0].click();", ahmetPage.updateCartButton);
        Thread.sleep(3000);
        extentTest.info("Update Cart butonuna tiklandi");
        Thread.sleep(1000);
        String sondeger1=ahmetPage.productSubtotalAlani.getText();

        //Update cart ile rakamin guncellendigi test edilir
        Assert.assertTrue(sondeger1.contains(ilkdeger1));

        //Stok fazlasi urunun cart 'a eklenemedigi test edilir
        String ilkdeger2=ahmetPage.productSubtotalAlani2.getText();
        ahmetPage.productQuantityAlani2.clear();
        Thread.sleep(2000);
        ahmetPage.productQuantityAlani2.sendKeys("49");
        Thread.sleep(4000);
        jse.executeScript("arguments[0].click();", ahmetPage.updateCartButton);
        Thread.sleep(3000);
        extentTest.info("Update Cart butonuna tiklandi");

        String sondeger2=ahmetPage.productSubtotalAlani2.getText();


        Assert.assertEquals(sondeger2,ilkdeger2);
        extentTest.pass("Stok fazlasi urunun cart 'a eklenemedigi tespit edildi");

    }

}
