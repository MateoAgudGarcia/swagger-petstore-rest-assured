Feature: Request Swagger

  Scenario Outline: Create a pet
    Given the fact that the dog "<name>" must be created with id "<id>"
    When the dog "<name>" with id "<id>" has been created correctly
    And the data of dog with id "<id>" with a new name "<new_name>" has been updated successfully
    Then the dog with "<id>" should be deleted without any problems
    Examples:
      | name  | new_name | id  |
      | Ralph | Red      | 300 |
      | Tedd  | Clifford | 999 |