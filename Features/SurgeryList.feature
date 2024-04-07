Feature: Extracting Surgery List

  @regression
  Scenario: Extracting and Storing Surgery List
    Given the user navigates to the surgerylistpackage by clicking on the surgeries link
    When the user stores all surgeries in a list
    When the user navigate to health and wealth Page
    When user give valid name
    When user give valid Organization name
    When user give Valid PhoneNumber
    When user give Invalid MailId
    When user select required Oraganization Size
    When user select Interested In
    When user Validate Schedule a demo button is disable
    When user give valid MailId
    When user Validate Schedule a demo button is able
    #Then ThankYou Message is displayed
