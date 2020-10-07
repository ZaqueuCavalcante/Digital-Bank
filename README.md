# Digital-Bank

API para suportar o funcionamento de um **Banco Digital**.

Desafio proposto durante o [Zup Bootcamp 2](https://www.zup.com.br), composto por duas etapas:

1) Entrega do projeto, via GitHub.
2) Produção de um vídeo contando como foi o **processo de desenvolvimento**, com ênfase nas **preocupações de segurança** da aplicação.

## Especificações do Projeto

É fundamental entender que qualquer **software** deve ser, em essência, *soft*. Ou seja, que ele deve ser macio, flexível, passível de sofrer alterações, ser evoluido, extendido e **mantido**. Neste projeto, esse último atributo receberá um maior enfoque, mas sem deixar de lado os demais.

Além disso tudo, o software deve ser **testável** e **testado**. Todas as funcionalidades essenciais para o negócio devem ser completamente testadas. Isso irá reduzir os custos para fazer alterações no código e refatorá-lo, dando a segurança que ele continua se comportando como deveria, mesmo após esses processos.

### 0 - Setup
- Criar projeto [Spring Boot](https://start.spring.io/):
    - Versão do Java
    - Empacotamento
    - Gerenciador de dependências
    - Versão do Spring
    - Módulos adicionais do Spring, como:
        - Web
        - Security
        - ???

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

#### 1.3 - Validação de CNH

> Contexto
- O **`Cliente`** precisa *`enviar uma foto (frente e verso) da sua CNH`*.

> Necessidades
- Arquivos que representem a frente e o verso de uma CNH.
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
- Status code 422,, caso os passos anteriores não estiverem completos.

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
- O Saldo inicial deve ser nulo (igual a zero (0)).
- O processo de criação deve ser disparado de forma a **não bloquear o retorno relativo ao aceite do usuário**: ?????
    - o cliente aceita e depois a conta é criada e o email informativo enviado. Isso é muito importante! ?????

> Detalhes Adicionais
- O e-mail não precisa ser real:
    - o sistema deve estar preparado para lidar com e-mails falsos em ambiente de desenvolvimento e reais em de produção.
- O processo de criação de conta só acontece depois que um **sistema externo** valida a documentação apresentada:
    - a proposta deverá ter um status informando que ainda não foi liberada.
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

### 3 - Recebimento de Dinheiro via Transferência

> Contexto
- 

> Necessidades
- 

> Restrições
- 

> Resultados Esperados
- 

### 4 - Transferência para Contas de Outros Bancos

> Contexto
- O **`Cliente`** precisa ter a possibilidade de *`transferir dinheiro para contas de outros bancos`*.

> Necessidades
- Requisitar do cliente as seguintes informações sobre o **favorecido**:
    - Banco, com:
        - Nome (ENUM, com os bancos parceiros)
    - Conta, com:
        - Tipo:
            - Poupança
            - Corrente
        - Agência
        - Número
        - Cada banco representa a conta de um jeito *.
    - Deve ser favoritado?
        - Se sim, salvar todos os dados necessários para fazer uma transferência novamente.
        - Salvar atrelado à conta do cliente.
- E sobre a **transferência** em si:
    - Valor
    - Data para realização
    - Breve descrição da transação
- Após a inserção de todos estes dados, a aplicação deve:
    - Se comunicar com um **serviço externo** para verificar se as informações batem com as armazenadas pelo banco do favorecido.
    - Requisitar à esse serviço o nome completo do favorecido.
    - Mostrar para o cliente todos esses dados, para que ele possa confirmar a transação.
- É necessário enviar dados para um **serviço externo**, responsável por rotear toda comunicação entre os bancos:
    - O nosso cliente não precisa ficar esperando por isso.
    - Caso necessário, a transferência deve ficar aguardando o serviço externo até ser processada.
    - Em uma situação extrema, reagendá-la para o próximo dia útil e enviar um e-mail de aviso para o cliente.
- A verificação de saldo suficiente deve ser feita logo antes de iniciar a transferência:
    - Perceba que o cliente pode agendar uma transferência para uma data futura, mesmo não tendo saldo suficiente na data atual.
    - Ele pode depositar ou receber alguma quantia neste meio tempo, o que torna a transferência futura possível.

> Restrições
- Sobre o favorecido:
    - O banco deve estar entre os suportados.
    - A agência deve possuir 4 números.
- A transferência:
    - não pode ser feita em um final de semana.
    - nem fora do horário comercial (08:00 <-> 17:00).
    - deve ser um valor positivo.

> Resultados Esperados
- Status code 400, caso:
    - Não tenha saldo suficiente.
    - A conta do favorecido não exista (está incorreta).
- Status code 200, caso tudo dê certo.

### 5 - Transferências para Contas do Mesmo Banco

> Contexto
- 

> Necessidades
- 

> Restrições
- 

> Resultados Esperados
- 




#### 2. - ?

> Contexto
- 

> Necessidades
- 

> Restrições
- 

> Resultados Esperados
- 
 

