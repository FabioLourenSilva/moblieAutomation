

  Feature: Login no app TIM MAIS
#    MASSAS:
#    11948460107
#    11982690005
#    11981820064
#    11983136735
#    11981173930
#    35991180245
#    24981113272
#    11921451592

#
#    Scenario: Usuário faz login com sucesso no TIM MAIS SSO

#      Given acesso o app TIM MAIS e clico no botao comecar a usar
#      And clico no botao Entrar no TIM MAIS
#      When insiro o msisdn "11140000513"
#      And clico no botao continuar
#      And insiro a senha
#      And clico no botão continuar senha
#      Then visualizo home

    @regressivo
    Scenario: Usuário faz login com sucesso no TIM MAIS SSO

      Given acesso o app MEU TIM
      And aceito as permissoes
      And clico no botao acessar com outro numero
      When insiro o msisdn "11981173930"
      And insiro a senha
      And clico no botao entrar
      And li e aceito os termos e confirmo
      And fecho o onboarding MEU TIM
      And concedo permissoes
      And clico no menu lateral
      And clico no menu TIM MAIS
      Then visualizo o tutorial guiado
      And  pulo o tutorial
#      And  visualizo home
