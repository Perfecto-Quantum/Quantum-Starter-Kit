@MobileAI 
Feature: Perfecto AI commands

Scenario: Login 
    When I perform AI User-Action with prompt: "Open https://www.demoblaze.com/index.html"
    When I perform AI User-Action with prompt: "Login with username <username> and password ${password}"

 Scenario: Launch Settings with AI Commands
	When I perform AI User-Action with prompt: "Open Settings application"
	And I perform AI Validation with prompt: "Verify Settings app opened"
	When I perform AI User-Action with prompt: "Go to Wifi in Settings"
	And I perform AI Validation with prompt: "Verify this device is connected to wifi"
	
	
@aiCommands
 Scenario: Launch Settings with AI Commands with reasoning
	When I perform AI User-Action with prompt: "Open Settings application" and reasoning
	And I perform AI Validation with prompt: "Verify Settings app opened"
	When I perform AI User-Action with prompt: "Go to Wifi in Settings" and reasoning
	And I perform AI Validation with prompt: "Verify this device is connected to wifi"
	
	@aiDemoDDT
 Scenario Outline: Launch Settings with AI Commands with reasoning
	When I perform AI User-Action with prompt: "Open https://www.demoblaze.com/index.html"
	And I perform AI Validation with prompt: "Verify Home page opened"
	When I perform AI User-Action with prompt: "Login with username <username> and password ${password}"
	And I perform AI Validation with prompt: "Is login successful with Welcome ${username} text?"
Examples:
|username|password|
|admin|admin|