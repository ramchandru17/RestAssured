Feature: Get Model Information

  Scenario Outline: Verify different Model details for the specified brands
    Given I execute GET operation to retrieve Model information for the below <Locale> and <Brand>

    Examples:
      | Locale | Brand |
      | de-DE  | BMW   |
      | de-DE  | Audi  |
      | es-ES  | MINI  |