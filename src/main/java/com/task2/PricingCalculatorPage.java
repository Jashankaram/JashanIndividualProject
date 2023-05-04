package com.task2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PricingCalculatorPage
{

    WebDriver driver;

    @FindBy(id = "input_96")
    WebElement noOfInstances;

    @FindBy(css = "#select_value_label_91 > span:nth-child(1)")
    WebElement seriesDropDown;

    @FindBy(id = "select_option_212")
    WebElement seriesOption;

    @FindBy(css = "#select_value_label_92 > span:nth-child(1)")
    WebElement machineTypeDropDown;

    @FindBy(css = "#select_option_451 > .md-text")
    WebElement machineTypeOption;

    @FindBy(css = ".ng-scope:nth-child(14) .md-container")
    WebElement sustainedUseDiscountsCheckBox;

    @FindBy(css = ".layout-row:nth-child(15) .md-container")
    WebElement addGPUsCheckBox;

    @FindBy(id = "select_487")
    WebElement gpuTypeDropDown;


    @FindBy(css = "#select_option_494 > .md-text")
    WebElement gpuTypeOption;

    @FindBy(css = "#select_value_label_486 > span:nth-child(1)")
    WebElement noOfGPUsDropDown;

    @FindBy(id = "select_option_497")
    WebElement noOfGPUsOption;

    @FindBy(css = "#select_value_label_445 > span:nth-child(1)")
    WebElement localSSDDropDown;

    @FindBy(css = "#select_option_472 > .md-text")
    WebElement localSSDOption;

    @FindBy(css = "#select_value_label_95 > span:nth-child(1)")
    WebElement committedUsageDropDown;

    @FindBy(id = "select_option_134")
    WebElement committedUsageOption;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[@type='button'][normalize-space()='Add to Estimate']")
    WebElement addToEstimateButton;

    public PricingCalculatorPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setNoOfInstances() throws InterruptedException
    {
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);

        noOfInstances.click();
        Thread.sleep(2000);
        noOfInstances.sendKeys("4");
        Thread.sleep(2000);
    }
    public void setSeries() throws InterruptedException
    {
        seriesDropDown.click();
        Thread.sleep(2000);
        seriesOption.click();
        Thread.sleep(2000);
    }
    public void setMachineTypes() throws InterruptedException
    {
        machineTypeDropDown.click();
        Thread.sleep(2000);
        machineTypeOption.click();
        Thread.sleep(2000);
    }
    public void setSustainedUseDiscounts() throws InterruptedException
    {
        sustainedUseDiscountsCheckBox.click();
        Thread.sleep(2000);
    }
    public void setAddGPUs() throws InterruptedException
    {
        addGPUsCheckBox.click();
        Thread.sleep(2000);
    }
    public void setGpuType() throws InterruptedException
    {
        gpuTypeDropDown.click();
        Thread.sleep(2000);
        gpuTypeOption.click();
        Thread.sleep(2000);

    }
    public void setNoOfGPUs() throws InterruptedException
    {
        noOfGPUsDropDown.click();
        Thread.sleep(2000);
        noOfGPUsOption.click();
        Thread.sleep(2000);

    }
    public void setLocalSSD() throws InterruptedException
    {
        localSSDDropDown.click();
        Thread.sleep(2000);
        localSSDOption.click();
        Thread.sleep(2000);
    }
    public void setCommittedUsage() throws InterruptedException
    {
        committedUsageDropDown.click();
        Thread.sleep(2000);
        committedUsageOption.click();
        Thread.sleep(2000);
    }
    public void setAddToEstimate() throws InterruptedException
    {
        addToEstimateButton.click();
        Thread.sleep(2000);
    }
    public void takeScreenshot(WebDriver driver) throws IOException
    {

        TakesScreenshot screenshot = (TakesScreenshot) driver;

        File source = screenshot.getScreenshotAs(OutputType.FILE);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String fileName = "screenshot" + dateFormat.format(new Date()) + ".png";
        File destination = new File("Desktop" + fileName);
        FileUtils.copyFile(source, destination);
        System.out.println("Screenshot taken and saved to: " + source + "  --->  "+ destination);
    }

}