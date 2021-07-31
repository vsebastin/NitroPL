Feature: payment
  user want to make registration


  Scenario: successful registration
    Given user in the home page
    And make registration
      |firstName|lastName|Address|city|state|zipCode|phone|ssn|username|password|confirmPassword|
      |test|one|14,Noth stret|chennai|Tamilnadu|600119|756724365|9809809809|test|test123|test123|
    Then verify registration is successful
