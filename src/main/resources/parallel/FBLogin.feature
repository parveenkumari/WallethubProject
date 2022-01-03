@tag
Feature: Facebook Feature
  I want to post message on facebook

 
@FacebookLoginTest
  Scenario Outline: Posting status message on Facebook
    Given User navigate to facebook "https://www.facebook.com"
    When User enter "<username>" and "<password>" on login page
    And User click on Log in button
    Then User validate title of page 
    And User post status message "Hello World"

    Examples: 
      | username | password |
      | kumariparveen41@gmail.com | Pramod12345|
   
