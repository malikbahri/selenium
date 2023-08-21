
@tag
Feature: Recherche google
  Je veux effectuer une recherche via google

  @tag1
  Scenario: recherche pays
    Given ouvrir navigateur1
    And ouvrir URL google "https://www.google.com/"
    When saisir le mot "Tunisie"
    And cliquer sur entre
    Then verifier que la phrase contient le mot "resultat"

 
