## Especificações para cadastro de um novo Cliente

### 1 - Proposta de Nova Conta

Esse processo precisa ser **dividido** em várias etapas, caso o contrário o cliente seria obrigado a fornecer um grande número de informações de uma vez só e poderíamos **perder todos esses dados** por conta de uma falha na internet, no dispositivo do cliente ou na nossa própria aplicação.

#### 1.1 - Cadastro de Informações Pessoais

> Contexto
- Todo novo **`Cliente`** precisa solicitar uma *`proposta de criação de uma nova conta de pessoa física`*.

> Necessidades
- Adquirir do cliente as seguintes informações básicas:
    - Nome
    - Sobrenome
    - E-mail
    - CPF
    - Data de Nascimento

> Restrições
- Todos os dados são obrigatórios.
- O Email e o CPF:
    - precisam respeitar seus respectivos **formatos**.
    - não podem ser **duplicados**.
- O cliente deve ter mais que 18 anos de idade.

> Resultados Esperados
- Status code 201 e header location preenchido para o próximo passo do cadastro.
- Status code 400, em caso de falha de qualquer validação e json de retorno com as informações.

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
- Status code 400, em caso de falha de qualquer validação e json de retorno com as informações.

#### 1.3 - Validação de CPF

> Contexto
- O **`Cliente`** precisa *`enviar uma foto (frente) do seu CPF`*.

> Necessidades
- Arquivos que representem a frente  de um CPF.
- Ter amostras válidas e inválidas para teste.

> Restrições
- Todos os arquivos são obrigatórios.

> Decisão de Projeto
- Existe um jeito melhor de tratar esses uploads, ao invés de fazer o arquivo chegar pela aplicação? 

> Resultados Esperados
- Status code 201 e header location preenchido para o próximo passo do cadastro.
- Status code 400, em caso de falha de qualquer validação e json de retorno com as informações.
- Status code 404, caso a proposta que supostamente deveria estar associada com esse passo não exista.
- Status code 422, caso os passos anteriores não estiverem completos.

#### 1.4 - Confirmação da Corretude das Informações Fornecidas

> Contexto
- O **`Cliente`** precisa *`visualizar todos os dados que forneceu e confirmar que todos estão corretos`*.

> Necessidades
- Retornar um json com todas as informações fornecidas para que o front-end às exiba ao cliente.
- Caso o cliente ateste que as informações estão corretas:
    - informar que a conta será criada.
    - enviar um e-mail de boas vindas.
- Caso contrário:
    - registrar a interação.
    - enviar um e-mail implorando para que ele aceite.

> Restrições
- O json deve estar organizado e estruturado de acordo com cada tipo de dado.

> Resultados Esperados
- Status code 422, caso os passos anteriores não estiverem completos.

#### 1.5 - Processamento da Proposta

> Contexto
- O sistema precisa *`processar os dados enviados pelo cliente`*.

> Necessidades
- Criar uma nova conta, com os seguintes atributos:
    - Agência
    - Conta
    - Código do Banco
    - Saldo
- Atrelar a conta ao cliente que a solicitou.
- Enviar um e-mail para o cliente, informando:
    - a criação da nova conta.
    - e os seus respectivos dados.

> Restrições
- A Agência possui 4 dígitos.
- A Conta possui 8 dígito.
- Ambas podem ser geradas aleatoriamente (abstrair para usar um algoritmo específico depois).
- O Código do Banco possui 3 dígitos.
- O Saldo inicial deve ser nulo (igual a zero (0)).
- O processo de criação deve ser disparado de forma a **não bloquear o retorno relativo ao aceite do usuário**:
    - o cliente aceita e recebe uma menssagem que a conta será criada.
    - a tela não deve ficar parada esperando até que a conta seja criada.

> Detalhes Adicionais
- O e-mail não precisa ser real:
    - o sistema deve estar preparado para lidar com e-mails falsos em ambiente de desenvolvimento e reais em de produção.
- O processo de criação de conta só acontece depois que um **sistema externo** valida a documentação apresentada:
    - a proposta deverá ter um **status** informando que ainda não foi liberada.
    - após a liberação, o status da proposta deve ser alterado e a conta, criada.
    - em caso de erro, precisamos tentar pelo menos 2x antes de desistir. (parametrizar, com intervalo de tempo entre os requests...)

> Resultados Esperados
- Status code 200, representando a criação de um novo recurso (conta).
- Status code 400, indicando que a documentação apresentada não é válida e json de retorno com as informações.

### 2 - Primeiro Acesso

> Contexto
- No primeiro acesso após a criação da conta, precisamos passar pelos processos de *`confirmação de identidade`* e de *`criação de nova senha`*. 

> Necessidades
- Requisitar novamente e-mail e CPF do cliente.
- Enviar um e-mail para o cliente:
    - contendo um token de 6 dígitos aleatórios associado a conta.
    - este token deve ser fornecido pelo cliente para a criação da nova senha.
- Solicitar que o cliente insira a nova senha.
- Associar a senha à conta.
- Enviar um e-mail para o cliente, informando que a senha foi alterada/criada.

> Restrições
- O token:
    - tem tempo de expiração configurável no sistema.
    - só pode ser usado uma vez.
- A senha:
    - é obrigatória.
    - deve ser forte.
    - deve conter 8 dígitos.
    - precisa ser encodada com algum algoritmo de hash, para então ser persistida.

> Resultados Esperados
- Status code 400, caso o token tenha expirado.
- Status code 400, caso o token já tenha sido usado.
- Status code 200, caso tudo dê certo.
