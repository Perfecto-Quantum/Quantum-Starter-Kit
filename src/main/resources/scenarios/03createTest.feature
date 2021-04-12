@locators
Feature: Write test case as Scenario

Background: open Wikipedia
    Given I open browser to webpage "https://www.wikipedia.org/"
	Then I must see text "The Free Encyclopedia"

Scenario: search for term with objects file
 	Then I enter "Perforce" to "wiki.search"
 	Then I click on "wiki.search.btn"
 	Then I must see text "developer of software"