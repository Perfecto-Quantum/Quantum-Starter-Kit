/**
 * 
 */
package com.qmetry.qaf.examples;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

/**
 * @author chiragjayswal
 *
 */
public class Suite1 extends WebDriverTestCase {

	@Test()
	public void tc1(){
		sayHello("someone");
	}
	
	@QAFTestStep(description="say hello to {person}")
	void sayHello(String to){
		//do something
	}
}
