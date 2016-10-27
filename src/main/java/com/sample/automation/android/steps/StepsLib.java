/**
 * 
 */
package com.sample.automation.android.steps;

import static com.qmetry.qaf.automation.step.CommonStep.verifyText;

import com.qmetry.qaf.automation.step.QAFTestStep;
/**
 * @author chirag.jayswal
 *
 */
public class StepsLib {
	

	@QAFTestStep(description = "result should be {0}")
	public void resultShouldBe(long l1) {
		verifyText("input.box", "in:"+String.valueOf(l1));
	}
}
