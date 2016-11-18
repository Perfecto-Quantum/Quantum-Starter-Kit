@Web
Feature: Google Search

  @WebSearch
  Scenario: Search QMetry
    Given I am on Google Search Page
    When I search for "git qmetry"
    Then it should have "QMetry Automation Framework" in search results

  @WebResultsList
  Scenario: Search QMetry with results
    Given I am on Google Search Page
    When I search for "QAFTestStep"
    Then it should have following search results:
      | QMetry Automation Framework |
      | QAFTestStep                 |

  @WebDD
  Scenario Outline: Search Keyword Inline Data
    Given I am on Google Search Page
    When I search for "<searchKey>"
    Then it should have "<searchResult>" in search results

    Examples:
      | recId         | searchKey         | searchResult                          |
      | StackOverflow | QAF StackOverflow | using QAF                             |
      | ISFW          | Selenium ISFW     | InfoStretch Test Automation Framework |

  @WebDDxml
  Scenario Outline: Search Keyword XML Data
    Given I am on Google Search Page
    When I search for "<searchKey>"
    Then it should have "<searchResult>" in search results

    #xml file must be in directory listed in env.resources property
    Examples:{'key' : 'demo.websearch.dataset'}

  @WebDDcsv
  Scenario Outline: Search Keyword CSV Data
    Given I am on Google Search Page
    When I search for "<searchKey>"
    Then it should have "<searchResult>" in search results

    #for csv, txt, xls files specify datafile location
    Examples:{'datafile' : 'src/main/resources/data/testData.csv'}
    
