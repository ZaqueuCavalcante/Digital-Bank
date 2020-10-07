# Digital-Bank

API para suportar o funcionamento de um **Banco Digital**.

Desafio proposto durante o [Zup Bootcamp 2](https://www.zup.com.br), composto por duas etapas:

1) Entrega do projeto, via GitHub.
2) Produção de um vídeo contando como foi o **processo de desenvolvimento**, com ênfase nas **preocupações de segurança** da aplicação.

## Especificações do Projeto

É fundamental entender que qualquer **software** deve ser, em essência, *soft*. Ou seja, que ele deve ser macio, flexível, passível de sofrer alterações, ser evoluido, extendido e **mantido**. Neste projeto, esse último atributo receberá um maior enfoque, mas sem deixar de lado os demais.

### 0 - Setup
- Criar projeto [Spring Boot](https://start.spring.io/)

### 1 - Proposta de Nova Conta / Primeira Interação / Cadastro

Esse processo precisa ser **dividido** em várias etapas, caso o contrário o cliente seria obrigado a fornecer um grande número de informações de uma vez só e poderíamos **perder todos esses dados** por conta de uma falha na internet, no dispositivo do cliente ou na nossa própria aplicação.

#### 1.1 - Cadastro de Informações Pessoais

> Contexto
- Todo **`Cliente`** precisa solicitar uma *`proposta de criação de nova conta de pessoa física`*.

> Necessidades
- Adquirir do cliente as seguintes informações básicas:
    - Nome
    - Sobrenome
    - Email
    - CNH (com CPF)
    - Data de Nascimento

> Restrições
- Todos os dados são obrigatórios.
- O Email e a CNH:
    - precisam respeitar seus respectivos **formatos**.
    - não podem ser **duplicados**.
- O cliente deve ter mais que 18 anos de idade.

> Resultados Esperados
- Status code 201 e header location preenchido para o próximo passo do cadastro.
- Status code 400 em caso de falha de qualquer validação e json de retorno com as informações.

#### 1.2 - Cadastro de Endereço

> Contexto
- O **`Cliente`** precisa *`fornecer seu endereço de moradia`*.

> Necessidades
- As seguintes informações devem ser adquiridas:
    - CEP
    - Rua
    - Bairro
    - Complemento
    - Cidade
    - Estado

> Restrições
- Todos os dados são obrigatórios.
- O CEP deve estar em **formato adequado**.
- Cidade e Estado podem ser **campos abertos**.

> Resultados Esperados
- Status code 201 e header location preenchido para o próximo passo do cadastro.
- Status code 400 em caso de falha de qualquer validação e json de retorno com as informações.

#### 1.1 - Validação de CNH

> Contexto
- O **`Cliente`** precisa *`enviar uma foto (frente e verso) da sua CNH`*.

> Necessidades
- Arquivos que representem a frente e o verso de uma CNH.
- Ter amostras válidas e inválidas para teste.

> Restrições
- Todos os aruivos são obrigatórios.

> *Decisão de Projeto
- Existe um jeito melhor de tratar esses uploads, ao invés de fazer o arquivo chegar pela aplicação? 

> Resultados Esperados
- 






#### 1.1 - Primeira Interação / Cadastro

> Contexto
- 

> Necessidades
- 

> Restrições
- 

> Resultados Esperados
- 
 

