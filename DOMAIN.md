# Domain

Aqui, vamos tentar *`entender e modelar o domínio`*, sob a perspectiva do **Domain Driven Design**.

Vamos pensar sobre:
- As *`Entidades`* que compõe o domínio: Clientes, Contas, Transferências, Pagamentos, Empréstimos, Investimentos...
- Os *`Processos`* que relacionam e alteram o estado dessas entidades: *abrir uma conta*, *efetuar uma transferência*, *realizar um pagamento*, *requisitar um empréstimo*, *investir em um ativo*...
- Como podemos **abstratir e modelar** esses elementos fundamentais que compõe o domínio.
- Como agrupá-los, em função dos **contextos** a que pertencem.
- Como traduzir tudo isso em software, para atacar a complexidade do domínio e realmente impactar o negócio de maneira significativa.

## Essencial

- O que é um banco digital?
    - É um modelo de banco que surgiu para suprir com **tecnologia e eficiência** um mercado que sofria com a **burocracia** imposta pelos grandes bancos tradicionais. Por isso, eles estão **mudando a forma** como muitos cuidam de suas **finanças pessoais**.

- Pra quê eles existem? Que problema resolvem?
    - Para **facilitar o acesso aos serviços financeiros** que os bancos tradicionais ofereciam, reduzindo a burocracia envolvida nos processos, a necessidade de enfrentar filas e a da presença física do cliente na agência (tornando-a obsoleta).
    - Além disso, eles buscam atacar problemas como tarifas elevadas, falta de transparência, conflito de interesses, entre outros.

- O que leva as pessoas a abrirem uma conta num banco digital?
    - Atendimento facilitado
    - Ampla variedade de tipos de pagamento
    - Interface intuitiva e fácil de utilizar
    - Parcerias e serviços adicionais (ex.: cashback)
    - Praticidade
    - Eficiência
    - Agilidade no atendimento
    - Serviços disponíveis em qualquer lugar
    - Taxas atrativas

- Quais são os principais **serviços** oferecidos por eles?
    - Conta-corrente
    - Conta Poupança
    - Cartão de crédito
    - Investimentos
    - Seguros
    - Consórcios
    - Empréstimos
    - Transferências
    - Pagamentos (contas, boletos, guias de impostos)

- Como um banco digital ganha dinheiro?
    - Cobrando **taxas** por seus serviços e **juros** sobre empréstimos.
    - Realizando **investimentos** em tecnologia, novos produtos, títulos, ações...

- Como um banco digital pode economizar dinheiro?
    - Não têm gastos com agência e sua manutenção.
    - Quantidade de funcionários reduzida, em relação à um banco tradicional.
    - Automatização de processos, usando tecnologia.

- Quais as principais instituições reguladoras do mercado financeiro nacional?
    - Conselho Monetário Nacional (CMN):
        - Órgão normativo máximo do sistema financeiro brasileiro.
        - Seu papel é expedir normas e diretrizes a serem fiscalizadas por outros órgãos supervisores que compõem o sistema financeiro.
    - Banco Central (BC, BCB ou BACEN):
        - Principal autoridade monetária do Brasil.
        - Responsável pelo controle da inflação do país.
        - Responsável pela regulação e supervisão das instituições financeiras em funcionamento no Brasil.
    - Comissão de Valores Mobiliários (CVM):
        - Responsável por normatizar as regras para o registro de companhias de capital aberto, para a emissão e distribuição dos mais diversos ativos negociados no mercado financeiro, além de fiscalizar e punir quem não cumpre as suas regras.
    - Superintendência de Seguros Privados (SUSEP):
        - Atua no mercado das seguradoras, entidades abertas de previdência e sociedades de capitalização.
        - Define as características gerais dos contratos de seguros, previdência privada aberta e capitalização, fiscalizando e punindo os eventuais descumprimentos das suas regras.
    - Superintendência Nacional de Previdência Complementar (PREVIC):
        - Responsável pela supervisão e fiscalização das entidades fechadas de previdência complementar.
    - Associação Brasileira das Entidades dos Mercados Financeiro e de Capitais (ANBIMA):
        - Não é vinculada ao governo.
        - Representa as instituições do mercado de capitais brasileiro, como bancos, corretoras, gestoras de recursos, entre outros agentes.
        - É um órgão de autorregulação, emitindo códigos e regras que não são de cumprimento obrigatório, mas que estimulam as melhores práticas nesse mercado.
        - Emite certificações para os profissionais do ramo e calcula índices de referência amplamente utilizados no mercado financeiro.
    - B3, a bolsa de valores oficial do Brasil:
        - Não é vinculada ao governo, sendo uma empresa independente que atua como mercado para a negociação de uma série de títulos e valores mobiliários.
        - Emite regras de funcionamento e as fiscaliza, atuando em conjunto com a CVM.
        - Responsável pelo registro e controle de diversos dados referentes às emissões de valores mobiliários e a sua negociação.

> Fontes de pesquisa:

> [Banco digital: qual é o melhor?](https://blog.magnetis.com.br/bancos-digitais/)

> [Como os bancos digitais ganham dinheiro?](https://fintech.com.br/blog/fintech/como-bancos-digitais-ganham-dinheiro/)

> [Órgãos reguladores do Mercado financeiro nacional](https://www.parmais.com.br/blog/orgaos-reguladores-do-mercado-financeiro/)

## Processo de abertura de conta

## Processo de transferência de dinheiro

