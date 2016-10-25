This is sample project to demonstrate use of Gherkin for test case authoring. Project includes  web, web-service and non-web test-cases.
In this example, cucumber annotations are used for step implementation. You also can use implement step using @QAFTestStep annotation.

Please refer https://qmetry.github.io/qaf/latest/qaf-gherkin-client.html


directory structure:
 
The 'config' directory contains testng.xml file, and is a place holder for configuration files.
The 'lib' directory contains required jar files, and is a place holder for other library jars/zips.
The 'resources' directory contains all required resources including properties files and data files, and is a place holder for other resources.
The 'scripts' directory contains ant script to build and run automation. It also contains bat file for windows environment.
The 'src' directory contains all java files and is a place holder for other java files.
The 'bin' directory contains compiled classes, and is a volatile directory that is deleted by the target clean in build.xml file.
The 'test-results' directory contains result files.
The 'scenarios' directory is the default place holder for all the scenario files. 


To change/modify dependencies check ivy.xml
To run the project, from command prompt go to project home and run ant. Open dashboard.htm to view results.

Note: 
If you want to run test for web remove exclude @Web from config file.
Scenarios with tag @Web requires web driver configuration. Set 'driver.name' to use specific webdriver. Default set to chromeDriver and which requires chrome driver binary.
You need to download and set webdriver.chrome.driver property in application.properties file with driver binary path.

Thanks,
QAS Team.