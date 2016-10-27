/**
 * 
 */
package com.sample.automation.common.steps;

import static com.qmetry.qaf.automation.step.CommonStep.click;

import com.qmetry.qaf.automation.step.QAFTestStep;
/**
 * @author chirag.jayswal
 *
 */
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
	

}
