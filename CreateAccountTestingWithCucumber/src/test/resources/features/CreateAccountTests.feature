@register
Feature: As user/buyer, I want to register


  @test001
  Scenario: Validate if user can be register with email already exist
    Given that I open the Amazon Website: "https://www.amazon.com.br"
    When click on the Register Btn
    And click on the Create An Account
    And Fill the Name with "Guilherme Silva"
    And Fill the Email "gui@hotmail.com"
    And Fill the Password with "123456"
    And Confirm the password with "123456"
    And click on  Continue
    Then an error message must be displayed informing about the Email "gui@hotmail.com" already used