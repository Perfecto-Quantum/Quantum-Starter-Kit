@Webservice 
Feature: Example web service testing using QAF and Gherkin 

Scenario: Basic example 
	Given Google maps api "http://maps.googleapis.com" 
	When request for location "Ahemedabad" 
	Then it should have response "OK" 
	And the response should have location "Ahmedabad, Gujarat, India" 
