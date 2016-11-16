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

3. [Cucumber Plugin (Community version only)](https://marketplace.eclipse.org/content/cucumber-jvm-eclipse-plugin)

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

```

TAL - ASK YAACOV TO UPDATE THE CURRENT STRUCTURE

```

**********************
# Getting Started
This procedure leads you through the various Quantum framework's aspects:

* [Running one of the samples](README#running-sample-as-is) in the Quantum project as is.
* [Parallel execution](README#parallel-execution) of all Quantum samples.
* [Diversifying test execution](README#diversifying-test-execution) by manipulating test suites.
* [Viewing test execution results](README#viewing-test-execution-results-in-perfecto-reporting)
* [Advanced Quantum features](README#advanced-quantum-features)

## Running sample as is
Run a single Quantum sample from the samples provided in the Starter Kit.

The samples are located under the _src/main/resources/scenarios_ folder.

1.      Configure yout cloud and credentials in the _appication.properties_ file (under the top _resources/_ folder).
2.      Run your test via the right-click menu while hovering on the TestNG.xml file in the project pane (on the left).

The sample opens device browser at Google, searches for Perfecto Mobile, enters the site, and searches for Perfecto Object Spy.

## Parallel execution
To run all samples in parallel, you need to configure the _TestNG.xml_ file, which is located under the _src/test/resources/config/_ folder.

1.      For each of the test suites (enclosed within <test>...</test>), set the _enabled_ property value to **_true_**.
2.      Run your test as before.

This results in running 2 additional samples, both searching terms in Perfecto Community; one uses hard coded search terms, and the other retrieves them from an external input file.

## Diversifying test execution
You can set each of the test suites to run on a different type of device, and to include different scenarios. For that, you need to manipulate the contents of the various test suites in the _TestNG.xml_ file.
Modify **only** the test suites not related to the Google sample we started with.

1. Replace the current tag in the community samples, so that in the _CommunityExample.feature_ sample all tags are **@sampletag**, and in the _CommunityDataDrivenExample.feature_ sample - **@sampletagdd**. <br>You may of course use other values, or leave the tags as is, but use these tag values for demonstration's sake.
2. In the _TestNG.xml_ file, set the tag parameter value in one suite to **@sampletag**, and in the other - to **@sampletagdd**.<br>That means, that the first test suite runs the CommunityExample sample, and the second - the CommunityDataDrivenExample sample.
3. To vary the devices used for each of the test suites, replace the capability parameter ("driver.capabilities.someCapability") in both suites with<br>`<parameter name="driver.capabilities.platformName" value="Android"/>`.<br>Set the value to "iOS" in the second test suite.<br>By that, you specify that the CommunityExample sample will run on an Android device (randomly allocated), and the CommunityDataDrivenExample sample - on an iOS device.<br>**Note:** Generally, you can use any of the numerous device selection capabilities.
4.  Run your test in the same manner as before.<br>You can follow your test execution on Perfecto Dashboard and see the three samples running on the specified device types.

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
* Create your own [Object Repository](Object Repository) file to match your application objects. 
* Create a [[customized steps|Creating customized steps]] file to ease performing actions common in your application operation.
* Write tests using either [BDD](BDD-Implementation) or [Java](Java-Implementation).
* Configure the [TestNG.xml](Quantum TestNG File) to filter the tests to execute and the devices used in the test.

Configuration of the [application properties](The application.properties file) and the [TestNG.xml file](Quantum TestNG File), as well as creating object definitions in the [Object Repository](Object Repository) and [[creating customized steps|Creating customized steps]], require knowledge of Java, TestNG, and XPath.

:information_source: The [Perfecto plugin](https://www.perfectomobile.com/ni/resources/downloads/add-ins-plugins-and-extensions) enables access to real devices and desktop Web sessions in the CQ Lab, as well as easy-to-use [Object Spy](https://community.perfectomobile.com/series/18628) for mapping the application objects in the [Object Repository](Object Repository).
