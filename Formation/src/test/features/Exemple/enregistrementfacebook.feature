@tag
Feature: Inscription sur facebook
  En tant que nouveau utilisateur je veux créer un compte sur facebook

  @tag1
  Scenario: Inscription de nouveau utilisateur valide
    Given Ouvrir navigateur2
    And Accéder à URL du site "https://www.facebook.com/"
    
    When cliquer sur le boutton créer nouveau compte
    And saisir le prenom "malek"
    And saisir le nom "mohamed"
    And saisir adresse mail "malekmohamed@gmail.com"
    And confirmer adresse mail saisi 
    And saisir le mot de passe "malekmohamed123456"
    And choisir le chiffre du jour de naissance "1"
    And choisir le mois de naissance "jan"
    And choisir année de naissance "1986"
    And choisir le genre "Femme"
    And cliquer sur le bouton inscrire
    
    Then écrire le message que le compte a été créer avec succès
   

