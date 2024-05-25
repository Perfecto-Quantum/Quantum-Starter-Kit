package com.quantum.steps;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.quantum.pages.ExpenseTrackerHomePage;
import com.quantum.pages.ExpenseTrackerLoginPage;
import com.quantum.utils.DriverUtils;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@QAFTestStepProvider
public class ExpenseTrackerSteps {

	

	@Then("I should see expense tracker login screen")
	public void verifyExpenseTrackerLogin() {
		new ExpenseTrackerLoginPage().verifyExpenseTrackerLoginScreen();
	}

	@Then("I should see expense tracker Native login screen")
	public void verifyExpenseTrackerNativeLogin() throws InterruptedException {
		new ExpenseTrackerLoginPage().verifyExpenseTrackerNativeLoginScreen();
	}

	@When("I enter \"(.*?)\" and \"(.*?)\" in native login screen")
	public void iEnterLoginDetilsInNativeLoginScreen(String email, String password) {
		new ExpenseTrackerLoginPage().loginNative(email, password);
	}

	@Then("I should see expense tracker home screen")
	public void iShouldSeeExpenseTrackerHomeScreen() {
		new ExpenseTrackerHomePage().verifyHomeScreen();
	}

	@When("I enter expense details and save")
	public void iEnterExpenseDetailsAndSave() {
		new ExpenseTrackerHomePage().enterExpenseDetails();
	}

	@Then("I should see error popup")
	public void iShouldSeeErrorPopup() {
		new ExpenseTrackerHomePage().verifyPopupText();
	}
}
