package com.task2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage
{
    WebDriver driver;

    @FindBy(xpath = "//div[@class='gs-title']//b[contains(text(),'Google Cloud Pricing Calculator')]")
    WebElement searchResult;

    public ResultsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnSearchResult()
    {
        searchResult.click();

    }
}