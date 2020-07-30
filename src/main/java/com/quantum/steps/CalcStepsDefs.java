/**
 * 
 */
package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.quantum.pages.CalcPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@QAFTestStepProvider
public class CalcStepsDefs {

	CalcPage calcPage = new CalcPage();

	@When("clear Calculator")
	public void clearCalculator() {
		calcPage.clear();

	}

	@When("add \"(.+)\" to \"(.+)\"")
	public void addInto(long l1, long l2) {
		calcPage.add(l1, l2);
	}

	@Then("result should be \"(.+)\"")
	public void resultShouldBe(long l1) {
		calcPage.verifyResult(l1);
	}

}
