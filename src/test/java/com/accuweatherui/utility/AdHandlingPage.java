package com.accuweatherui.utility;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class AdHandlingPage {
    WebDriver driver=null;
    public AdHandlingPage(WebDriver driver){
        this.driver=driver;
    }
    @FindBy(id = "dismiss-button")
    WebElement adCloseButton;
    public void ifAdLocated(String frame){
        try {
            driver.switchTo().frame(frame);

            if (driver.findElement(By.id("dismiss-button")).isDisplayed()) {
                //adCloseButton.click();
                driver.findElement(By.id("dismiss-button")).click();
            }
        }
        catch(NoSuchElementException e){

        }
        catch(NoSuchFrameException e){

        }finally {
            driver.switchTo().parentFrame();
        }

    }
}
