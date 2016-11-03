package com.quantum.java.pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class MainscreenTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "input.box")
	private QAFWebElement inputBox;
	@FindBy(locator = "btn.plus")
	private QAFWebElement btnPlus;
	@FindBy(locator = "btn.division")
	private QAFWebElement btnDivision;
	@FindBy(locator = "btn.minus")
	private QAFWebElement btnMinus;
	@FindBy(locator = "btn.equal")
	private QAFWebElement btnEqual;
	@FindBy(locator = "btn.clear")
	private QAFWebElement btnClear;
	@FindBy(locator = "btn.multiplication")
	private QAFWebElement btnMultiplication;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getInputBox() {
		return inputBox;
	}

	public QAFWebElement getBtnPlus() {
		return btnPlus;
	}

	public QAFWebElement getBtnDivision() {
		return btnDivision;
	}

	public QAFWebElement getBtnMinus() {
		return btnMinus;
	}

	public QAFWebElement getBtnEqual() {
		return btnEqual;
	}

	public QAFWebElement getBtnClear() {
		return btnClear;
	}

	public QAFWebElement getBtnMultiplication() {
		return btnMultiplication;
	}

}
