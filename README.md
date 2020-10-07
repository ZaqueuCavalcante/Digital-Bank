# Digital-Bank

API para suportar o funcionamento de um **Banco Digital**.

Desafio proposto durante o [Zup Bootcamp 2](https://www.zup.com.br), composto por duas etapas:

1) Entrega do projeto, via GitHub.
2) Produção de um vídeo contando como foi o **processo de desenvolvimento**, com ênfase nas **preocupações de segurança** da aplicação.

## Especificações do Projeto

É fundamental entender que qualquer **software** deve ser, em essência, *soft*. Ou seja, que ele deve ser macio, flexível, passível de sofrer alterações, ser evoluido, extendido e **mantido**. Neste projeto, esse último atributo receberá um maior enfoque, mas sem deixar de lado os demais.

### 0 - Setup
- Criar projeto [Spring Boot](https://start.spring.io/)

### 1 - Proposta de Nova Conta

Todo ``Cliente`` precisa solicitar uma `proposta de criação de nova conta de pessoa física` antes de qualquer outra coisa e este é justamente o processo que precisamos implementar. Só que tal processo precisa ser dividido em várias etapas, caso o contrário o cliente seria obrigado a passar um grande número de informações e poderíamos perder tudo por conta de uma falha de internet, falta de bateria no celular etc. A ideia aqui é minimizar isso. 

1.1 - 

