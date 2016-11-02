@Demo
Feature: Hello World

  @Smoke @Pass
  Scenario: Say Hi
    Given I have a hello app with "${qmetry.fw}"
    When I ask it to say hi
    Then it should answer with "QMetry Automation Framework World"

  @P1 @Skip
  Scenario: Say hello should skip
    Given I have a hello app with "${qmetry.fw}"
    When I ask it to say Hello
    Then it should answer with "QMetry Automation Framework World"

  @P1 @FailOne
  Scenario Outline: Using Gherkin examples table
    Given I have a hello app with "<app>"
    When I ask it to say hi
    Then it should answer with "<message>"

    Examples:
      | app   | message     | recId |
      | Test  | Test, World | REC-1 |
      | Hello | Hello World | REC-2 |

  @P1 @Pass @dd
  Scenario Outline: Using QAF data-provider
    Given I have a hello app with "<app>"
    When I ask it to say hi
    Then it should answer with "<message>"

    Examples:{'key' : 'demo.helloworld.dataset'}
      | | |