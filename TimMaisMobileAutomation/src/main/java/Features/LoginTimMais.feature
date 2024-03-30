
  Feature: Login no app TIM MAIS

    @TEST1
    Scenario: usuário faz login com sucesso no TIM MAIS

      Given acesso o app TIM MAIS e clico no botao comecar a usar
      And clico no botao Entrar no TIM MAIS
      When insiro o msisdn
      And clico no botao continuar
      And insiro a senha
      And clico no botão continuar senha
      Then visualizo home

