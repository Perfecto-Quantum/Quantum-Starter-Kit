@sampleTestCase
Feature: Write test case as Scenario

Background: open Wikipedia
    Given I open browser to webpage "https://www.wikipedia.org/"
    Then I must see text "The Free Encyclopedia"

Scenario: search for term
 	Then I enter "Perforce" to "//*[@id='searchInput']"
 	Then I click on "//*[@id="search-form"]/fieldset/button"
 	Then I must see text "developer of software"



