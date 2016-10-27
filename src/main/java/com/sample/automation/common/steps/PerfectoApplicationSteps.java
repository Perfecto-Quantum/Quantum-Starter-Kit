package com.sample.automation.common.steps;

import com.qmetry.pm.utiles.*;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import cucumber.api.java.en.Then;

import java.util.concurrent.TimeUnit;

import static com.qmetry.qaf.automation.step.CommonStep.*;

/**
 * The class PerfectoApplicationSteps provides methods for working with applications, with cucumber steps annotations. 
 * <p>
 * Contexts used for testing:
 * <ul>
 * <li><b>WEBVIEW</b> context is used to identify DOM based UI Elements.
 * <li><b>NATIVE_APP</b> context is used to identify UI Elements defined with OS-based classes.
 * <li><b>VISUAL</b> context is used to identify UI Elements with Perfecto visual analysis.
 * </ul>
 * <p>
 * Example: Working with a device.
 * <pre>
 * Scenario: 
 * 	Given I go to the device home screen
 * 	Then I open browser to webpage "https://community.perfectomobile.com/"
 * 	Then I should see text "GETTING STARTED"
 * 	Then I take a screenshot and save to PRIVATE:dir1/dir2/name.png
 * </pre>
 * 
 * @author shanil
 * @see <a href="https://github.com/PerfectoCode/Quantum/wiki/BDD-Implementation">BDD Implementation</a>
 * @see <a href="https://community.perfectomobile.com/series/20208/posts/1072062">Switching contexts</a>
 */
@QAFTestStepProvider 
public class PerfectoApplicationSteps {

    //TODO should make new driver every call?
    private static WebDriverTestBase webDriverTestBase = new WebDriverTestBase();

    private static QAFExtendedWebDriver getDriver(){
        return webDriverTestBase.getDriver();
    }

    /**
     * Opens a native application with the application name. 
     * 
     * @param name the application name as it is displayed on the device screen
     */
    @Then("^I start application by name \"(.*?)\"$")
    public static void startAppByName(String name){
        ApplicationUtils.startApp(getDriver(), name, "name");
    }

    /**
     * Opens a native application with the application id. 
     * 
     * @param id the identifier of the application
     * @see <a href="https://community.perfectomobile.com/series/21760/posts/995065">Application Identifier</a>
     */
    @Then("^I start application by id \"(.*?)\"$")
    public static void startAppById(String id){
        ApplicationUtils.startApp(getDriver(), id, "identifier");
    }

    /**
     * Closes a native application with the applicaiton name.
     * 
     * @param name the application name as it is displayed on the device screen
     */
    @Then("^I close application by name \"(.*?)\"$")
    public static void closeAppByName(String name){
        ApplicationUtils.closeApp(getDriver(), name, "name");
    }
    
    /**
     * Closes a native application with the applicaiton id.
     * 
     * @param id the identifier of the application
     * @see <a href="https://community.perfectomobile.com/series/21760/posts/995065">Application Identifier</a>
     */
    @Then("^I close application by id \"(.*?)\"$")
    public static void closeAppById(String id){
        ApplicationUtils.closeApp(getDriver(), id, "identifier");
    }

    /**
     * Cleans the data (including cache) from any application installed on the device and brings the application back to its initial state.
     * 
     * @param name the application name as it is displayed on the device screen
     */
    @Then("^I clean application by name \"(.*?)\"$")
    public static void cleanAppByName(String name){
        ApplicationUtils.cleanApp(getDriver(), name, "name");
    }

    /**
     * Cleans the data (including cache) from any application installed on the device and brings the application back to its initial state. 
     * 
     * @param id the identifier of the application
     * @see <a href="https://community.perfectomobile.com/series/21760/posts/995065">Application Identifier</a>
     */
    @Then("^I clean application by id \"(.*?)\"$")
    public static void cleanAppById(String id){
        ApplicationUtils.cleanApp(getDriver(), id, "identifier");
    }

    /**
     * Removes a single application on the device.
     * 
     * @param name the application name as it is displayed on the device screen
     */
    @Then("^I uninstall application by name \"(.*?)\"$")
    public static void uninstallAppByName(String name){
        ApplicationUtils.uninstallApp(getDriver(), name, "name");
    }

    /**
     * Removes a single application on the device.
     * 
     * @param id the identifier of the application
     * @see <a href="https://community.perfectomobile.com/series/21760/posts/995065">Application Identifier</a>
     */
    @Then("^I uninstall application by id \"(.*?)\"$")
    public static void uninstallAppById(String id){
        ApplicationUtils.uninstallApp(getDriver(), id, "identifier");
    }

