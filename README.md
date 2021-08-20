# weather_data_comparison_ui-vs-api
How to run?<br/>
Step 1: clean install of POM.xml<br/>
Step 2: In tests package, find a file named "TestNGRunner.java" and execute it's main method. It will automatically run subtestfiles(3 testfiles)<br/>

Note: ignore target directory <br/>

Dependencies used?<br/>
1.TestNG<br/>
2.Selenium<br/>
3.Rest assured<br/>
4.Webdriver manage<br/>

Features?<br/>
1.Cross browser testing intially handled for chrome and firefox<br/>
2. Test created to check if data is getting fetch from ui and api, and comparing data for certain bracket<br/>
3. Currently handles only temperature.<br/>
4. Simple execution to run test using Testngrunner<br/>
5. Modularised<br/>
6. POM with pagefactory and cachelookup<br/>
7. DataDriven test currently for 5 data<br/>
8. Manual test report creation
