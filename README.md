# AutomationExcercise

Getting Started
===============
- This code currently working with Chrome and Firefox (Gecko driver). 
- Following need to be configured before running this script
  * Install JDK 1.8 and set up with environment variable
  * Set up Maven 3.5 and set up with environment variable
  * Configure Environment variables for JAVA and Maven
  * Add TestNG plugin and cucumber plugins into your Eclipse (Latest)

Resources
=============== 
Gecko Driver and Chrome drivers are placed int he resources folder. so no need to download it from market. 
Testdata.class is used as data source. (further to be enhanced with YAML/ MXL)

Please check whether the Chromedriver & Geckodrivers is compatible

Ways to run the test (Run tests with Eclipse)
====================================================
1. Right click the testng.xml file and run as TestNG
2. right click the Feature file and run as Cucumber feature or run using run configurations and select the class and runner file then run

Run the test from commandline: 
====================================================
1. Comamndline: Open the Project folder in the command line and enter "mvn install"

Further enhancement: 
====================================================
1. Currently TestData.Class is used as test data source. Further implementation to be done using XMl testdata and Test class to parse the xml and put it in the collections for the Tests to be used
2. IE support - Have to include code for launching IE
3. Code optimization -required.

