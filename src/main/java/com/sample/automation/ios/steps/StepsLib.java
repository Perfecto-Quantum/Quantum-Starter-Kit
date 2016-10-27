/**
 * 
 */
package com.sample.automation.ios.steps;

import static com.qmetry.qaf.automation.step.CommonStep.click;
import static com.qmetry.qaf.automation.step.CommonStep.verifyText;

import com.qmetry.qaf.automation.step.QAFTestStep;
/**
 * @author chirag.jayswal
 *
 */
public class StepsLib {

	
//	//@QAFTestStep(description = "add {0} into {1}")
//	public void addInto(long l1, long l2) {
//		sendKeys(String.valueOf(l1), "input.box");
//		click("btn.plus");
//		sendKeys(String.valueOf(l2), "input.box");
//		click("btn.equal");
//	}
//	
	@QAFTestStep(description = "add {0} into {1}")
	public void addInto_ios(long l1, long l2) {
		click("name="+String.valueOf(l1));
		click("btn.plus");
		click("name="+String.valueOf(l2));
		click("btn.equal");
	}
	

	@QAFTestStep(description = "result should be {0}")
	public void resultShouldBe(long l1) {
		verifyText("input.box", String.valueOf(l1));
	}
}
