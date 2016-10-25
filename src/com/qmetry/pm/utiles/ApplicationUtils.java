package com.qmetry.pm.utiles;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.util.Validator;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteExecuteMethod;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.qmetry.qaf.automation.step.CommonStep.*;

public class ApplicationUtils {

	public static boolean verifyVisualText(RemoteWebDriver driver, String text){
		return Validator.verifyThat(isText(driver, text), Matchers.equalTo("true"));
	}

	public static void assertVisualText(RemoteWebDriver driver, String text){
		Assert.assertEquals(isText(driver, text), "true", "Text: \"" + text + "\" was not found");
	}

	public static void installApp(String filePath, RemoteWebDriver d, boolean shouldInstrument) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("file", filePath);
		if (shouldInstrument) {
			params.put("instrument", "instrument");
		}
		d.executeScript("mobile:application:install", params);
	}

	private static Map<String, String> getAppParams(String app, String by){
		Map<String, String> params = new HashMap<String, String>();
		params.put(by, app);
		return params;
	}

	//by = "name" or "identifier"
	public static void startApp(RemoteWebDriver driver, String app, String by) {
		driver.executeScript("mobile:application:open", getAppParams(app, by));
	}
	//by = "name" or "identifier"
	public static void closeApp(RemoteWebDriver driver, String app, String by) {
		driver.executeScript("mobile:application:close", getAppParams(app, by));
	}
	//by = "name" or "identifier"
	public static void cleanApp(RemoteWebDriver driver, String app, String by) {
		driver.executeScript("mobile:application:clean", getAppParams(app, by));
	}
	//by = "name" or "identifier"
	public static void uninstallApp(RemoteWebDriver driver, String app, String by) {
		driver.executeScript("mobile:application:uninstall", getAppParams(app, by));
	}

	public static void uninstallAllApps(RemoteWebDriver driver) {
		Map<String, String> params = new HashMap<String, String>();
		driver.executeScript("mobile:application:reset", params);
	}

	public static String getAppInfo(RemoteWebDriver driver, String property){
		Map<String, String> params = new HashMap<String, String>();
		params.put("property", property);
		return (String)driver.executeScript("mobile:application:info", params);
	}

	public static boolean verifyAppInfo(RemoteWebDriver driver, String propertyName, String propertyValue) {
		return Validator.verifyThat(getAppInfo(driver, propertyName), Matchers.equalTo(propertyValue));
	}

	public static void assertAppInfo(RemoteWebDriver driver, String propertyName, String propertyValue) {
		String appOrientation = getAppInfo(driver, propertyName);
		Assert.assertEquals(appOrientation, propertyValue);
	}

	public static void switchToContext(RemoteWebDriver driver, String context) {
		RemoteExecuteMethod executeMethod = new RemoteExecuteMethod(driver);
		Map<String, String> params = new HashMap<String, String>();
		params.put("name", context);
		executeMethod.execute(DriverCommand.SWITCH_TO_CONTEXT, params);
	}

	public static void waitForPresentVisual(RemoteWebDriver driver, String locator, long seconds) {
		String context = getCurrentContext(driver);
		switchToContext(driver, "VISUAL");
		waitForPresent(locator, seconds);
		switchToContext(driver, context);
	}
	
	public static void clickOnVisual(RemoteWebDriver driver, String locator ) {
		String context = getCurrentContext(driver);
		switchToContext(driver, "VISUAL");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText(locator)).click();
		switchToContext(driver, context);
	}
 
	private static String isImg(RemoteWebDriver driver, String img){
		String context = getCurrentContext(driver);
		switchToContext(driver, "VISUAL");
		Map<String, String> params = new HashMap<String, String>();
		params.put("content", img);
		params.put("measurement","accurate");
		params.put("source","primary");
		params.put("threshold","90");
		params.put("timeout","30");
		params.put("match","similar");
		params.put("service", "central");
		Object result = driver.executeScript("mobile:checkpoint:image", params);
		switchToContext(driver, context);
		return result.toString();
	}

	public static void assertVisualImg(RemoteWebDriver driver, String img) {
		Assert.assertEquals(isImg(driver, img), "true", "Image " + img + " was not found");
	}

	public static boolean verifyVisualImg(RemoteWebDriver driver, String img) {
		return Validator.verifyThat(isImg(driver, img), Matchers.equalTo("true"));
	}

	private static String isText(RemoteWebDriver driver, String text){
		String context = getCurrentContext(driver);
		switchToContext(driver, "VISUAL");
		Map<String, String> params = new HashMap<String, String>();
		params.put("content", text);
		params.put("timeout", "20");
		Object result = driver.executeScript("mobile:checkpoint:text", params);
		switchToContext(driver, context);
		return result.toString();
	}

	/**
	 *
	 *
	 * @param driver
	 * @return the current context - "NATIVE_APP", "WEBVIEW", "VISUAL"
	 */
	public static String getCurrentContext(RemoteWebDriver driver) {
		RemoteExecuteMethod executeMethod = new RemoteExecuteMethod(driver);
		return (String) executeMethod.execute(DriverCommand.GET_CURRENT_CONTEXT_HANDLE, null);
	}
}
