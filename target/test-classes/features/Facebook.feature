@facebook
Feature: To smoke test facebook account

Background:
  When user open facebook url
  And user enters emailId
  And user enters password
  Then user click sign-in button and able to sign-in


 Scenario: print title
 Then check title


