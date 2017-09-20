Feature: Creation business trip

@smokeTest
Scenario Outline: Creation business trip
    Given user navigate to Business Trip list page "<base_url>"
    When click New Business Trip
    And fill mandatory fields "<estimate_budget>"
    And click save button
    Then Business Trip is saved
    Examples:
        | base_url |estimate_budget|
        |https://tst2.epm-ctc.projects.epam.com/|200000|
