package com.quantum.pages;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;


public class ExpenseTrackerHomePage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub

	}


	@FindBy(locator = "first.screen.title.text")
	private QAFExtendedWebElement firstScreenTitle;

	@FindBy(locator = "first.screen.text")
	private QAFExtendedWebElement firstScreenText;

	@FindBy(locator = "first.screen.next.button")
	private QAFExtendedWebElement nextBtn;

	@FindBy(locator = "second.screen.text")
	private QAFExtendedWebElement secondScreenText;

	@FindBy(locator = "second.screen.previous.button")
	private QAFExtendedWebElement previousBtn;


	public void validateFirstScreen() {
		firstScreenTitle.waitForVisible(1000);
		firstScreenTitle.isDisplayed();
		firstScreenText.isDisplayed();
		nextBtn.isDisplayed();
	}

	public void clickNextButton() {
		nextBtn.click();
	}

	public void validateSecondScreen () {
		secondScreenText.waitForVisible(1000);
		secondScreenText.isDisplayed();
		previousBtn.isDisplayed();
	}

	public void clickPreviousButton () {
		previousBtn.waitForVisible(1000);
		previousBtn.isDisplayed();
	}
}
