package com.accuweather.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InformationPage {
    public WebDriver driver=null;
    public InformationPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "cur-con-weather-card__cta")
            @CacheLookup
    WebElement moreDetails;
    @FindBy(xpath = "/html/body/div/div[5]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[2]")
            @CacheLookup
    WebElement wind;
    @FindBy(xpath = "/html/body/div/div[5]/div[1]/div[1]/div[2]/div[4]/div[1]/div[3]/div[2]")
            @CacheLookup
    WebElement humidity;
    @FindBy(css = ".cur-con-weather-card__body .temp")
            @CacheLookup
    WebElement temperature;
    @FindBy(id = "dismiss-button")
    WebElement adCloseButton;


    public void clickMoreDetailsButton(){
        moreDetails.click();
    }
    public String getWindDetails(){
        return wind.getText();
    }
    public String getHumidityDetails(){
        return humidity.getText();
    }
    public String getTemperatureDetails(){
        return temperature.getText();
    }

}
