"# Desafio-DIO" 
# Bootcamp Java: Fundamentos de POO e Collections

Este projeto é uma aplicação de console desenvolvida em Java para simular o gerenciamento de um bootcamp. Ele demonstra a aplicação de conceitos fundamentais de **Programação Orientada a Objetos (POO)** e a utilização da **Collections Framework** do Java, como `Set` e `List`.

## Estrutura do Projeto

O projeto é composto por cinco classes principais que interagem entre si para simular a dinâmica de um bootcamp:

* **`Conteudo.java`**: Uma classe **abstrata** que serve como base para todos os tipos de conteúdo do bootcamp. Ela define o comportamento padrão, como o cálculo de XP, que deve ser implementado por suas classes filhas.
* **`Curso.java`**: Uma classe que herda de `Conteudo`. Representa um curso com sua própria carga horária e implementa a lógica de cálculo de XP específica para cursos.
* **`Mentoria.java`**: Uma classe que também herda de `Conteudo`. Representa uma mentoria com uma data específica e implementa uma lógica de cálculo de XP diferente dos cursos, mostrando o poder do **polimorfismo**.
* **`Dev.java`**: A classe que representa um desenvolvedor. Ela gerencia os conteúdos nos quais o dev está inscrito e os que já concluiu, usando a interface `Set` para garantir que não haja conteúdos duplicados. A classe também é responsável por calcular o XP total do dev.
* **`Bootcamp.java`**: A classe que orquestra todo o sistema. Ela contém os conteúdos do bootcamp (`Set<Conteudo>`) e a lista de desenvolvedores inscritos (`Set<Dev>`).

## Principais Conceitos de POO e Collections Utilizados

### Programação Orientada a Objetos (POO)

* **Abstração e Herança**: A classe `Conteudo` é um exemplo de abstração, definindo uma interface comum para `Curso` e `Mentoria`. Essas classes herdam os atributos e a responsabilidade de implementar o método `calcularXp()`.
* **Encapsulamento**: Os atributos de todas as classes são privados, com acesso controlado por métodos `get` e `set`, garantindo a integridade dos dados.
* **Polimorfismo**: O método `calcularXp()` é implementado de forma diferente em `Curso` e `Mentoria`. A classe `Dev`, ao calcular o XP total, itera sobre uma coleção de `Conteudo` e chama o método `calcularXp()` de forma polimórfica, executando a implementação correta para cada objeto.

### Collections Framework

* **`Set`**: A interface `Set` (utilizada com a implementação `LinkedHashSet`) foi a escolha principal para gerenciar os conteúdos inscritos e concluídos de um `Dev`, assim como os desenvolvedores e conteúdos em um `Bootcamp`. A principal vantagem do `Set` é que ele **não permite elementos duplicados**, o que é ideal para evitar que um dev se inscreva duas vezes no mesmo curso, por exemplo.
* **`Optional<T>`**: O uso de `Optional` no método `progredir()` da classe `Dev` ajuda a evitar `NullPointerExceptions` ao tentar acessar um conteúdo que pode não existir na coleção.

## Novas Funcionalidades e Implementações Adicionadas

Para tornar o projeto ainda mais completo, foram adicionadas as seguintes funcionalidades:

* **Construtores**: Adicionamos construtores em `Curso`, `Mentoria` e `Bootcamp` para tornar a criação de objetos mais simples e direta.
* **Verificação de Conclusão**: Um método na classe `Dev` (`verificarConclusao(Bootcamp bootcamp)`) que usa o método `Set.containsAll()` para verificar se o desenvolvedor concluiu todos os conteúdos de um bootcamp.
* **`toString()` Aprimorado**: Os métodos `toString()` das classes `Dev`, `Curso`, `Mentoria` e `Bootcamp` foram melhorados para fornecer uma representação textual mais clara e útil dos objetos.
* **Ordenação de Desenvolvedores**: O código de exemplo (`Main.java`) demonstra como usar a interface `Comparator` para ordenar uma lista de `Devs` com base em seu XP total, mostrando um uso prático de ordenação em coleções.

## Como Executar o Projeto

Para executar o projeto, compile as classes Java e execute a classe `Main.java`. Você verá a simulação de um bootcamp, a progressão dos desenvolvedores e o cálculo de XP sendo exibido no console.
