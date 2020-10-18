# On the Criteria To Be Used in Decomposing Systems into Modules

- Abstract:
    - Este artigo discute a modularização como um mecanismo para melhorar a **flexibilidade e compreensão** de um sistema ao mesmo tempo que permite a redução do seu tempo de desenvolvimento.
    - A **eficácia** de uma "modularização" depende dos **critérios** usados para dividir o sistema em módulos.
    - Técnicas convencionais e não convencionais de decomposição são apresentadas.

- Introduction:
    - Em um sistema bem modularizado, cada **tarefa** é realizada por um programa específico, em um módulo distinto.
    - Cada módulo, bem como suas entradas e as saídas, possui **interfaces bem definidas**, facilitando a interação com outros módulos e a execução de testes.
    - Erros e deficiências do sistema podem ser **rastreados** até módulos específicos, limitando assim o escopo de busca e facilitando a solução do bug.
    - Agora, quais critérios podem ser usados para dividir o sistema em módulos? Este paper tenta responder isso.

- A Brief Status Report
    - Em programação modular, existem técnicas que, através de interfaces bem definidas, permitem que:
        - Um módulo seja desenvolvido, mesmo sem o conhecimento dos **detalhes de implementação** presentes em outros módulos.
        - Módulos sejam remontados, modificados e substituídos sem necessidade de remontar todo o sistema.

- Expected Benefits of Modular Programming
    1) Gerencial: redução no tempo de desenvolvimento, porque times diferentes podem trabalhar em módulos diferentes, com pouca necessidade de comunicação.
    2) Flexibilidade: possibilidade de fazer mudanças drásticas em um módulo, sem a necessidade de alterar outros.
    3) Compreensibilidade: possibilidade de estudar o sistema um módulo de cada vez, tornando mais fácil entendê-lo, modificá-lo e refiná-lo.

- What Is Modularization?
    - Modularizar inclui tomar **decisões de design** (em nível de sistema, que afetam mais de um módulo) que devem ser feitas **antes** que o trabalho em módulos independentes possa começar.

- Conclusion:
    - Quase sempre é **incorreto** começar a decomposição de um sistema em módulos com base em um fluxograma.
    - Comece com uma lista de **decisões de design** difíceis ou que são propensos a mudar.
    - Cada módulo é então projetado para **esconder** tal decisão dos outros.
    - Para alcançar uma implementação eficiente, devemos abandonar a suposição de que um módulo é uma ou mais sub-rotinas.

> Fonte: [On the Criteria To Be Used in Decomposing Systems into Modules - D.L. Parnas]()
