@Login_por_email

Feature: Login no spotify

  @automatizado @realizar_login_por_email
  Scenario: Realizar Login por email
    Given clica em log in
    And que o usuario informe
    When insira os dados de login
    Then clica em log in