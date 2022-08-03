@BR_POC
Feature: Arity Bitrise POC test scenario
  #Sample Test Scenario Description

 @ArityBitrisePOC
Scenario: Open test app and click both buttons to ensure screen changes on click
  Given I start application by id "com.tts.aritytestapp"
  Then I should see app first fragment screen with Hello first fragment text and NEXT button
  When I click the NEXT button
  Then I should see second fragment screen with PREVIOUS button
  When I click the PREVIOUS button
#  Then I should see app first fragment screen with Hello first fragment text and NEXT button
	