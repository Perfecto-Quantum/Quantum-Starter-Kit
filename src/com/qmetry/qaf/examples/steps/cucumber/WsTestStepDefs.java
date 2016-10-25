package com.qmetry.qaf.examples.steps.cucumber;

import static com.qmetry.qaf.automation.util.Validator.assertThat;
import static org.xmlmatchers.transform.XmlConverters.the;
import static org.xmlmatchers.xpath.HasXPath.hasXPath;
import static org.xmlmatchers.xpath.XpathReturnType.returningAString;
import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

import javax.ws.rs.core.MultivaluedMap;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ws.rest.RestTestBase;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.ClientResponse.Status;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@QAFTestStepProvider
public class WsTestStepDefs {
	RestTestBase restTestBase = new RestTestBase();

	@Given("^Google maps api \"([^\"]*)\"$")
	public void Google_maps_api(String api) throws Throwable {
		getBundle().setProperty("api", api);
	}
	@When("^request for location \"([^\"]*)\"$")
	public void request_for_location(String address) throws Throwable {
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("address", address);
		params.add("sensor", "false");

		restTestBase.getWebResource(getBundle().getString("api"),"/maps/api/geocode/xml").queryParams(params)
				.get(ClientResponse.class);
	}
	
	@Then("^it should have response \"([^\"]*)\"$")
	public void it_should_have_response_with_status(String status) throws Throwable {
		assertThat(restTestBase.getResponse().getStatus(),
				Matchers.equalTo(Status.valueOf(status)));
	}
	@Then("^the response should have location \"([^\"]*)\"$")
	public void the_response_should_have_location(String address) throws Throwable {
		assertThat(
				the(restTestBase.getResponse().getMessageBody()),
				hasXPath("//result//formatted_address", returningAString(),
						Matchers.containsString(address)));

	}
}