    /**
     * Installs a single application on the device.
	 * <p>
	 * To use, specify the local path to the application or the application repository key.
	 * If the application repository key is specified, the application must first be uploaded to the Perfecto Lab repository.
	 * <p>
	 * To do this, log in to the Perfecto Lab interface and use the Repository manager.
	 * Supported file formats include APK files for Android, IPA for iOS and COD for BlackBerry Devices.
     * 
     * @param application the local or repository path, including directory and file name, where to locate the application
     */
    @Then("^I install application \"(.*?)\"$")
    public static void installApp(String application){
        ApplicationUtils.installApp(application, getDriver(), false);
    }

    /**
     * Installs a single application on the device, with instrumentation.
	 * <p>
	 * To use, specify the local path to the application or the application repository key.
	 * If the application repository key is specified, the application must first be uploaded to the Perfecto Lab repository.
	 * <p>
	 * To do this, log in to the Perfecto Lab interface and use the Repository manager.
	 * Supported file formats include APK files for Android, IPA for iOS and COD for BlackBerry Devices.
     * 
     * @param application the local or repository path, including directory and file name, where to locate the application
     */
    @Then("^I install instrumented application \"(.*?)\"$")
    public static void installInstrumentApp(String application){
        ApplicationUtils.installApp(application, getDriver(), true);
    }

    /**
	 * Uninstalls all applications on the device, returning the device to its initial state. It does not affect applications pre-installed on the device. 
	 */
    @Then("^I uninstall all applications$")
    public static void resetApplications(){
        ApplicationUtils.uninstallAllApps(getDriver());
    }

    /**
     * Verifies the application version. The test will continue to run in case of failure.
     * 
     * @param version the application version to verify
     * @return <code>true</code> if the version is verified, <code>false</code> otherwise
     */
    @Then("^application version should be \"(.*?)\"$")
    public static boolean verifyAppVersion(String version){
        return ApplicationUtils.verifyAppInfo(getDriver(), "version", version);
    }

    /**
     * Checks the application version. Stops the test in case of failure.
     * 
     * @param version the application version to check
     */
    @Then("^application version must be \"(.*?)\"$")
    public static void assertAppVersion(String version){
        ApplicationUtils.assertAppInfo(getDriver(), "version", version);
    }

    /**
     * Verifies the application orientation. The test will continue to run in case of failure.
     * 
     * @param orientation the application orientation to verify, landscape or portrait
     * @return <code>true</code> if the orientation is verified, <code>false</code> otherwise
     */
    @Then("^application orientation should be \"(.*?)\"$")
    public static boolean verifyAppOrientation(String orientation) {
        return ApplicationUtils.verifyAppInfo(getDriver(), "orientation", orientation);
    }

    /**
     * Checks the application orientation. Stops the test in case of failure.
     * 
     * @param orientation the application orientation to check, landscape or portrait
     */
    @Then("^application orientation must be \"(.*?)\"$")
    public static void assertAppOrientation(String orientation) {
        ApplicationUtils.assertAppInfo(getDriver(), "orientation", orientation);
    }

    /**
     * Clicks on a native or web element.
     * 
     * Identify the object using the <i>Object Repository</i> or an XPath expression.
     * 
     * @param locator the object identifier
     * @see <a href="https://github.com/PerfectoCode/Quantum/wiki/Object%20Repository">Object Repository</a>
     */
    @Then("^I click on \"(.*?)\"$")
    public static void iClick(String locator){
       click(locator);
    }

    /**
     * Sets the text of a application element. Use the text parameter to specify the text to set.
     * 
     * Identify the edit field object using the <i>Object Repository</i> or an XPath expression. 
     * 
     * @param text the text to insert in the edit field
     * @param locator the object identifier
     * @see <a href="https://github.com/PerfectoCode/Quantum/wiki/Object%20Repository">Object Repository</a>
     */
    @Then("^I enter \"(.*?)\" to \"(.*?)\"$")
    public static void iSet(String text, String locator){
        sendKeys(text, locator);
    }

    /**
     * Verifies whether an element exists in the application. The test will continue to run in case of failure.
     * 
     * @param locator the object identifier 
     * @return <code>true</code> if the element exists, <code>false</code> otherwise
     */
    @Then("^\"(.*?)\" should exist$")
    public static boolean verifyLocator(String locator){
        return verifyPresent(locator);
    }

    /**
     * Checks whether an element exists in the application. Stops the test in case of failure.
     * 
     * @param locator the object identifier
     */
    @Then("^\"(.*?)\" must exist$")
    public static void assertLocator(String locator){
        assertPresent(locator);
    }

