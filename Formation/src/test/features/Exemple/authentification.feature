@tag
Feature: Authentification
  en tands que admin je veux m authentifier

  @tag1
  Scenario: Authentification valide
   Given ouvrir Navigateur
   And ouvrir URL
   When saisir username 
   And saisir mdp 
   And cliquer sur le bouton login
   Then verifier le nom du profil

  