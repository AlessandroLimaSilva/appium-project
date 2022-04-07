@Login @automatizado
Feature: Login no spotify

  @automatizado @realizar_login_por_email
  Scenario: Realizar Login por email
    Given clica em login
    And o usuario informe tipo de login
    When insira os dados de login
    Then clica em login