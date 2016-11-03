/**
 * 
 */
package com.quantum.steps.android;

import com.qmetry.qaf.automation.step.QAFTestStep;

import static com.qmetry.qaf.automation.step.CommonStep.verifyText;
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
