package com.accuweather.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class AccuweatherSearchPage {
    public WebDriver driver;
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

    @FindBy(className = "no-results-text")
    WebElement errorMessage;

    public void enterLocation(String location){
        searchField.sendKeys(location+ Keys.RETURN);

    }

    public void selectFirstLocation(){
        try {
            firstElement.click();
        }catch(NoSuchElementException e){

        }
    }
    public Boolean validateSearch(){
        try{
            System.out.println(errorMessage.isDisplayed());
        }catch(NoSuchElementException e){
            return true;
        }
        return false;

    }



}
