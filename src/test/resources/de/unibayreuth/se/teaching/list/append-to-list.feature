Feature: AppendToListAcceptanceTests
  This feature appends list elements by value.

  Scenario: Append one element by value
    Given an empty list
    When I append an element with value 0.4
    Then the list should contain 1 element
    And the list should contain that element

  Scenario: Append multiple elements to an empty list
    Given an empty list
    When I append an element with value 0.2
    And I append an element with value 0.3
    Then the list should contain 2 elements
    And the list should contain the elements in the following order:
      | 0.2 |
      | 0.3 |
