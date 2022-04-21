Feature: Login no crowdtest app

  #Nesse Exemplo é passado o email, senha, e nome do usuario para validar o teste
  @realizar_login_por_email
  Scenario Outline: Realizar Login
    Given usuario informa seus dados <email> <senha>
    When o usuario confirma login
    Then o sistema efetua o login <nome>
    Examples:
      | email                         | senha       | nome             |
      | seuEmail@aqui                 | suaSenha    | seuNomeDeUsuario |
      | seuEmail@aqui                 | suaSenha    | seuNomeDeUsuario |
