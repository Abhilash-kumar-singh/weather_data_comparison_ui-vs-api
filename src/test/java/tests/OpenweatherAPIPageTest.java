package tests;

import com.openweatherapi.utility.ApiKey;
import com.openweatherapi.utility.StringToList;
import dataprovider.DataStore;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import org.hamcrest.Matchers.*;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import reportgenerator.addDataToFile;


public class OpenweatherAPIPageTest {
    static int dataCounterApi= 0;
    Object [][] data=new DataStore().dataprovider;
    public static float apiTemp=0;
    public static boolean ifTestPassed=true;

    @Test
    public void checkStatusCode(){
        String city= (String) data[dataCounterApi][0];
        System.out.println(city);
        int expectedStatusCode=(int) data[dataCounterApi][1];

        RestAssured.baseURI = "https://api.openweathermap.org/data/2.5/weather";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("?q="+city+"&appid="+(new ApiKey().apikey));
        int statusCode = response.getStatusCode();
        if(statusCode==200){
            ifTestPassed=true;
        }else{
            ifTestPassed=false;
        }
        JsonPath extractor=response.jsonPath();
        System.out.println((String)extractor.get("main").toString());
        String temperature=new StringToList().converter(extractor.get("main").toString())[0];
        apiTemp=Float.parseFloat(temperature.split("=")[1]);


        Assert.assertEquals(statusCode /*actual value*/,  expectedStatusCode/*expected value*/, "Correct status code returned");
    }
    @AfterMethod
    public void tearDown(){
        dataCounterApi+=1;
        String testData="\n\nAPI TEST SUITE\n----------\n"+"Test subject- "+(String) data[dataCounterApi][0]+"\n"+ "Test status- "+ifTestPassed+"\nTemperature- "+(apiTemp-273.15);
        new addDataToFile().dataBuilder("test1.txt",testData);
    }
}
