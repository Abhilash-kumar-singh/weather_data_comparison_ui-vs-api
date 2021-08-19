package tests;

import com.openweatherapi.utility.ApiKey;
import com.openweatherapi.utility.StringToList;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import org.hamcrest.Matchers.*;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;


public class OpenweatherAPIPageTest {
    @DataProvider (name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {{"hyderabad",200}, {"delhi",200},{"hgdjh",200},{"bangalore",200}};
    }
    @Test(dataProvider = "data-provider")
    public void checkStatusCode(String city, int expectedStatusCode){
        //String city="hyderabad";
        RestAssured.baseURI = "https://api.openweathermap.org/data/2.5/weather";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("?q="+city+"&appid="+(new ApiKey().apikey));
        int statusCode = response.getStatusCode();
        JsonPath extractor=response.jsonPath();
        System.out.println((String)extractor.get("main").toString());
        System.out.println(new StringToList().converter(extractor.get("main").toString())[0]);
        Assert.assertEquals(statusCode /*actual value*/,  expectedStatusCode/*expected value*/, "Correct status code returned");
    }
}
