package com.perfectomobile.quantum.mock;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * Created by mitchellw on 10/17/2016.
 */
public class MockSteps {
    MockTestBase mock;
    public MockSteps(MockTestBase mock) {
        this.mock = mock;
    }

    @Given("^I mock open browser to webpage \"([^\"]*)\"$")
    public void i_open_browser_to_webpage(String arg1) throws Throwable {
        mock.getDriver().get(arg1);
    }

    @When("^I go to menu page$")
    public void i_go_to_menu_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        mock.getElement("test").click();
    }
}
