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
import org.testng.annotations.DataProvider;

public class AccuweatherPageTest {
    WebDriver driver=null;
    AccuweatherSearchPage searchPage=null;
    InformationPage infoPage=null;
    @DataProvider (name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {{"hyderabad",200}, {"delhi",200},{"lucknow",200},{"new york",200},{"bangalore",200}};
    }
    @BeforeMethod
    public void PageInitialisation(){
        driver=new BrowserFactory().startBrowser("chrome","https://www.accuweather.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        searchPage= new AccuweatherSearchPage(driver);
        infoPage= new InformationPage(driver);
    }
    @Test(dataProvider = "data-provider")
    public void fetchAccuweatherData(String city, int statusCode){
        searchPage.enterLocation(city);
        searchPage.ifAdLocated("google_ads_iframe_/6581/web/in/interstitial/admin/search_0");
        infoPage.clickMoreDetailsButton();
        infoPage.ifAdLocated("google_ads_iframe_/6581/web/in/interstitial/weather/local_home_0");
        System.out.println(infoPage.getWindDetails());
        System.out.println(infoPage.getHumidityDetails());

    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }


}
