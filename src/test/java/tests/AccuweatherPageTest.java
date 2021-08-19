package tests;


import com.accuweather.pages.AccuweatherSearchPage;
import com.accuweather.pages.InformationPage;
import com.accuweatherui.utility.AdHandlingPage;
import dataprovider.DataStore;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class AccuweatherPageTest {
    WebDriver driver=null;
    AccuweatherSearchPage searchPage=null;
    InformationPage infoPage=null;
    static int dataCounterUi=0;
    public static float uiTemp=0;
    Object [][] data=new DataStore().dataprovider;

    @BeforeMethod
    public void PageInitialisation(){

        driver=new BrowserFactory().startBrowser("chrome","https://www.accuweather.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        searchPage= new AccuweatherSearchPage(driver);
        infoPage= new InformationPage(driver);
    }
    @Test
    public void fetchAccuweatherData(){
        String city= (String) data[dataCounterUi][0];
        searchPage.enterLocation(city);

        new AdHandlingPage(driver).ifAdLocated("google_ads_iframe_/6581/web/in/interstitial/admin/search_0");
        System.out.println(infoPage.getTemperatureDetails().split("°")[0]);
        uiTemp=Float.parseFloat(infoPage.getTemperatureDetails().split("°")[0]);
        infoPage.clickMoreDetailsButton();

        new AdHandlingPage(driver).ifAdLocated("google_ads_iframe_/6581/web/in/interstitial/weather/local_home_0");

        System.out.println(infoPage.getTemperatureDetails());

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
        dataCounterUi+=1;
    }
}
