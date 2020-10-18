# Software Architecture

- Run-time Abstraction:
    - Uma arquitetura de software é uma **abstração** dos elementos de tempo de execução de um sistema de software durante alguma fase de sua operação. Um sistema pode ser composto de vários **níveis de abstração** e muitas **fases de operação**, cada uma com sua própria arquitetura de software.
    - Em essência, abstrair algo significa **esconder** detalhes irrelevantes (encapsular) e **expor** apenas o necessário (via interfaces).
    - Em um dado **nível de abstração**, a integração (acoplamento) entre os elementos de software é feita através de **interfaces abstratas** bem definidas.
    - Dentro de cada elemento pode ser encontrada outra arquitetura, definindo o sistema de sub-elementos que **implementam o comportamento** representado pela interface abstrata do elemento pai.
    - Essa **recursão de arquiteturas** continua até os elementos mais básicos do sistema, aqueles que não podem ser decompostos em elementos menos abstratos, a **implementação concreta** das operações definidas nos níveis de abstração mais altos.

- Elements
    - Uma arquitetura de software é definida por uma **configuração de elementos** - componentes, conectores e dados - **restritos em seus relacionamentos** para atingir um conjunto desejado de **propriedades** arquiteturais.
    - Components:
        - Uma unidade abstrata dotada de **operações e estado interno**, que fornece um meio para alterar seus dados internos (estado) através de uma interface.
    - Conectors:
        - Um mecanismo abstrato que **media** a comunicação, coordenação ou cooperação entre componentes.
    - Data:
        - Um **elemento de informação** que é **transferido** de um componente, ou recebido por um, através de um conector.

- Configurations
    - É a estrutura dos **relacionamentos arquitetônicos** entre componentes, conectores e dados durante um período de tempo de execução do sistema.

- Properties
    - Conjunto de todas as propriedades do sistema, funcionais ou não.

- Styles
    - Um estilo arquitetural é um **conjunto coordenado de restrições** que restringe as **funções** dos elementos arquitetônicos e os **relacionamentos** permitidos entre eles.

- Patterns and Pattern Languages
    - Um Design Pattern é definido como uma **construção importante e recorrente** em sistemas, uma solução que é frequentemente aplicada em problemas de escopo similar.

- Views
    - 

> Fonte: [Software Architecture - Roy Thomas Fielding](https://www.ics.uci.edu/~fielding/pubs/dissertation/software_arch.htm)
