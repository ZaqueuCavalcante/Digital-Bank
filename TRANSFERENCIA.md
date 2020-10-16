## Especificações para realizar transferências entre contas

### 1 - Recebimento de Dinheiro via Transferência

> Contexto
- O **`Cliente`** pode *`receber dinheiro via transferência bancária`*.
- O sistema possui um endpoint que recebe notificações (feitas pelo mesmo banco ou um diferente) sobre novas transferências.

> Necessidades
- Informações das duas contas envolvidas, para armazenamento nos dois bancos.
- Toda transferência possui um código único (ID).
- Atualizar os saldos das contas creditada e debitada.

> Ponto de Atenção
- Duas ou mais requisições de transferência para a mesma conta podem chegar ao mesmo tempo.
- Elas não precisam ser processadas em série.
- Processar em paralelo usando threads?

> Restrições
- Todas as informações relativas a transferência são obrigatórias. 

> Resultados Esperados
- Status code 400, caso ocorra algum problema de validação (retornar json).
- Status code 200, caso dê tudo certo.

### 2 - Transferência para Contas de Outros Bancos

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

### 3 - Transferências para Contas do Mesmo Banco

> Contexto
- 

> Necessidades
- 

> Restrições
- 

> Resultados Esperados
- 
