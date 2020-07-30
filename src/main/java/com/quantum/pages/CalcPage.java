package com.quantum.pages;


import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.util.PropertyUtil;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.DriverUtils;
import com.quantum.utils.ReportUtils;


public class CalcPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	PropertyUtil props = ConfigurationManager.getBundle();

	@Override
	protected void openPage(PageLocator locator, Object... args) {
	}

	@FindBy(locator = "btn.clear")
	private QAFExtendedWebElement clearBtn;	
	@FindBy(locator = "btn.plus")
	private QAFExtendedWebElement plusBtn;
	@FindBy(locator = "btn.equal")
	private QAFExtendedWebElement equalBtn;	 


	public void clear(){
		clearBtn.click();
	}

	public void add(long l1, long l2){
		DriverUtils.getAppiumDriver().findElementByAccessibilityId(String.valueOf(l1)).click();
		plusBtn.click();
		DriverUtils.getAppiumDriver().findElementByAccessibilityId(String.valueOf(l2)).click();
		equalBtn.click();
	}

	public void verifyResult(long l1){
		QAFExtendedWebElement resultBox; 
		if(DeviceUtils.getQAFDriver().getCapabilities().getPlatform().toString().equalsIgnoreCase("ios")) {
			resultBox = new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("input.box"), l1));
		}else {
			resultBox = new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("input.box"), l1, l1));
		}
		resultBox.click();
		ReportUtils.logAssert("Expected result: " + String.valueOf(l1), resultBox.isDisplayed());
	}
}
