# Domain

Aqui, vamos tentar *`entender e modelar o domínio`* sob a perspectiva do **Domain Driven Design**.

Vamos pensar sobre:
- O domínio, que é um Banco Digital.
- Os problemas a serem resolvidos dentro dele:
    - Entidades envolvidas.
    - Processos que relacionam e alteram o estado dessas entidades.
- As diferentes maneiras que podemos abstratir e modelar esses elementos que compõe o domínio.
- Como podemos agrupá-los e dividí-los, em função dos contextos a que pertencem.
- A linguagem umbíqua falada pelos especialistas de domínio.

Como podemos traduzir tudo isso em software, para atacar a complexidade do negócio e realmente impactá-lo de maneira significativa.

As complexidades de legado (inexistentes, no nosso caso) e de solução técnica são opcionais. Elas que devem se moldar ao negócio, não o contrário.

## Essencial
- O que é um banco digital?
    - É um modelo de banco que surgiu para suprir com **tecnologia e eficiência** um mercado que sofria com a **burocracia** imposta pelos grandes bancos tradicionais. Por isso, eles estão **mudando a forma** como muitos cuidam de suas **finanças pessoais**.

- Pra quê ele existe? Que problema resolve?
    - Para facilitar o acesso aos **serviços financeiros** que os bancos tradicionais ofereciam, reduzindo extremamente a burocracia envolvida nos processos, a necessidade de enfrentar filas e a da presença física do cliente na agência (tornando-a obsoleta).
    - Além disso, eles buscam atacar problemas como tarifas elevadas, falta de transparência, conflito de interesses, entre outros.

- O que leva as pessoas a abrirem uma conta num banco digital?
    - Atendimento facilitado
    - Ampla variedade de tipos de pagamento
    - Interface intuitiva e fácil de utilizar
    - Parcerias e serviços adicionais (ex.: cashback)
    - Baixa burocracia
    - Praticidade
    - Eficiência
    - Agilidade no atendimento
    - Serviços disponíveis em qualquer lugar
    - Taxas atrativas

- Quais são os principais serviços oferecidos por ele?
    - Conta-corrente digital **sem tarifa**
    - Cartão de crédito, em muitos casos **sem anuidade**
    - Investimentos
    - Seguros
    - Consórcios
    - Empréstimos
    - Transferências
    - Pagamentos (contas, boletos, guias de impostos)

- Como um banco digital ganha dinheiro?

- Como um banco digital pode economizar dinheiro? Quais são os principais custos que ele têm?
    - Não têm gastos com agência e sua manutenção.
    - Quantidade de funcionários reduzida, em relação à um banco tradicional.
    - Automatização de processos, usando tecnologia.

- Quais são os principais bancos digitais do Brasil?
    - Agibank
    - Banco Inter
    - Banco Original
    - C6 Bank
    - Mercado Pago
    - Neon
    - Nubank
    - PagSeguro
    - Sofisa Direto

> Fontes de pesquisa:
> - [Banco digital: qual é o melhor?](https://blog.magnetis.com.br/bancos-digitais/)

## 0 - Modelando do mais alto nível de abstração

Design
Arquitetura
Visão macro

## 1 - Descendo mais um pouco

Módulos
Bounded Contexts
Context Maps

## 2 - Ainda mais

Agregates
Entities
Value Objects
Classes abstratas
Interfaces

## 3 - Chegando no fundo do poço

Implementações
