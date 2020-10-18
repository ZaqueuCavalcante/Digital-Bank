# Is High Quality Software Worth the Cost?

- Trade-off: "gastar" tempo em Arquitetura e Qualidade de Código **vs** focar apenas no desenvolvimento de novas funcionalidades.
- Trade-off: qualidade interna **vs** custo. Software de alta qualidade interna é mais barato de produzir, portando esse dilema não se aplica aqui!

- Qualidade de software pode significar muitas coisas, dependendo do contexto de quem a avalia:
    - Externa:
        - Perceptível por usuários do sistema;
        - Uma interface intuitiva e fácil de usar;
        - Bugs, lentidão, não entregar as funcionalidades que deveria;
    - Interna:
        - Vista e desenvolvida pelos devs;
        - Em uma primeira abordagem, clientes não se importam e não pagam mais caro por ela, pois nem conseguem vê-la;
        - Então, por que investir nela? Porque ela facilita o **entendimento**, a **manutenção** e o **aprimoramento** do software, que sempre está passando por **modificações**, pois é em essência soft, maleável e capaz de evoluir. É mais fácil e **barato** mudar um software assim;
        - Engloba:
            - Arquitetura, capaz de refletir e suportar as demandas do domínio;
            - Separação em módulos bem definidos;
            - Nomes de variáveis, classes e métodos que fazem sentido, que refletem o domínio;
        - Torna a adição de novos recursos mais fácil, e isso é importante para os clientes. Logo, eles se importam com a qualidade interna do software, mesmo que indiretamente, pois ela fundamentalmente **diminui o custo de mudanças futuras**;
        - Alta qualidade interna é acompanhada de **baixo débito técnico** (cruft). É importante notar que o problema não é necessariamente contrair essa dívida, mas sim **não pagá-la**. Para isso, é imprescindível ter **testes automatizados**, **integração contínua** e estar sempre **refatorando** o código.

A figura a seguir ilustra a evolução de softwares com os dois níveis de qualidade interna:

![Quality Graph](https://martinfowler.com/articles/is-quality-worth-cost/both.png)

> Software de alta qualidade é **mais barato** de produzir, portanto, é um **investimento**, não um custo!

> Fonte: [Is High Quality Software Worth the Cost? - Martin Fowler](https://martinfowler.com/articles/is-quality-worth-cost.html)