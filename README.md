# Quantum Starter Kit
This starter kit is designed to get you up and running using the Quantum framework (powered by [QAF](https://github.com/qmetry/qaf)) within few simple steps, and enable you to start writing your tests using simple [Cucumber] (https://cucumber.io/).

Begin with installing the dependencies below, and continue with the Getting Started procedure below.

### Dependencies
There are several prerequisite dependencies you should install on your machine prior to starting to work with Quantum:

* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

* An IDE to write your tests on - [Eclipse](http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/marsr) or [IntelliJ](https://www.jetbrains.com/idea/download/#)

* [Maven](https://maven.apache.org/)

Eclipse users should also install:

1. [Maven Plugin](http://marketplace.eclipse.org/content/m2e-connector-maven-dependency-plugin)

2. [TestNG Plugin](http://testng.org/doc/download.html)

3. [QAF Cucumber Plugin](https://marketplace.eclipse.org/content/qaf-bdd-editors). Or go to  install new software option in eclipse, and download from https://qmetry.github.io/qaf/editor/bdd/eclipse/

IntelliJ IDEA users should also install:

1. [Maven Plugin for IDEA](https://plugins.jetbrains.com/plugin/1166)

2. [Cucumber Plugin (Community version only)](https://plugins.jetbrains.com/plugin/7212)

TestNG Plugin is built-in in the IntelliJ IDEA, from version 7 onwards.
 
#### Optional Installations
* For source control management, you can install [git](https://git-scm.com/downloads).
* To be able to interact with a real device from Perfecto cloud directly from your IDE, and use Perfecto Reporting, install [Perfecto CQ Lab Plugin](https://www.perfectomobile.com/ni/resources/downloads/add-ins-plugins-and-extensions) for your IDE.

## Downloading the Quantum Project

[Download](https://github.com/Project-Quantum/Quantum-Starter-Kit/archive/master.zip) the Quantum-Started-Kit repository.

After downloading and unzipping the project to your computer, open it from your IDE by choosing the folder containing the pom.xml file (_Quantum-Starter-Kit-master_, you might consider renaming it).

Look [here](https://github.com/PerfectoCode/Quantum/wiki/Project%20Layout) to understand the project layout, and find your way in it.

**********************
# Getting Started

<a target="_blank" href="https://youtu.be/FOHrWCuNPWI"><img src="https://github.com/Project-Quantum/Quantum-Starter-Kit/wiki/img/QuantumIntroThumbnail.png" alt="Quantum Framework Introduction and Getting Started"/></a>

This procedure leads you through the various Quantum framework's aspects:

* [Running one of the samples](README.md#running-sample-as-is) in the Quantum project as is.
* [Creating your first test](README.md#creating-your-first-test) using the Quantum-Starter-Kit
* [Parallel execution](README.md#parallel-execution) of all Quantum samples.
* [Diversifying test execution](README.md#diversifying-test-execution) by manipulating test suites.
* [Viewing test execution results](README.md#viewing-test-execution-results-in-perfecto-reporting)
* [Advanced Quantum features](README.md#advanced-quantum-features)

## Running sample as is
Run a single Quantum sample from the samples provided in the Starter Kit.

The samples are located under the _src/main/resources/scenarios_ folder.

1. Configure yout cloud and credentials in the _appication.properties_ file (under the top _resources/_ folder).
2. Run your test via the right-click menu while hovering on the TestNG.xml file in the project pane (on the left).

The sample opens device browser at Google, searches for Perfecto Mobile, enters the site, and searches for Perfecto Object Spy.

## Creating your first test

1. Download the Quantum-Starter-Kit as zip to your computer, and rename it.
2. Open the project from its _pom.xml_ file, to open it as a Maven project with all the required dependencies.
3. Define your CQ Lab name, username, and password in the _application.properties_ file.
4. Add a _.feature_ file under the _scenarios/_ folder, and procede to create your test using the [test writing guidelines](README.md#test-writing-guidelines).
5. Add a _.loc_ file under the _common/_ folder, and procede to create the Object Repository using the [Object Repository creation guidelines](README.md#object-repository-creation-guidelines).
6. Clean your test from the object definitions until all lines become syntax highlighted.
7. [Configure the testng file](README.md#testng-guidelines), and run your test from it.


### Test writing guidelines

* Begin with @featuretagname, Feature: name of feature, @scenariotagname (can be the same as the feature's tag).
* Write your scenario using [Given/When/Then/And](https://github.com/cucumber/cucumber/wiki/Given-When-Then) BDD statements. Use the commands in the pull-down list for accurate steps syntax, and easy step insertion.
* Write your first scenario for the app's initial starting point, and later create scenarios for other cases; name them differently to enable easy identification in execution report, and name their tags differently if you want to run them separately.
* Name your app's objects as _functionality.purpose_, for example _button.route_, _edit.start_, etc.
* If you have a Perfecto plugin - use Perfecto's [Object Spy](https://community.perfectomobile.com/series/18628-object-spy) to obtain smart object locators for your app's objects; if you do not - use other tools, such as Firebug or Chrome's Developer Tools, for that purpose. Put each object locator at the end of the line using that object - it will be used later for creating the Object Repository.<br>When using Object Spy, remember to set your object type to _DOM_ or _Native_ depending on your app's type being Web or Native, respectively. 
* If you want to run your app's steps using the Object Spy, check the _Execute on Add_ checkbox.
* Add steps for taking screenshots to allow close examination of test results later on.
* Add steps for waiting a few seconds upon app's page loading.

### Object Repository creation guidelines
1. Copy-Paste your test to the _.loc_ file.
2. Remove lines unrelated to objects. 
3. From each object related line, create a line formatted as <br>`objectname = locatortype=objectlocator`<br>For example <br>`edit.start = xpath=//*[@label="Start location"]`

### Testng guidelines

1. Under the _config/_ folder, open the _testng_appium.xml_ or _testng_web.xml_ file, depending on your app type.
2. Copy the first test suite, and verify it's the only one with a **true** _enabled_ property, to prevent the other test suites from running in parallel.
3. Copy your feature/scenario tag to the _name_ property in the _include_ clause. Use a space-separated tags' list to include more scenarios and features.
4. Add a parameter specifying the type of device, or naming a specific one, to be used for your test execution, for example, <br>`<parameter name="driver.capabilities.model" value="iPhone.*"></parameter>`


## Parallel execution
To run all samples in parallel, you need to configure the _TestNG.xml_ file, which is located under the _src/test/resources/config/_ folder.

1. For each of the test suites (enclosed within <test>...</test>), set the _enabled_ property value to **_true_**.
2. Run your test as before.

This results in running 2 additional samples, both searching terms in Perfecto Community; one uses hard coded search terms, and the other retrieves them from an external input file.

## Diversifying test execution
You can set each of the test suites to run on a different type of device, and to include different scenarios. For that, you need to manipulate the contents of the various test suites in the _TestNG.xml_ file.
Modify **only** the test suites not related to the Google sample we started with.

1. Replace the current tag in the community samples, so that in the _CommunityExample.feature_ sample all tags are **@sampletag**, and in the _CommunityDataDrivenExample.feature_ sample - **@sampletagdd**. <br>You may of course use other values, or leave the tags as is, but use these tag values for demonstration's sake.
2. In the _TestNG.xml_ file, set the tag parameter value in one suite to **@sampletag**, and in the other - to **@sampletagdd**.<br>That means, that the first test suite runs the CommunityExample sample, and the second - the CommunityDataDrivenExample sample.
3. To vary the devices used for each of the test suites, replace the capability parameter ("driver.capabilities.someCapability") in both suites with<br>`<parameter name="driver.capabilities.platformName" value="Android"/>`.<br>Set the value to "iOS" in the second test suite.<br>By that, you specify that the CommunityExample sample will run on an Android device (randomly allocated), and the CommunityDataDrivenExample sample - on an iOS device.<br>**Note:** Generally, you can use any of the numerous device selection capabilities.
4. Run your test in the same manner as before.<br>You can follow your test execution on Perfecto Dashboard and see the three samples running on the specified device types.

## Viewing test execution results in Perfecto Reporting

All the previous executions were recorded, and may be viewed in Perfecto execution center, Reporting.

Let's proceed to naming your tests, so you can easily detect them in Perfecto Reporting and drill down to examine them in more detail.

1. In each of the feature files (the samples), set the Feature line at the top to<br>`Feature: community search sample`
2. Run your test as before.
3. To view the test execution report within Perfecto Reporting:
   * Enter your CQ Lab at https://<your CQ Lab>.perfectomobile.com.
   * Select the Reporting tab, and click the link to Perfecto Reporting (on the right).
   * Login using your CQ Lab credentials.<br><br>
All the last execution tests are listed in the Reporting execution center. The feature name you set in the sample before, appears as the test name on the left. 
4. To drill down into any of the specific test executions, click the test to view its Single Test Report for more execution details.


## Advanced Quantum features

Quantum has additional features to allow better customization to your specific application:
* Create your own [Object Repository](https://github.com/Project-Quantum/Quantum-Starter-Kit/wiki/Object%20Repository) file to match your application objects. 
* Create a [[customized steps|Creating customized steps]] file to ease performing actions common in your application operation.
* Write tests using either [BDD](https://github.com/Project-Quantum/Quantum-Starter-Kit/wiki/BDD-Implementation) or [Java](https://github.com/Project-Quantum/Quantum-Starter-Kit/wiki/Java-Implementation).
* Configure the [TestNG.xml](https://github.com/Project-Quantum/Quantum-Starter-Kit/wiki/Quantum%20TestNG%20File) to filter the tests to execute and the devices used in the test.

Configuration of the [application properties](https://github.com/Project-Quantum/Quantum-Starter-Kit/wiki/The%20application.properties%20file) and the [TestNG.xml file](https://github.com/Project-Quantum/Quantum-Starter-Kit/wiki/Quantum%20TestNG%20File), as well as creating object definitions in the [Object Repository](https://github.com/Project-Quantum/Quantum-Starter-Kit/wiki/Object%20Repository) and [creating customized steps](https://github.com/Project-Quantum/Quantum-Starter-Kit/wiki/Creating%20customized%20steps), require knowledge of Java, TestNG, and XPath.

:information_source: The [Perfecto plugin](https://www.perfectomobile.com/ni/resources/downloads/add-ins-plugins-and-extensions) enables access to real devices and desktop Web sessions in the CQ Lab, as well as easy-to-use [Object Spy](https://community.perfectomobile.com/series/18628) for mapping the application objects in the [Object Repository](https://github.com/Project-Quantum/Quantum-Starter-Kit/wiki/Object%20Repository).

**********************
# Project Directory Structure
```
.
│   pom.xml                                                 # Maven pom file for build and dependencies  
│   README.md                                               # The current readme file  
│  
├───resources                                               # Default resources dir  
│       application.properties                              # set credentials and other project properties  
│  
└───src												   		
    └───main  
        ├───java                                            # All code for project inside java directory  
        │   └───com  
        │       └───quantum                                 # com.quantum namespace  
        │           ├───java                                # Package namespace for pure java tests  
        │           │   └───pages                           # Package for Java test Page Object Models  
        │           │           MainscreenTestPage.java     # Example POM  
        │           │  
        │           └───steps                               # Package namespace for Gherkin/Cucumber step definitions  
        │                   CalcStepsDefs.java              # Step definitions for appiumCalc feature file  
        │                   GoogleStepDefs.java             # Step definitions for webSearch feature file  
        │  
        └───resources                                       # All project specific files here  
            │   assertMessages.properties                   # Property definitions used in qaf library AssertionService class  
            │   log4j.properties                            # Controls all logging to console and log files  
            │  
            ├───android                                     # Additional Android properties. Specified in testng_appium file.  
            │       env.properties                          # Android specific additional environment variables  
            │       mainscreen.loc                          # Android specific object locators for calculator test objects  
            │  
            ├───common                                      # Common resources dir. Set with env.resources in application.properties  
            │       search.loc                              # Common object locators used in webSearch feature file  
            │       testdata.xml                            # Data used in xml scenario in webSearch feature  
            │  
            ├───config                                      # TestNG xml test file directory  
            │       testng_appium.xml                       # TestNG file that runs appiumCalc feature file with @appium tag  
            │       testng_web.xml                          # TestNG file that runs webSearch feature file with @Web tag  
            │  
            ├───data                                        # Data used in data driven tests stored here  
            │       testData.csv                            # csv data file used in csv webSearch scenario  
            │       testData.json                           # example of json data file  
            │       testData.xls                            # example of Excel data file  
            │  
            ├───ios                                         # Addition iOS properties. Specified in testng_appium file.  
            │       env.properties                          # iOS specific additional environment properties  
            │       mainscreen.loc                          # iOS locators for calculator application DOM objects  
            │  
            └───scenarios                                   # Cucumber/Gherkin feature files directory  
                    appiumCalc.feature                      # Appium Calculator app test feature file called by testng_appium xml file  
                    webSearch.feature                       # Web Google Search feature file driven by testng_web xml file  
``` 
