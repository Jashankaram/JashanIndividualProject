package com.task1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PasteBinTest {

    WebDriver driver;
    PastebinPage pastebinPage;

    @BeforeClass
    void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pastebin.com/");
        pastebinPage = new PastebinPage(driver);
    }

    @Test(priority = 1)
    void newPaste() throws InterruptedException {
        pastebinPage.enterPasteText("Hello from WebDriver");
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    void pasteExpiration() throws InterruptedException {
        pastebinPage.selectPasteExpiration();
        Thread.sleep(3000);
    }

    @Test(priority = 3)
    void pasteName() throws InterruptedException {

        pastebinPage.enterPasteName("helloweb");
        Thread.sleep(3000);
    }

    @Test(priority = 4)
    void createNewPaste() throws InterruptedException {
        pastebinPage.clickCreateNewPasteButton();
        Thread.sleep(3000);
    }

    @AfterClass
    void closeDriver() {
        driver.close();
    }
}
