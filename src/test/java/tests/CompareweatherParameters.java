package tests;

import org.testng.annotations.Test;

public class CompareweatherParameters {
    @Test
    public void compare(){
        float uiTempData=new AccuweatherPageTest().uiTemp;
        float apiTempData=new OpenweatherAPIPageTest().apiTemp;
        float uiFaren=(float)((uiTempData*9)/5)+32;
        System.out.println(uiFaren);
        System.out.println(apiTempData);
    }
}
