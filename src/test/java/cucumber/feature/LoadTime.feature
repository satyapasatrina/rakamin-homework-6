Feature: ResponseTime Acceptability

  Scenario Outline: Ensure Pages area loaded within acceptable time
    Given user is on saucedemo login page for LoadTime
    When user input "<username>" and "<password>"
    And start timer
    And user click login for loadtime
    And stop timer
    Then total load time after login is under <acceptable_response_time_milis>
    Examples:
      | username | password | acceptable_response_time_milis |
      | standard_user | secret_sauce | 3000              |
      | performance_glitch_user | secret_sauce | 3000    |
