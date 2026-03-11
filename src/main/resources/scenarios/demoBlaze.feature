@Web @DemoBlaze
Feature: Demo Blaze

Background:
	Given I am on Demo Blaze page
@WebDDcsv @loginDemoBlaze
 Scenario Outline: Demo Blaze Lgin CSV Data
	
	When I click on "Log in" header option
	Then I verify login page is opened
	When I login with "<username>" and "<password>"
	Then I verify user "<username>" able to Login successfully

    #for csv, txt, xls files specify datafile location
#Examples: {'datafile' : 'src/main/resources/data/demoBlazeLogin.csv'}
Examples: {'datafile' : 'src/main/resources/data/testData.xls', 'sheetname':'loginSheet'}

@addToCart
Scenario: Demo Blaze place order
	When I select an iPhone and add to cart
	Then I verify iPhone is added to cart
	
@WebDD @contactDemoBlaze
 Scenario Outline: Demo Blaze Contact US - Examples
	When I click on "Contact" header option
	Then I verify Contact page is opened
	When I submit contact details "<email>" "<name>" "<message>"
	Then I verify contact information sent
	Examples:
      | email                   | name                | message|
      |testquantum1@perforce.com| Quantum Starter Kit |This is a quantum test|
      |testquantum2@perforce.com|  Quantum Starter Kit |This is a quantum test|
      
@WebContactUs
 Scenario: Demo Blaze Contact US
	When I click on "Contact" header option
	Then I verify Contact page is opened
	When I submit contact details "ps@perforce.com" "Quantum Starter Kit" "Quantum Test"
	Then I verify contact information sent
	
@WebHeaderList
 Scenario: Demo Blaze Header Options
	Then it should have following header options:
      | Contact |
      | About us|
      |  Cart   |
      