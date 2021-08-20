package tests;

import java.lang.Math;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import reportgenerator.addDataToFile;

public class CompareweatherParameters {
    String testData="";
    @Test
    public void compare(){
        if(new AccuweatherPageTest().ifTestPassed && new OpenweatherAPIPageTest().ifTestPassed){
            float uiTempData=new AccuweatherPageTest().uiTemp;
            float apiTempData=new OpenweatherAPIPageTest().apiTemp;
            float v = (float) 273.15;
            float apiCelcius=apiTempData -v;
            if(Math.abs(apiCelcius-uiTempData)<1){
                testData="PASS";
                Assert.assertTrue(true);
            }else{
                testData="FAIL";
                Assert.assertFalse(true);
            }
        }else{
            testData="FAIL";
            Assert.assertFalse(true);

        }
    }

    @AfterMethod
    public void tearDown(){
        testData="\n\nCOMPARISON TEST SUITE\n----------\n"+"Test status- "+testData;
        new addDataToFile().dataBuilder("test1.txt",testData);
    }



}
