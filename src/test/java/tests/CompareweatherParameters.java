package tests;

import java.lang.Math;
import org.testng.annotations.Test;
import org.testng.Assert;

public class CompareweatherParameters {
    @Test
    public void compare(){
        float uiTempData=new AccuweatherPageTest().uiTemp;
        float apiTempData=new OpenweatherAPIPageTest().apiTemp;
        float v = (float) 273.15;
        float apiCelcius=apiTempData -v;
        if(Math.abs(apiCelcius-uiTempData)>1){
            Assert.assertTrue(true);
        }else{
            Assert.assertFalse(true);
        }
    }
}
