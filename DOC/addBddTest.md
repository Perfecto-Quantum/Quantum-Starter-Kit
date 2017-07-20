#Add Test (BDD)
This doc describes how to add new BDD test.
The test will browse to [www.kayak.com.com](https://www.kayak.com/) and looks for flights between Boston and New York.

Before we start, just verify you have the Cucumber plugin installed:

*IntelliJ:* **File > Settings > Plugins** add looks fot **Cucumber for Java** 
![import](image/plugin.png?raw=true "plug")


###Step 1 - Add the feature file 
* __Go to__ *src > Main > resources > scenarios* 
  * Create new file named **kayak.feature** 
    * First add feature tag:  **@kayak**
    * Add the Test Suite name (Feature) **Feature: find_flight**
    * Add the first test (Scenario) **Scenario: kayak flight**
      * Add the first line   
        * Type **Given I** (*you should see autocomplete for all the commands*) ![import](image/auto.png?raw=true "auto")
          * Select the command:  
            * **I open browser to webpage "https://www.kayak.com"**
 
 Your script should looks like:  
  ![import](image/script1.png?raw=true "auto")
  
###Step 2 - Execute the basic test
* In order to execute the test we should edit our testNG.xml file:
  * Goto */src/main/resources/config*
    * Copy the file testng_web.xml to Kayak.xml
    * Change the group to **@kayak**

**Lets add one more execution on specific device**
* copy the \<test XML\> and replace the line of

  * ```\<parameter name="driver.capabilities.model" value="Galaxy.*"></parameter>  ```
	
	with
	
  * ``` \<parameter name="driver.capabilities.deviceName" value="DEVICEID"></parameter> ```

You also need to change the name tag.

#####Your xml should look like:
  ![import](image/testngxml.png?raw=true "xmlng")
  
#####Execute with TestNG  
* Goto upper left side of your screen 

![import](image/editrun.png?raw=true "xml") 
 
  * select **Edit Configurations...**  
    * Press [+] select testNG and poit to the new file we created 

![import](image/runG.png?raw=true "rg") 

###Step 3 Build objects reposotpry 
* Goto Perfecto IDE open browser on a device and go to : www.kayak.com   
  * Open the **Object Spy**  
    * First I want to press on the flights using the following xpath 
      * ```//*[@class='fdTopNavLink flights tap-enabled']```

* Creating the objects repository file:  
  * goto src/main/resources/common, create a new file **kayak.loc** and add the line:  
    * ```flights = xpath=[@class='fdTopNavLink flights tap-enabled']```
      * it means we named this button as a flights_bt.  

* I mapped all the elements and the file looks:  
  * ```flights_bt = xpath=//\*[@class='fdTopNavLink flights tap-enabled']  
    from\_bt = xpath=//\*[text()='From']  
    from\_to\_input= xpath=//\*[@type='text']  
    to\_bt = xpath=//\*[text()='To']  
    results = xpath=//\*[@class='r9-smarty-results']/span[3]  
    find\_fligth\_bt =xpath=//\*[text()='Find Flights']```

###Step 4 Finish the test
* Return to the **Kayak.feature** file and finish the flow; use the pre-defined steps and the object names from the repository file.  
  * The Script should looks:  
![import](image/script2.png?raw=true "auto")

**Execute again and monitoring the devices in Perfecto dashboard**


 






   





