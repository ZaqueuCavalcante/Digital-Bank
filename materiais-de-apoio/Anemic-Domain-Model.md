# Anemic Domain Model

- Nele, os objetos possuem nomes e atributos que parecem fazer sentido no espaço do domínio. Eles também estão conectados entre si, através de ricas relações e estruturas encontradas nos verdadeiros modelos de domínio.

- No entanto, não há qualquer **comportamento** agregado aos dados, violando a essência da OO, que é **agrupar dados e processos na mesma estrutura**, expondo esses processos através de **interfaces** como meio para **alterar o estado** dos dados. 

- Eles são apenas pacotes com getterts e setters, acompanhados com uma forte obsessão por tipos primitivos (usam *strings* e *floats* para modelar todos os atributos). Muitas vezes, também são frutos de um **design guiado pelo banco de dados**, no qual cada objeto representa uma tabela e cada atributo, uma coluna.

- Fica evidente que o software foi desenvolvido para tornar mais fácil a conexão com o banco, não para resolver os problemas do domínio.

- Muitas vezes, todos os processos que **alteram o estado** desses dados estão numa camada de serviço, que agrega toda a lógica pertencente ao domínio. Com isso, o código se torna **procedural**, mesmo sendo escrito usando linguagens OO.

- Sob a perspectiva do DDD, temos duas camadas para resolver isso:
    - **Domain Layer**: responsável por representar ``conceitos`` do negócio, suas ``regras`` e informações sobre sua ``situação atual``. O estado que reflete a situação do negócio é *controlado e usado* aqui, embora os detalhes técnicos de persistência sejam *delegados* à infraestrutura. Essa camada é o ``coração do software``, é para onde a maior parte dos esforços devem ser direcionados, com o objetivo de atacar e diminuir sua complexidade.
    - **Application Layer**: define os ``processos`` que o software dever realizar, ``delegando`` para os ricos objetos de domínio todo o trabalho a ser feito. Ela agrega tarefas significativas para o negócio ou necessárias para a interação com outros sistemas. Deve ser mantida ``fina``, apenas ``coordenando`` as tarefas, como um maestro regindo uma orquestra. Não possui um estado que reflete a situação do negócio, mas pode ter um que reflete o progresso de uma tarefa para o usuário ou programa.

> Em geral, quanto mais comportamento você encontrar nos serviços, maior será a probabilidade de se privar dos ``benefícios`` de um rico modelo de domínio e das ``vantagens`` de usar uma linguagem orientada a objetos (por exemplo, a possibilidade de elevar o nível de abstração, usando classes abstratas e interfaces, e as usar pra relacionar/acoplar os módulos, facilitando o entendimento do software e troca de implementações de baixo nível).

> Fonte: [Anemic Domain Model - Martin Fowler](https://www.martinfowler.com/bliki/AnemicDomainModel.html)