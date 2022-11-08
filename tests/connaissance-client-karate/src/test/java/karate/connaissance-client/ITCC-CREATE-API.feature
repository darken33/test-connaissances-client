Feature: Connaissnce Client Create

  Background:
    * url baseUrl
    * def signInKeycloak = callonce read('ITCC-000-AUTHENT.feature@use_user_1')
    * def jwtToken = signInKeycloak.response.access_token

  @ITCC-CREATE-UC01
  Scenario: ITCC-CREATE-UC01 - Post /v1/connaissance-clients - ok
    * print 'ITCC-CREATE-UC01 - Post /v1/connaissance-clients - ok'
    Given path '/v1/connaissance-clients'
    And header Accept = 'application/json'
    And header Authorization = 'Bearer ' + jwtToken
    And request { "nom": "Bousquet", "prenom": "Philippe", "ligne1": "48 rue bauducheu", "codePostal": "33800", "ville": "Bordeaux", "situationFamilialle": "CELIBATAIRE", "nombreEnfants": 0 }
    When method post
    Then status 201
    * match $ contains {id:"#notnull"}
    * print 'END ITCC-CREATE-UC01 - Post /v1/connaissance-clients - ok'

  @ITCC-CREATE-UC02
  Scenario: ITCC-CREATE-UC02 - Post /v1/connaissance-clients - nom invalide
    * print 'ITCC-CREATE-UC02 - Post /v1/connaissance-clients - nom invalide'
    Given path '/v1/connaissance-clients'
    And header Accept = 'application/json'
    And header Authorization = 'Bearer ' + jwtToken
    And request { "nom": "Bousquet$^/123", "prenom": "Philippe", "ligne1": "48 rue bauducheu", "codePostal": "33800", "ville": "Bordeaux", "situationFamilialle": "CELIBATAIRE", "nombreEnfants": 0 }
    When method post
    Then status 400
    * print 'END ITCC-CREATE-UC02 - Post /v1/connaissance-clients - nom invalide'
