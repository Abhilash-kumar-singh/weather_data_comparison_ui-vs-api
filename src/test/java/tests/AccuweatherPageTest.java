package tests;


import com.accuweather.pages.AccuweatherSearchPage;
import com.accuweather.pages.InformationPage;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import dataprovider.DataStore;

public class AccuweatherPageTest {
    WebDriver driver=null;
    AccuweatherSearchPage searchPage=null;
    InformationPage infoPage=null;
    @BeforeMethod
    public void PageInitialisation(){
        driver=new BrowserFactory().startBrowser("chrome","https://www.accuweather.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        searchPage= new AccuweatherSearchPage(driver);
        infoPage= new InformationPage(driver);
    }
    @Test
    public void fetchAccuweatherData(){
        searchPage.enterLocation("delhi");
        searchPage.closeAd();
        infoPage.clickMoreDetailsButton();
        System.out.println(infoPage.getWindDetails());
        System.out.println(infoPage.getHumidityDetails());
    }


}
