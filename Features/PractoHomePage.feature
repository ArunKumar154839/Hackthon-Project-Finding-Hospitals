Feature: Selecting Location

  @smoke @regression
  Scenario: Selecting Location in SearchBar
    Given the user navigate PractoHomePage
    #When User Click on Location_Search_bar
    When User Clear LocationSearchbar
    And User Select required Location
    And Location is Selected and user sholud select Doctors
    And user should navigate to Category page
    When the user selects the Experience filter
    And the user clicks on All filters
    And the user selects the Fees filter
    And the user selects the Availability filter
    And the user selects one sorting option
    Then the user capture first  details