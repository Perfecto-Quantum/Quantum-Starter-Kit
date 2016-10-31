/**
 * 
 */
package com.sample.automation.common.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.util.StringUtil;
import cucumber.api.java.en.Then;

import static com.qmetry.qaf.automation.step.CommonStep.click;
/**
 * @author chirag.jayswal
 *
 */
@QAFTestStepProvider
public class StepsLib {

	@QAFTestStep(description = "open calculator")
	public static void openNativeApplication() {
		//will be taken care by listener....
	}
	
	
	@QAFTestStep(description = "add {0} into {1}")
	public void addInto(long l1, long l2) {
		click("name="+String.valueOf(l1));
		click("btn.plus");
		click("name="+String.valueOf(l2));
		click("btn.equal");
		
	}

	@Then("I switch to frame \"(.*?)\"")
	public static void switchToFrame(String nameOrIndex) {
		if (StringUtil.isNumeric(nameOrIndex)) {
			int index = Integer.parseInt(nameOrIndex);
			new WebDriverTestBase().getDriver().switchTo().frame(index);
		} else {
			new WebDriverTestBase().getDriver().switchTo().frame(nameOrIndex);
		}
	}

	@Then("I switch to \"(.*?)\" frame by element")
	public static void switchToFrameByElement(String loc) {
		new WebDriverTestBase().getDriver().switchTo().frame(new QAFExtendedWebElement(loc));
	}
	

}
