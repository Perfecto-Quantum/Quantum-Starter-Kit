package com.quantum.pages;


import java.util.List;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.util.PropertyUtil;
import com.quantum.utils.ReportUtils;


public class GooglePage extends WebDriverBaseTestPage<WebDriverTestPage> {

	PropertyUtil props = ConfigurationManager.getBundle();

	@Override
	protected void openPage(PageLocator locator, Object... args) {

	}

	@FindBy(locator = "search.text.box")
	private QAFExtendedWebElement searchTextBox;
	@FindBy(locator = "search.option")
	private QAFExtendedWebElement searchOption;
	@FindBy(locator = "search.result.link")
	private QAFExtendedWebElement searchResultLink;


	public void search(String searchKey){
		searchTextBox.clear();
		searchTextBox.sendKeys(searchKey);
		// The following element is an example of creating run time objects on the fly
		QAFExtendedWebElement search = new QAFExtendedWebElement(String.format(props.getString("search.option"), searchKey));
		search.click();
	}

	public void verifyResult(String result){
		QAFExtendedWebElement searchResult = new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("search.result.link"), result));
		searchResult.waitForVisible(5000);
		ReportUtils.logAssert("Expected result: " + result, searchResult.isDisplayed());	
	}

	public void verifyResult(List<String> results){
		QAFExtendedWebElement searchResultElement;
		for (String result : results) {
			QAFExtendedWebElement searchResult = new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("search.result.link"), result));
			searchResult.waitForVisible(5000);
			ReportUtils.logAssert("Expected result: " + result, searchResult.isDisplayed());
		}
	}
}
