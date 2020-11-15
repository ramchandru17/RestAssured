Feature: Get Brands Information
  Verify different Brands for the specified locale

  Scenario: Verify different Car Manufacturer for specified locale
    Given I execute GET operation to retrieve Manufacturer Brand information for the below locale
      | Locale |
      | de-DE  |
#      | fr-FR  |
#      | es_ES  |