Feature: Login
  user login into application


  Scenario: Successful login
    Given user in the login page
    And user input valid credentials
    Then user sucessfully login into the application


  Scenario: Loan application page
    Given user in the loan home page
    And user selects the loan menu
    Then loan application page is displayed