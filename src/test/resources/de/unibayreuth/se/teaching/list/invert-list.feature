Feature: InvertListAcceptanceTests
  This feature showcases how one can write acceptance tests for features that are not yet implemented.
  Here: Inversion of the list.

  Scenario: Invert the list
    Given I have elements with the following values in my list:
      | 1.1 |
      | 2.3 |
      | 4.1 |
    When I invert the list
    Then the list should contain the elements in the following order:
      | 4.1 |
      | 2.3 |
      | 1.1 |
