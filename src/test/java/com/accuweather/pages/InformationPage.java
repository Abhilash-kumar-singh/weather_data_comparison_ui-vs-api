package com.accuweather.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InformationPage {
    public WebDriver driver=null;
    public InformationPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "cur-con-weather-card__cta")
    WebElement moreDetails;
    @FindBy(xpath = "/html/body/div/div[5]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[2]")
    WebElement wind;
    @FindBy(xpath = "/html/body/div/div[5]/div[1]/div[1]/div[2]/div[4]/div[1]/div[3]/div[2]")
    WebElement humidity;

    public void clickMoreDetailsButton(){
        moreDetails.click();
    }
    public String getWindDetails(){
        return wind.getText();
    }
    public String getHumidityDetails(){
        return humidity.getText();
    }

}
