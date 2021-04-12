@first
Feature: Validate Quantum Installation

 Scenario: open Wikipedia
    Given I open browser to webpage "https://www.wikipedia.org/"
    Then I must see text "The Free Encyclopedia"

