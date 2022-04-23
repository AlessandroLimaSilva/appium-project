Feature: Login no crowdtest app

  #Nesse Exemplo é passado o email, senha, e nome do usuario para validar o teste
  #Exemplo padrão de Scenario Outline
  @realizar_login_por_email @automatizado
  Scenario Outline: Realizar Login
    Given usuario informa seus dados <email> <senha>
    When o usuario confirma login
    Then o sistema efetua o login <nome>
    Examples:
      | email                         | senha       | nome             |
      | alessandro.silva@base2.com.br | alucard4315 | alessandro       |
      #| seuEmail@aqui                 | suaSenha    | seuNomeDeUsuario |

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
      | alessandro.silva@base2.com.br | alucard4315 | alessandro       |
      | alessandro.silva@base2.com.br | alucard4315 | alessandro       |

