Feature: Bookcart Application test

Background:
    And user Clicks login button

  Scenario: Login should be not be successful
    And user enters user name as "jeeva@1"
    And user enters Password as "Ramujee@9"
    When user click on the login button
    But Login shoud not be success

  Scenario: Login should be successful
    And user enters user name as "jeeva@19"
    And user enters Password as "Ramujee@19"
    When user click on the login button
    Then Login shoud be success
