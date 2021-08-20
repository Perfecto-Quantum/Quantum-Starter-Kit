@Web
Feature: Google Search

  @WebSearch
  Scenario: Search Quantum
    Given I am on Google Search Page
    When I search for "perfecto mobile quantum"
    Then it should have "perfecto" in search results
    Then I am on Google Search Page

  @WebResultsList
  Scenario: Search Quantum with results
    Given I am on Google Search Page
    When I search for "perfecto mobile quantum"
    Then it should have following search results:
      | perfecto |
      | Quantum |

  @WebDD
  Scenario Outline: Search Keyword Inline Data
    Given I am on Google Search Page
    When I search for "<searchKey>"
    Then it should have "<searchResult>" in search results

    Examples:
      | recId | recDescription 	| searchKey               | searchResult                  |
      | 1     | First Data Set	| perfecto mobile quantum       | Quantum |
      | 2     | Second Data Set 	|perfecto mobile quantum| perfecto |

  @WebDDxml
  Scenario Outline: Search Keyword XML Data
    Given I am on Google Search Page
    When I search for "<searchKey>"
    Then it should have "<searchResult>" in search results

    #xml file must be in directory listed in env.resources property
    Examples: {'key' : 'demo.websearch.dataset'}

  @WebDDcsv
  Scenario Outline: Search Keyword CSV Data
    Given I am on Google Search Page
    When I search for "<searchKey>"
    Then it should have "<searchResult>" in search results

    #for csv, txt, xls files specify datafile location
    Examples: {'datafile' : 'src/main/resources/data/testData.csv'}
    
  @TestDataTable
  Scenario Outline: Search Quantum data table
    Given I am on Google Search Page
    And I have the following books in the store:
    | title                                | author      |
    | The Lion, the Witch and the Wardrobe | C.S. Lewis  |
    | In the Garden of Beasts              | Erik Larson |
    When I search for "perfecto mobile quantum"
    Then it should have "perfecto" in search results
     Examples:
      | recId | recDescription 	| searchKey               | searchResult                  |
      | 1     | First Data Set	| perfecto mobile quantum        | perfecto |
