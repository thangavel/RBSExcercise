# AutomationExcercise

Getting Started
===============
This test has been written to work with Chrome and firefox browsers, 
Install JDK 1.8 and set up with environment variable 
Set up Maven 3.5 and set up with environment variable
Test NG and Junit combinely used.

Resources: 
I have already kept Chrome and Geckodrivers u can use it for execution. I have added resources in the git repository as well. 

Please check whether the Chromedriver is compatible with your Chrome browser is in path ${project.base.dir}\src\test\resources\

Ways to run the test (Run tests with Eclipse)
====================================================
1. Right click the testng.xml file and run as TestNG
2. right click the Feature file and run as Cucumber feature or run using run configurations and select the class and runner file then run

Run the test from commandline: 
====================================================
1. Comamndline: Open the Project folder in the command line and enter "mvn install"

Run the test from commandline: 
====================================================
1. Currently TestData.Class is used as test data source. Further implementation to be done using XMl testdata and Test class to parse the xml and put it in the collections for the Tests to be used
2. IE support - Have to include code for launching IE
3. Code optimization -required.
