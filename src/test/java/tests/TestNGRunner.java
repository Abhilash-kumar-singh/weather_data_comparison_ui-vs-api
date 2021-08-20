package tests;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;
import reportgenerator.addDataToFile;

public class TestNGRunner {

    public static void main(String [] args){
        TestNG objTNG=new TestNG();
        List<String> suites=new ArrayList<String>();
        suites.add("/Users/abhilashsingh/IdeaProjects/weatherComparisonTest/uitestng.xml");
        suites.add("/Users/abhilashsingh/IdeaProjects/weatherComparisonTest/apitestng.xml");
        suites.add("/Users/abhilashsingh/IdeaProjects/weatherComparisonTest/testng.xml");
        objTNG.setTestSuites(suites);

        for(int i=0;i<5;i++){

            String data="\n\n\nComplete test sequence- "+i+"\n==========";
            new addDataToFile().dataBuilder("test1.txt",data);

            objTNG.run();

            data="\n==========";
            new addDataToFile().dataBuilder("test1.txt",data);


        }
    }
}
