package tests;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class TestNGRunner {
    static int testCount=0;
    public static void main(String [] args){
        TestNG objTNG=new TestNG();
        List<String> suites=new ArrayList<String>();
        suites.add("/Users/abhilashsingh/IdeaProjects/weatherComparisonTest/uitestng.xml");
        suites.add("/Users/abhilashsingh/IdeaProjects/weatherComparisonTest/apitestng.xml");
        suites.add("/Users/abhilashsingh/IdeaProjects/weatherComparisonTest/testng.xml");
        objTNG.setTestSuites(suites);
        objTNG.run();

        for(int i=0;i<5;i++){
            objTNG.run();
            testCount=i;
        }



    }
}
