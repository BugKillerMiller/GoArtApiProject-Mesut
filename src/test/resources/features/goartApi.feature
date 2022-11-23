@full
Feature: Roof Stacks API Test Automation

  @chosen
   Scenario Outline: Verify new user should create successfully - POST
    Given User send POST request with the body "<firstName>" "<lastName>" "<username>" "<password>"
    Then verify status code as 200
    Then verify user id created as response body

    Examples:
      | firstName | lastName | username  | password  |
      | Mesut     | Ozturk   | Mesut35   | 123456Aa* |
      | Cemil     | Sever    | Cemil3535 | Cemil35!  |


  Scenario Outline: Verify new user should not create successfully without valid restrictions
    Given User send POST request with the body "<firstName>" "<lastName>" "<username>" "<password>"
    Then verify status code as 200

    Examples:
      | firstName                                             | lastName                                              | username      | password  |
      | MZ                                                    | Ozturk                                                | Mesut35       | 123456Aa* |
      | MZkunldgsycbnifjukkkkdbdbsbsbbbbbsjsloursamziaysyeiii | Ozturk                                                | Mesut35       | 123456Aa* |
      | o                                                     | ku                                                    | Mesut35       | 123456Aa* |
      | Ozturk                                                | MZkunldgsycbnifjukkkkdbdbsbsbbbbbsjsloursamziaysyeiii | Mesut35       | 123456Aa* |
      | MZ35$                                                 | Ozturk                                                | Mesut35       | 123456Aa* |
      | Mesut                                                 | Ozturk35&                                             | Mesut35       | 123456Aa* |
      | Mesut                                                 | Ozturk                                                | Mst           | 123456Aa* |
      | Mesut                                                 | Ozturk                                                | MstOzturk3535 | 123456Aa* |

  Scenario: To retrieve all users
    Given the user send GET request
    Then verify status code as 200
    And verifies the content type is "application/json; charset=utf-8"


  Scenario: Verify gets the user successfully with user id - GET
    Given User send GET request with id "c4f6c088-f91b-494e-b7f0-a08f48df3180"
    Then verify status code as 200
    Then verify the users listed as expected


  Scenario: Verify  the user removed from list successfully with user id - DELETE
    Given User send DELETE request with id "c4f6c088-f91b-494e-b7f0-a08f48df3180"
    Then verify status code as 200
    Then verify the user remove from users list


  Scenario Outline: Verify updates user activity by specified user Id- PATCH
    Given User send PATCH request to this endpoint "/c4f6c088-f91b-494e-b7f0-a08f48df3180" with "<isActive>"
    Then verify status code as 200

    Examples:
      | isActive |
      | true     |
      | false    |


  Scenario Outline: Verify the user firstName and lastName should update successfully - PUT
    Given User send PUT request to this endpoint "/c4f6c088-f91b-494e-b7f0-a08f48df3180" with "<firstName>" "<lastName>"
    Then verify status code as 200
#   Then verify users data updated as expected

    Examples:
      | firstName | lastName |
      | Mesut     | Ozturk   |
      | Cemil     | Sever    |




