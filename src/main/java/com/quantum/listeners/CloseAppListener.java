package com.quantum.listeners;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.util.StringUtil;
import com.quantum.listeners.QuantumReportiumListener;
import com.quantum.utils.DeviceUtils;
import org.testng.ITestResult;

/**
 * Created by mitchellw on 9/27/2016.
 */
public class CloseAppListener extends QuantumReportiumListener {

    @Override
    public void onTestSuccess(ITestResult testResult) {
        super.onTestSuccess(testResult);
        closeApp(testResult);

    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        super.onTestFailure(testResult);
        closeApp(testResult);
    }

    public void closeApp(ITestResult testResult){

        Object testInstance = testResult.getInstance();
        QAFExtendedWebDriver driver = null;

        if (testInstance instanceof WebDriverTestCase)
            driver = ((WebDriverTestCase) testInstance).getDriver();
        if (driver != null) {

            String appName = (String) driver.getCapabilities()
                    .getCapability("applicationName");

            if (StringUtil.isNotBlank(appName)) {
                try {
                    DeviceUtils.closeApp(appName, "name", true, driver);

                } catch (Exception e) {
                }
            }
        }

    }

}
