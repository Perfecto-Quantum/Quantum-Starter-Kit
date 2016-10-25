package com.qmetry.pm.utiles;

import com.qmetry.qaf.automation.util.Validator;
import org.hamcrest.Matchers;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class DeviceUtils {

	/**
	 * Clicks on a single or sequence of physical device keys.
	 * Mouse-over the device keys to identify them, then input into the Keys parameter according to the required syntax.
	 * <p>
	 * Common keys include:
	 * LEFT, RIGHT, UP, DOWN, OK, BACK, MENU, VOL_UP, VOL_DOWN, CAMERA, CLEAR.
	 * <p>
	 * The listed keys are not necessarily supported by all devices. The available keys depend on the device.
	 *
     * @param driver the RemoteWebDriver
     * @param keySequence the single or sequence of keys to click
     */
    public static void pressKey(RemoteWebDriver driver, String keySequence) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("keySequence", keySequence);
        driver.executeScript("mobile:presskey", params);
    }

    /**
     * Performs the swipe gesture according to the start and end coordinates.
     * <p>
     * Example swipe left:<br/>
     * start: 60%,50% end: 10%,50%
     *
     * @param driver the RemoteWebDriver
     * @param start write in format of x,y. can be in pixels or percentage(recommended).
     * @param end write in format of x,y. can be in pixels or percentage(recommended).
     */
    public static void swipe(RemoteWebDriver driver, String start, String end) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("start", start);
        params.put("end", end);

        driver.executeScript("mobile:touch:swipe", params);

    }

    /**
     * Performs the touch gesture according to the point coordinates.
     * 
     * @param driver the RemoteWebDriver
     * @param point write in format of x,y. can be in pixels or percentage(recommended).
     */
    public static void touch(RemoteWebDriver driver, String point) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("location", point);  //50%,50%

        driver.executeScript("mobile:touch:tap", params);
    }

    /**
     * Hides the virtual keyboard display.
     * 
     * @param driver the RemoteWebDriver
     */
    public static void hideKeyboard(RemoteWebDriver driver) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("mode", "off");

        driver.executeScript("mobile:keyboard:display", params);

    }

    /**
     * Rotates the device to landscape, portrait, or its next state.
     * 
     * @param driver the RemoteWebDriver
     * @param restValue the "next" operation, or the "landscape" or "portrait" state.
     * @param by the "state" or "operation"
     */
    //TODO: need additional description.
    public static void rotateDevice(RemoteWebDriver driver, String restValue, String by) {
        Map<String, String> params = new HashMap<String, String>();
        params.put(by, restValue);
        driver.executeScript("mobile:handset:rotate", params);
    }

    //by = "address" or "coordinates"
    public static void setLocation(RemoteWebDriver driver, String location, String by) {

        Map<String, String> params = new HashMap<String, String>();
        params.put(by, location);

        driver.executeScript("mobile:location:set", params);
    }

    public static void assertLocation(RemoteWebDriver driver, String location) {
        String deviceLocation = getDeviceLocation(driver);
        Assert.assertEquals(deviceLocation, location, "The device location is " + deviceLocation + "but excpected " + location);
    }

    public static boolean verifyLocation(RemoteWebDriver driver, String location) {
        String deviceLocation = getDeviceLocation(driver);
        return Validator.verifyThat(deviceLocation, Matchers.equalTo(location));
    }

    public static String getDeviceLocation(RemoteWebDriver driver) {
        Map<String, String> params = new HashMap<String, String>();
        return (String) driver.executeScript("mobile:location:get", params);
    }


    public static void resetLocation(RemoteWebDriver driver) {
        Map<String, String> params = new HashMap<String, String>();
        driver.executeScript("mobile:location:reset", params);
    }


    public static void goToHomeScreen(RemoteWebDriver driver) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("target", "All");

        driver.executeScript("mobile:handset:ready", params);
    }

    public static void lockDevice(RemoteWebDriver driver, int sec) {
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("timeout", sec);

        driver.executeScript("mobile:screen:lock", params);
    }

    public static void setTimezone(RemoteWebDriver driver, String timezone) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("timezone", timezone);

        driver.executeScript("mobile:timezone:set", params);
    }

    public static String getTimezone(RemoteWebDriver driver) {
        Map<String, String> params = new HashMap<String, String>();

        return (String) driver.executeScript("mobile:timezone:get", params);
    }

    public static void assertTimezone(RemoteWebDriver driver, String timezone) {
        String deviceTimezone = getTimezone(driver);
        Assert.assertEquals(deviceTimezone, timezone, "The device timezone is '" + deviceTimezone + "' but expected '" + timezone + "'");
    }

    public static boolean verifyTimezone(RemoteWebDriver driver, String timezone) {
        return Validator.verifyThat(getTimezone(driver), Matchers.equalTo(timezone));
    }

    public static void resetTimezone(RemoteWebDriver driver) {
        Map<String, String> params = new HashMap<String, String>();
        driver.executeScript("mobile:timezone:reset", params);
    }

    public static void takeScreenshot(RemoteWebDriver driver, String repositoryPath, boolean shouldSave) {
        Map<String, String> params = new HashMap<String, String>();
        if (shouldSave) {
            params.put("key", repositoryPath);
        }
        driver.executeScript("mobile:screen:image", params);
    }

}
