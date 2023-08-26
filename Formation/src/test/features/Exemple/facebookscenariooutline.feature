@tag
Feature: Inscription de plusieurs nouveaux utilisateurs sur facebook
  En tant que testeur je veux tester inscription de  plusieurs nouveaux comptes sur facebook

  @tag2
  Scenario Outline: Inscription de plusieurs nouveaux utilisateurs valide
    Given Ouvrir navigateur3
    And Accéder à URL de facebook "https://www.facebook.com/"
    When cliquer sur le boutton création de nouveaux comptes
    And saisir le first name "<prenomutilisateur>"
    And saisir le name "<nomdeutilisateur>"
    And saisir email "<adressemail>"
    And confirmer email saisi
    And saisir le password "<motdepasse>"
    And choisir day of birth "<numerodejourdenaissance>"
    And choisir month of birth "<lemoisdenaissance>"
    And choisir year of birth "<anneedenaissance>"
    And choisir gendre "<sexdeutilisateur>"
    And cliquer sur le bouton inscription facebook
    Then écrire le message de création de compte avec succès

    Examples: 
      | prenomutilisateur | nomdeutilisateur | adressemail             | motdepasse      | numerodejourdenaissance | lemoisdenaissance | anneedenaissance | sexdeutilisateur |
      | mohamed           | malek            | mohamedmalek@gmail.com  | mohamedbahri48  |                      11 | déc               |             1948 | Homme            |
      | salha             | chaffar          | salhachaffar@gmail.com  | salhachaffar56  |                       8 | mar               |             1956 | Femme            |
      | oussama           | mounir           | oussamamounir@gmail.com | oussamamounir84 |                       2 | mai               |             1984 | Homme            |
