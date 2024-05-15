Feature: ListToArrayAcceptanceTests
  This feature converts the list to an array with the same elements in the same order.

  Scenario: Convert a list with one element
    Given I have elements with the following values in my list:
    | 1.1 |
    When I convert the list to an array
    Then the array should contain the same elements in the same order

  Scenario: Convert a list with three elements
    Given I have elements with the following values in my list:
      | 1.1 |
      | 2.0 |
      | 3.6 |
    When I convert the list to an array
    Then the array should contain the same elements in the same order
