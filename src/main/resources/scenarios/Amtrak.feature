 @amtrak
Feature: Amtrak test 
	@amtrak
  Scenario: amtrak - find station  
   	Given I open browser to webpage "http://amtrak.com"
		Then I click on "train.status"
    Then I click on "find.Station"
    Then I click on "Station.abl"
    Then I enter "45" to "bus.number"
    Then I click on "status.button"
      
    @amtrak
     Scenario: amtrak - buy ticket  
  	Given I open browser to webpage "http://amtrak.com"
  	Then I wait 20 seconds for "buy.ticket" to appear
 		Then I click on "buy.ticket"
     Then I enter "NYP" to "ticket.from"
     Then I enter "BBY" to "ticket.to"
     Then I scroll down
     Then I click on "find.train"
     Then I wait for "2" seconds
     Then I click on "continue"
     Then I must see text "Departure"
  	 Then I should see text "Departure"

    @amtrak
		 Scenario Outline: Amtrak-DT
	 	Given I open browser to webpage "http://amtrak.com"
		Then I click on "train.status"
    Then I click on "find.Station"
    Then I click on "Station.abl"
    Then I enter "<number>" to "bus.number"
    Then I click on "status.button"
 	Examples:
 		| number |  
 		| 20 | 
 		| 30 |