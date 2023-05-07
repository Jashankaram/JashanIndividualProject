package com.task2;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GoogleCloudTest
{


    WebDriver driver;
    FrontPage frontPage;
    ResultsPage resultsPage;
    RateCalculatorPage rateCalculatorPage;
    @Test(groups = {"functional","smoke"}, priority = 1)
    //@BeforeClass
    public void environmentTest()
    {
        driver = Factorybrowser1.setupBrowser("chrome","https://cloud.google.com/");
        frontPage = PageFactory.initElements(driver, FrontPage.class);
        resultsPage = PageFactory.initElements(driver, ResultsPage.class);
        rateCalculatorPage = PageFactory.initElements(driver, RateCalculatorPage.class);
    }

    @Test(groups = {"functional","smoke"}, priority = 2)
    public void homePageTest() throws InterruptedException
    {
        frontPage.searchFor("Google Cloud Platform Pricing Calculator");
    }
    @Test(groups = {"functional","smoke"}, priority = 3)
    void clickOnSearchResult() throws InterruptedException
    {
        resultsPage.clickOnSearchResult();
        Thread.sleep(6000);
    }
    @Test(groups = {"smoke"}, priority = 4)
    void noOfInstance() throws InterruptedException
    {
        rateCalculatorPage.setNoOfInstances();
    }
    @Test(groups = {"smoke"}, priority = 5)
    void setSeries() throws InterruptedException
    {
        rateCalculatorPage.setSeries();
    }
    @Test(groups = {"smoke"}, priority = 6)
    void setMachineTypes() throws InterruptedException
    {
        rateCalculatorPage.setMachineTypes();
    }
    @Test(groups = {"smoke"}, priority = 7)
    void setSustainedUseDiscounts() throws InterruptedException
    {
        rateCalculatorPage.setSustainedUseDiscounts();
    }
    @Test(groups = {"smoke"}, priority = 8)
    void setAddGPUs() throws InterruptedException
    {
        rateCalculatorPage.setAddGPUs();
    }
    @Test(groups = {"smoke"}, priority = 9)
    void setGpuType() throws InterruptedException
    {
        rateCalculatorPage.setGpuType();
    }
    @Test(groups = {"smoke"}, priority = 10)
    void setNoOfGPUs() throws InterruptedException
    {
        rateCalculatorPage.setNoOfGPUs();
    }
    @Test(groups = {"smoke"}, priority = 11)
    void setLocalSSD() throws InterruptedException
    {
        rateCalculatorPage.setLocalSSD();
    }
    @Test(groups = {"smoke"}, priority = 12)
    void setCommittedUsage() throws InterruptedException
    {
        rateCalculatorPage.setCommittedUsage();
    }
    @Test(groups = {"smoke"}, priority = 13)
    void setAddToEstimate() throws InterruptedException
    {
        rateCalculatorPage.setAddToEstimate();
    }
    //@AfterClass
    @Test(groups = {"smoke"}, priority = 14)
    void closeDriver()
    {
        frontPage.closeDrive();
    }

    @AfterMethod(groups = {"smoke"})
    void takeScreenshotOnFailure(ITestResult result)
    {
        if (result.getStatus() == ITestResult.FAILURE)
        {

            TakesScreenshot screenshot = (TakesScreenshot) driver;

            File source = screenshot.getScreenshotAs(OutputType.FILE);
            try
            {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
                String fileName = "screenshot" + dateFormat.format(new Date()) + ".png";
                File destination = new File("Desktop" + fileName);
                FileUtils.copyFile(source, destination);
                System.out.println("Screenshot taken and saved to: " + source + "  --->  "+ destination);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}