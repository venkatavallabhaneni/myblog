#Author: venkata vallabhaneni
Feature: As an administrator i want to create a new house hold product

  Scenario Outline: create a house hold product using appropriate name
    Given product name <name>
    When I call the service create product
    Then I should get response with HTTP tatus code <status>
    And the response should contain the <message>

    Examples: 
      | name    | status | message   |
      | Orrange |    200 | Orrange   |
      | null    |    500 | null |
