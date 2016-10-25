package com.qmetry.qaf.examples.steps.cucumber;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;
import static com.qmetry.qaf.automation.core.QAFTestBase.pause;
import static com.qmetry.qaf.automation.util.Validator.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import org.apache.commons.lang.math.RandomUtils;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.util.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@QAFTestStepProvider
public class HelloStepdefs {

	@Given("^I have a hello app with \"([^\"]*)\"$")
	public void I_have_a_hello_app_with(String greeting) {
		getBundle().setProperty("greeting", greeting);
		Reporter.log(greeting);
	}
	@When("^I ask it to say hi$")
	public void I_ask_it_to_say_hi() {
		int i=200*(RandomUtils.nextInt(25)+3);
		pause(i);// mimic doing some processing....
		System.out.println("When I_ask_it_to_say_hi");
	}

	@Then("^it should answer with \"([^\"]*)\"$")
	public void it_should_answer_with(String expectedHi) {
		assertThat(expectedHi, equalToIgnoringCase(getBundle().getString("greeting") + " World"));
	}
}
