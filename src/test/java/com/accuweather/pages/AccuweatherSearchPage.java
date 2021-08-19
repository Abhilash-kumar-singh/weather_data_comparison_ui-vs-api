package com.accuweather.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


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
        try {
            firstElement.click();
        }catch(NoSuchElementException e){

        }
    }
    public void ifAdLocated(String frame){
        try {
            driver.switchTo().frame(frame);
            System.out.println(driver.findElement(By.id("dismiss-button")).isDisplayed());
            if (driver.findElement(By.id("dismiss-button")).isDisplayed()) {
                adCloseButton.click();
            }
        }
        catch(NoSuchElementException e){
            System.out.println("hello");
        }
        catch(NoSuchFrameException e){

        }finally {
            driver.switchTo().parentFrame();
        }
        System.out.println("hello");
    }

    public void closeAd(){
        driver.switchTo().frame("google_ads_iframe_/6581/web/in/interstitial/admin/search_0");
        adCloseButton.click();

    }



}