    /**
     * Verifies that the text appears on the device screen, using visual analysis. The test will continue to run in case of failure.
     * 
     * @param text the text to verify
     * @return <code>true</code> if the text exists, <code>false</code> otherwise
     */
    @Then("^I should see text \"(.*?)\"$")
    public static boolean verifyVisualText(String text){
        return ApplicationUtils.verifyVisualText(getDriver(),text);
    }

    /**
     * Checks that the text appears on the device screen, using visual analysis. Stops the test in case of failure.
     * 
     * @param text the text to check
     */
    @Then("^I must see text \"(.*?)\"$")
    public static void asserVisualText(String text){
        ApplicationUtils.assertVisualText(getDriver(), text);
    }

    /**
     * Verifies that the image appears on the device screen, using visual analysis. The test will continue to run in case of failure.
     * 
     * @param img the image to check
     */
    @Then("^I must see image \"(.*?)\"$")
    public static void assertVisualImg(String img){
        ApplicationUtils.assertVisualImg(getDriver(), img);
    }

    /**
     * Checks that the image appears on the device screen, using visual analysis. Stops the test in case of failure.
	 * <p>
	 * To use, the image must first be uploaded to the Perfecto Lab repository.
	 * <p>
	 * To do this, log in to the Perfecto Lab interface and use the Repository manager.
     * 
     * @param img the repository path, including directory and file name, where to locate the image
     * @see <a href="https://community.perfectomobile.com/posts/912493">Perfecto Lab Repository</a>
     */
    @Then("^I should see image \"(.*?)\"$")
    public static void verifyVisualImg(String img){
        ApplicationUtils.verifyVisualImg(getDriver(), img);
    }

    /**
     * Switch to native context (NATIVE_APP).
     * 
     * @see <a href="https://community.perfectomobile.com/series/20208/posts/1072062">Switching contexts</a>
     */
    @Then("^I switch to native context$")
    public static void switchNativeContext(){
        ApplicationUtils.switchToContext(getDriver(), "NATIVE_APP");
    }

    /**
     * Switch to web context (WEBVIEW).
     * 
     * @see <a href="https://community.perfectomobile.com/series/20208/posts/1072062">Switching contexts</a>
     */
    @Then("^I switch to webview context$")
    public static void switchWebviewContext(){
        ApplicationUtils.switchToContext(getDriver(), "WEBVIEW");
    }

    /**
     * Switch to visual context (VISUAL).
     * 
     * @see <a href="https://community.perfectomobile.com/series/20208/posts/1072062">Switching contexts</a>
     */
    @Then("^I switch to visual context$")
    public static void switchVisualContext(){
        ApplicationUtils.switchToContext(getDriver(), "VISUAL");
    }


    /**
     * Waits the specified duration before performing the next script step.
     * 
     * @param seconds the wait duration
     */
    @Then("^I wait for \"(\\d*\\.?\\d*)\" seconds$")
    public static void waitFor(long seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
        }
    }

    /**
     * Waits for the element to appear on the device screen.
     * <p>
     * Identify the element using the <i>Object Repository</i> or an XPath expression.
     * 
     * @param seconds the wait duration
     * @param locator the object identifier
     */
    @Then("^I wait (\\d+) seconds for \"(.*?)\" to appear$")
    public static void waitToAppear(long seconds, String locator){
        waitForPresent(locator, seconds);
    }

    
    /**
     * Waits for the text to appear on the device screen, using visual analysis.
     * 
     * @param seconds the wait duration
     * @param text the text to wait for to appear
     */
    //TODO: image/text visual analysis (Adi)    
   // @Then("^I wait \"(\\d*\\.?\\d*)\" seconds to see the text \"(.*?)\"$")
    
    /**
     * Waits for the image to appear on the device screen, using visual analysis.
     * 
     * @param seconds the wait duration
     * @param image the image to wait for to appear
     */
    //TODO: image/text visual analysis (Adi)
    @Then("^I wait \"(\\d*\\.?\\d*)\" seconds to see the image \"(.*?)\"$")
    public static void waitToSee(long seconds, String locator){
        ApplicationUtils.waitForPresentVisual(getDriver(), locator, seconds);
    }

    /**
     * Sets the wait period.
     * 
     * @param seconds the wait duration
     */
    @Then("^I wait \"(\\d*\\.?\\d*)\" seconds for elements to appear$")
    public static void waitToAppear(long seconds){
        getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    /**
     * Opens the browser application and browses to the specified location.
     * <p>
     * This is done with a direct native command to the device OS, and not with navigation.
     * 
     * @param url the specified URL
     */
    @Then("^I open browser to webpage \"(.*?)\"$")
    public  static void navigateToURL(String url){
        get(url);
    }

}
