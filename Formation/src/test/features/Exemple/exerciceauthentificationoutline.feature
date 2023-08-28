@tag
Feature: Authentififcation sur site orange hmr
  En tant que utilisateur je veux entrer mes identifiants pour accéder à la page profil

  @tag2
  Scenario Outline: Athentification de plusieurs utlisateurs
    Given ouvrir Navigateur4
    And accéder à url du site "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When saisir le username de utilisateur "<name>"
    And saisir le mdp de utlisateur "<mdp>"
    And cliquer sur le boutton se connnecter
    Then vérifier le résultat obtenu "<message>"

    Examples: 
      | name    | mdp      | message             |
      | malek   |     1234 | Invalid credentials |
      | mohamed |     5678 | Invalid credentials |
      | mounir  |     9123 | Invalid credentials |
      | Admin   | admin123 | Paul Collings       |
