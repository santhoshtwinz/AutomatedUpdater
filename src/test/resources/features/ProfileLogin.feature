#Author: santhoshkumarsktn@gmail.com
Feature: Job Seeker login

  Scenario Outline: This scenario is to validate whether the user is able to login to Naukri with valid credentials
    Given User navigates to Naukri webpage
  #  When the user login and enters valid <username> and <password>
  #  Then the user should be logged in and he should be able to see his profile

    Examples: 
      | username                  | password      |
      | santhosh98@protonmail.com | Automation@01 |
