Feature: Get Brands Information

  Scenario Outline: Verify different Car Manufacturer for specified locale
    Given I execute GET operation to retrieve Manufacturer Brand information for the below <Locale>

    Examples:
      | Locale |
      | de-DE  |
      | fr-FR  |
      | es-ES  |