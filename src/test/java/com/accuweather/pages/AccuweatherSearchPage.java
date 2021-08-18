package com.accuweather.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AccuweatherSearchPage {
    public WebDriver driver=null;
    public AccuweatherSearchPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "search-input")
    WebElement searchField;

    @FindBy(xpath = "/html/body/div/div[4]/div[1]/div[1]/div[2]/a[1]")
    WebElement firstElement;

    @FindBy(id="dismiss-button")
    WebElement adCloseButton;

    public void enterLocation(String location){
        searchField.sendKeys(location+ Keys.RETURN);
        firstElement.click();

    }

    public void closeAd(){
        driver.switchTo().frame("google_ads_iframe_/6581/web/in/interstitial/admin/search_0");
        adCloseButton.click();
    }



}
