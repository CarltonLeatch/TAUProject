Feature: Is Game well created?
  Game should have valid parameters


  Scenario: Game can't be null
    Given name is Test
    Given Id is 1
    Given CompanyName is Company


    When We create object
    Then It shouldn't be null
