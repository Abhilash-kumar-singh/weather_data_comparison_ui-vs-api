package com.accuweather.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccuweatherSearchPage {
    public WebDriver driver=null;
    void accuweatherSearchPage(WebDriver driver){
        this.driver=driver;
    }
    @FindBy(className = "search-input")
    WebElement searchField;

    public void enterLocation(String location){
        searchField.sendKeys(location);
    }


}
