package com.quantum.steps;

import java.time.Duration;
import java.util.List;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.quantum.pages.DemoBlazeHomePage;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.DriverUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@QAFTestStepProvider
public class DemoBlazeStepsDefs {

	DemoBlazeHomePage demoHome = new DemoBlazeHomePage();

	@Given("I am on Demo Blaze page")
	public void launchDemoBlazeWebApp() {
		DeviceUtils.getQAFDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		if(!DriverUtils.isAndroid() && !DriverUtils.isIOS()) {
			DeviceUtils.getQAFDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		}


		System.out.println(DriverUtils.getDriver().getCapabilities().getCapability("browserName"));
		System.out.println(DriverUtils.getDriver().getCapabilities().getBrowserName());

		new WebDriverTestBase().getDriver().get("https://www.demoblaze.com/");
	}

	@When("I click on \"([^\"]*)\" header option")
	public void clickOnTheHeaderOption(String header) {
		demoHome.selectHeaderOptions(header);
	}

	@Then("I verify Contact page is opened")
	public void verifyContactPageOpened() {
		demoHome.verifyContactPage();
	}


	@When("I submit contact details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"")
	public void submitContactDetails(String email, String name, String message) {
		demoHome.enterAndSubmitContactDetails(email, name, message);
	}

	@Then("I verify login page is opened")
	public void verifyLoginPageDisplayed() {
		demoHome.verifyLoginPage();
	}

	@When("I login with \"([^\"]*)\" and \"([^\"]*)\"")
	public void loginWithCreds(String username, String password) {
		demoHome.loginWithCredentials(username, password);
	}

	@Then("I verify user \"([^\"]*)\" able to Login successfully")
	public void verifyLoginSucess(String username) {
		demoHome.verifyUserLoginSuccessful(username);
	}

	@When("I select an iPhone and add to cart")
	public void iaddiPhoneToCartInDemoBlaze() {
		demoHome.addiPhoneToCart();
	}

	@Then("I verify iPhone is added to cart")
	public void verifyiPhoneAddedToCart() {
		demoHome.verifyiPhoneIsAddedtoCart();
	}

	@Then("I verify contact information sent")
	public void verifyContactUsAlert() {
		demoHome.verifyContactInfoSent();
	}
	
	@Then("^it should have following header options:$")
	public void it_should_have_header_options(List<String> headers) {
		demoHome.verifyHeaderOptions(headers);
	}
}
