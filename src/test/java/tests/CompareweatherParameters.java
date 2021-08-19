package tests;

import org.testng.annotations.Test;

public class CompareweatherParameters {
    @Test
    public void compare(){
        float uiTempData=new AccuweatherPageTest().uiTemp;
        float apiTempData=new OpenweatherAPIPageTest().apiTemp;
        float v = (float) 273.15;
        float apiCelcius=apiTempData -v;
        System.out.println(uiTempData);
        System.out.println(apiCelcius);
    }
}
