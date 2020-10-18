# Programming with Abstract Data Types

- Abstract: 
    - Linguagens de alto nível provém ao programador **tipos primitivos** e um **conjunto de abstrações** embutido, que pode ser **aumentado/estendido** quando a necessidade de uma **nova abstração de dados** é descoberta.
    - Um ADT define uma classe de objetos abstratos que é completamente caracterizada pelas **operações** disponíveis nesses objetos. Isso significa que **um ADT pode ser construído definindo as operações características que podem ser executadas naquele tipo**.

- Introduction:
    - Para resolver um problema, o programador deve inicialmente usar **abstrações de alto nível**, sem se preocupar com os detalhes de implementação. Quando achar que essas abstrações resolvem o problema, deve voltar sua atenção para cada uma delas, as tratando como um novo problema a ser resolvido através de mais abstrações ou de implementações concretas. O problema original estará completamente resolvido quando todas as abstrações geradas no processo forem **realizadas** por programas concretos.

- Abstractions:
    - Em essência, o que desejamos de uma abstração é um mecanismo que permite a **expressão** de detalhes relevantes (de um problema) e a **supressão** de detalhes irrelevantes. Em programação, o **uso** que posso fazer de uma abstração é relevante, já sua **implementação** não.
    - Um bom exemplo de abstração é uma **função/procedimento**, pois quem a usa só precisa saber que dados ela recebe e retorna. É uma caixa preta, que **encapsula** todos os seus detalhes internos e provê ao programador apenas os aspectos relevantes para poder ser usada.
    - Quando declaramos um ``Integer`` em um programa, estamos **int**eressados nas **operações** (somar, subtrair, multiplicar...) que podem ser executadas em cima dele, não em como elas são implementadas.
    - Um ADT é realizado/implementado escrevendo um tipo especial de programa, chamado ``Operation Cluster``, que define o tipo em termos das **operações** que podem ser executadas nele.
    - Usaremos o termo ``abstração funcional`` para denotar aquelas operações abstratas que **não pertencem** a nenhum ADT. Uma abstração funcional será implementada como uma **composição** das operações oferecidas por um ou mais ADT e realizada através de um procedimento usual.
    - Tomemos uma função seno como exemplo: sua implementação poderia ser uma expansão em Série Taylor expressa em termos de **operações** que podem ser executadas sobre objetos do tipo real (float, double...). Dado um determinado ângulo, em radianos (um número real), só precisamos **somar** um monte de termos, que são compostos por outras operações, como **subtração**, **multiplicação** e **divisão**, para obter a saída da função.

- Using ADTs:
    - Na linguagem fortemente tipada apresentada, há apenas 3 jeitos de usar um objeto abstrato:
        - Através das operações que definem seu ADT;
        - Passando-o como parâmetro para um procedimento;
        - Atribuindo-o à uma variável de tipo correspondente;
    - Exemplo:
    ``` Java
        Book ddd = new Book();
        Stack bestBooks = new Stack();
        ddd.read();
        bestBooks.push(book);
    ```
    - Implementar o "Polish_gen" em Java depois... O ponto a ser evidenciado é que a abstração funcional **utiliza e conhece** apenas as **operações** que os ADTs fornencem para conseguir realizar sua tarefa. 

- Defining ADTs:
    - Descrição do ``Operation Cluster``, cuja tradução fornece uma implementação de um tipo.
    - Em C++, são os arquivos ``.h`` e ``.cpp``, que separam a interface da implementação.

- Controlling the Use of Information:
    - ADTs foram introduzidos como uma forma de **libertar** o programador de detalhes de implementação irrelevantes, para que este possa focar em entender e resolver o problema que lhe foi apresentado.
    - **Limitar** o programador a utilizar apenas **interfaces com as operações** suportadas pelos tipos trás inúmeros benefícios, pois os programas resultantes são mais modulares, fáceis de entender, modificar, testar, manter e de provar corretos.
    - Isso também possibilita **adiar** ao máximo a tomada de decisões e contruir o programa tomando uma de cada vez (um dos princípios de programação de Dijkstra).

- Relationship to Previous Work:
    - Extensible Languages
    - Standard Abstract Operators
    - SIMULA Classes

- Implementation Considerations
    - Modules and Module-Names
    - Type Checking
    - Retention
    - Efficiency

- Conclusions
    - Um ADT **encapsula dados e expõe operações** (interface) como única maneira de trabalhar com eles.
    - Isso livra o programador da preocupação de lidar com detalhes de implementação, dando-o a oportunidade de focar na resolução do problema.
    - Programas feitos dessa maneira são mais modulares, fáceis de entender, modificar, testar, manter e de provar corretos.

> Fonte: [Programming with Abstract Data Types - Barbara Liscov, Stephen Zilles](https://github.com/ZaqueuCavalcante/Digital-Bank/blob/main/materiais-de-apoio/PDFs/Programming-with-abstract-data-types.pdf)
