# weather_data_comparison_ui-vs-api
How to run?
Step 1: clean install of POM.xml
Step 2: In tests package, find a file named "TestNGRunner.java" and execute it's main method. It will automatically run subtestfiles(3 testfiles)

Dependencies used?
1.TestNG
2.Selenium
3.Rest assured
4.Webdriver manager

Features?
1.Cross browser testing intially handled for chrome and firefox
2. Test created to check if data is getting fetch from ui and api, and comparing data for certain bracket
3. Currently handles only temperature.
4. Simple execution to run test using Testngrunner
5. Modularised
6. POM with pagefactory and cachelookup
7. DataDriven test currently for 5 data
