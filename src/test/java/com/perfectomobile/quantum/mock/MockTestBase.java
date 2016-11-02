package com.perfectomobile.quantum.mock;

import com.perfectomobile.quantum.utils.ConsoleUtils;
import com.qmetry.qaf.automation.ui.AbstractTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;

import static org.mockito.Mockito.mock;

/**
 * Created by mitchellw on 10/17/2016.
 */
public class MockTestBase extends AbstractTestBase<QAFExtendedWebDriver> {
    @Override
    protected void launch(String baseurl) {
        ConsoleUtils.logThread("Launch URL: " + baseurl);
    }

    @Override
    public QAFExtendedWebDriver getDriver() {
        ConsoleUtils.logWarningBlocks("Using Mock Test Base...");
        return mock(QAFExtendedWebDriver.class);
    }

    public QAFExtendedWebElement getElement(String loc) {
        ConsoleUtils.logWarningBlocks("Using Mock Element...");
        return mock(QAFExtendedWebElement.class);
    }
}
