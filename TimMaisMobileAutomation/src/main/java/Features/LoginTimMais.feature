
@regressivo
  Feature: Login no app TIM MAIS


    Scenario: Usuário faz login com sucesso no TIM MAIS

      Given acesso o app TIM MAIS e clico no botao comecar a usar
      And clico no botao Entrar no TIM MAIS
      When insiro o msisdn "11140000513"
      And clico no botao continuar
      And insiro a senha
      And clico no botão continuar senha
      Then visualizo home



#    Scenario: Usuário faz login com falha no TIM MAIS
#
#      Given acesso o app TIM MAIS e clico no botao comecar a usar
#      And clico no botao Entrar no TIM MAIS
#      When insiro o msisdn "11140000513"
#      And clico no botao continuar
#      And insiro a senha
#      And clico no botão continuar senha
#      Then visualizo home
