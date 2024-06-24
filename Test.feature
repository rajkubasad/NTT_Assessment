@tag
Feature: Verify live cricket score updates on ESPN Cricinfo

Scenario: Check live score updates for a cricket match
    Given I am on the ESPN Cricinfo homepage
    When I view the live cricket scores
    Then the score should update dynamically every few seconds  