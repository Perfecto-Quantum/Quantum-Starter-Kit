@Web
Feature: Google Search

  @WebSearch
  Scenario: Search Quantum
    Given I am on Google Search Page
    When I search for "quantum perfecto"
    Then it should have "Quantum Framework" in search results

  @WebResultsList
  Scenario: Search Quantum with results
    Given I am on Google Search Page
    When I search for "perfecto quantum starter kit"
    Then it should have following search results:
      | Quantum-Starter-Kit |
      | Project-Quantum |

  @WebDD
  Scenario Outline: Search Keyword Inline Data
    Given I am on Google Search Page
    When I search for "<searchKey>"
    Then it should have "<searchResult>" in search results

    Examples:
      | recId | recDescription 	| searchKey               | searchResult                  |
      | 1     | First Data Set	| quantum perfecto        | Quantum Framework |
      | 2     | Second Data Set 	|perfecto quantum starter kit | GitHub |

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
    
