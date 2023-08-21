#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: authentification sur le site orange
  En tant que administrateur je veux me connecter au site de orange

  @tag1
  Scenario: authentification adminstrateur valide au site de orange
    Given ouvrir le Navigateur chrome
    And ouvrir URL du site de orange
    When saisir le username de administrateur
    And saisir le mdp de administrateur
    And cliquer sur le boutton se connecter
    Then verifier le nom du profil affiché
    
    

  
