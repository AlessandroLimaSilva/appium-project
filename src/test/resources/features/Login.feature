Feature: Login no crowdtest app

  #Nesse Exemplo é passado o email, senha, e nome do usuario para validar o teste
  #Exemplo padrão de Scenario Outline
  @realizar_login_por_email @automatizado
  Scenario Outline: Realizar Login
    Given que usuario seleciona login
    And usuario informa seus dados <email> <senha>
    When o usuario confirma login
    Then o sistema efetua o login <nome>
    Examples:
      | email                         | senha       | nome             |
      | seuEmail@aqui                 | suaSenha    | seuNomeDeUsuario |
      | seuEmail@aqui                 | suaSenha    | seuNomeDeUsuario |

  #Nesse Exemplo é passado o email, senha, e nome do usuario para validar o teste
  #Exemplo de Scenario Outline utilizando o compartilhamento de parametros entre os steps definitions
  @realizar_login_por_email @automatizado
  Scenario Outline: Realizar Login
    Given possui dados <email> <senha> <nome>
    And informa dados
    When o usuario confirma login
    Then o sistema efetua o login
    Examples:
      | email                         | senha       | nome             |
      | seuEmail@aqui                 | suaSenha    | seuNomeDeUsuario |
      | seuEmail@aqui                 | suaSenha    | seuNomeDeUsuario |

