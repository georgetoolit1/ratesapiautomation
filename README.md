# REST ASSURED API Automation

This is a simple maven project that automates REST API Testing using REST Assured, cucumber BDD and TestNG

## Features
* Clear maven folder structures
* CucumberOptions with detailed explanation of using "tags", "glue"
* TestNG Annotations/hooks like  "AfterSuite" 
* Descriptive pom.xml and testng.xml
* Logger to log information in the testrun.log and on the console 

#### Pre-requisites
1. Java installed in the system
2. Maven installed in the system


#### Run Scripts
* Fork this repo, keep the folder the structure intact
* Run the following maven command from command line 

```
mvn clean test
```
* Run the following command to run a specific cucumber tag i.e @smoke from the command line
```
 mvn test -Dcucumber.filter.tags="@smoke"
```

* The scripts should run successfully.
* Target folder should be created with cucumber-html-report and surefire-reports.
* **Test_Output** folder should be created with the default testng reports

```
 @CucumberOptions(
      	strict = true,
      	monochrome = true,
      	features = {"src/test/resources/features/"},
      	glue = "com.bank.stepdefinitions",
      	plugin = {"pretty", "html:target/cucumber-html-report" },
      	tags={"@smoke"}
        )
```

#### HTML Reports
Default cucumber HTML reports are generated which can be customized according to specific needs