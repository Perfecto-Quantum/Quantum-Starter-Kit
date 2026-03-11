package com.quantum.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

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

public class DemoBlazeHomePage extends WebDriverBaseTestPage<WebDriverTestPage> {

//	Logg
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub

	}

	PropertyUtil props = ConfigurationManager.getBundle();

	@FindBy(locator = "blaze.contact.email.input")
	private QAFExtendedWebElement contactEmailInput;

	@FindBy(locator = "blaze.contact.name.input")
	private QAFExtendedWebElement contactNameInput;

	@FindBy(locator = "blaze.contact.message.input")
	private QAFExtendedWebElement contactMessageInput;

	@FindBy(locator = "blaze.contact.send.btn")
	private QAFExtendedWebElement contactSendBtn;

	@FindBy(locator = "blaze.login.username.input")
	private QAFExtendedWebElement loginUsernameInput;

	@FindBy(locator = "blaze.login.password.input")
	private QAFExtendedWebElement loginPasswordInput;

	@FindBy(locator = "blaze.login.login.btn")
	private QAFExtendedWebElement loginLoginBtn;

	@FindBy(locator = "blaze.home.welcome.text")
	private QAFExtendedWebElement welcomeText;

	@FindBy(locator = "blaze.product.addtocart.btn")
	private QAFExtendedWebElement addToCartBtn;

	@FindBy(locator = "blaze.cart.product.title")
	private List<QAFExtendedWebElement> cartProductNameList;

	public void selectHeaderOptions(String header) {
		QAFExtendedWebElement headerOption = new QAFExtendedWebElement(String.format(props.getString("blaze.home.header.option"), header));
		headerOption.click();
	}

	public void verifyContactPage() {
		ReportUtils.logAssert("Verify Contact Email field Displayed.", contactEmailInput.isDisplayed());
	}

	public void enterAndSubmitContactDetails(String email, String name, String message) {
		contactEmailInput.sendKeys(email);
		contactNameInput.sendKeys(name);
		contactMessageInput.sendKeys(message);
		contactSendBtn.click();
	}

	public void verifyLoginPage() {
		ReportUtils.logAssert("Verify Login Username field Displayed.", loginUsernameInput.isDisplayed());
	}

	public void loginWithCredentials(String un, String password) {
		loginUsernameInput.sendKeys(un);
		loginPasswordInput.sendKeys(password);
		loginLoginBtn.click();
	}

	public void verifyUserLoginSuccessful(String un) {
		ReportUtils.logAssert("Verify Login Successful.", welcomeText.getText().equals("Welcome "+un));
	}

	public void addiPhoneToCart() {
		this.selectCategory("Phones");
		//Another way of creating web element object
		QAFExtendedWebElement iphone = new QAFExtendedWebElement(By.xpath("(//a[contains(text(),'Iphone')])[1]"));
		iphone.click();
		addToCartBtn.click();
		if(DriverUtils.isAndroid()) {
			DeviceUtils.assertVisualText("Product added");
			Map<String, Object> params = new HashMap<>();
			params.put("label", "OK");
			driver.executeScript("mobile:button-text:click", params);
		}else if(DriverUtils.isIOS()) {
			String context = DeviceUtils.getCurrentContext();
			DeviceUtils.switchToContext("NATIVE_APP");
			boolean isAlertPresent = new QAFExtendedWebElement(By.name("Product added")).isDisplayed();
			ReportUtils.logAssert("Alert present", isAlertPresent);
			new QAFExtendedWebElement(By.name("Close")).click();
			DeviceUtils.switchToContext(context);
		}else {
			driver.getAlert().accept();
		}
	}

	private void selectCategory(String category) {
		QAFExtendedWebElement catOptions = new QAFExtendedWebElement(String.format(props.getString("blaze.home.category.options"), category));
		catOptions.click();
	}

	public void verifyiPhoneIsAddedtoCart() {
		this.selectHeaderOptions("Cart");
		new QAFExtendedWebElement("blaze.cart.product.title").isDisplayed();
		String latestProduct = cartProductNameList.get(cartProductNameList.size()-1).getText().toLowerCase();
		ReportUtils.logAssert("Verify iphone added to cart.", latestProduct.contains("iphone"));

	}

	public void verifyContactInfoSent() {
		if(DriverUtils.isAndroid()) {
			DeviceUtils.assertVisualText("Thanks for the message!!");
			Map<String, Object> params = new HashMap<>();
			params.put("label", "OK");
			driver.executeScript("mobile:button-text:click", params);
		}else if(DriverUtils.isIOS()) {
			String context = DeviceUtils.getCurrentContext();
			DeviceUtils.switchToContext("NATIVE_APP");
			boolean isAlertPresent = new QAFExtendedWebElement(By.name("Thanks for the message!!")).isDisplayed();
			ReportUtils.logAssert("Alert present", isAlertPresent);
			new QAFExtendedWebElement(By.name("Close")).click();
			DeviceUtils.switchToContext(context);
		}
		else {
			driver.getAlert().accept();
		}
	}
	
	public void verifyHeaderOptions(List<String> headers) {
		for (String header : headers) {
			QAFExtendedWebElement headerOption = new QAFExtendedWebElement(String.format(props.getString("blaze.home.header.option"), header));
			ReportUtils.logAssert("Verify Header Present - "+header, headerOption.isDisplayed());
		}
	}

}
