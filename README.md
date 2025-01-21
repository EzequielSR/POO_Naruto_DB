# POO_Naruto_DB 🐱‍👤

Este repositório contém um projeto de implementação com Spring Boot que simula ninjas do universo de Naruto. Utilizando os conceitos de Programação Orientada a Objetos (POO), o sistema gerencia personagens (Ninjas) e suas habilidades (Jutsus), além de controlar atributos como o Chakra.

Anexo 📎: [Naruto I 5.docx](https://docs.google.com/document/d/1YQYouhWhM5mtoP-J8timcW0Uet16gqTD/edit?usp=sharing&ouid=104271855318934537979&rtpof=true&sd=true)
         [Naruto II 4.docx](https://docs.google.com/document/d/1SFXn7QyDcZWLbcuYUKzDZ7qZTotKPhHC/edit?usp=sharing&ouid=104271855318934537979&rtpof=true&sd=true)

---

## Requisitos 📋

- **Java 17** ou superior ☕
- **Spring Boot** (versão 2.x ou superior) 🚀
- **Banco de dados H2** para persistência 🗄️
- **Spring Data JPA** para integração com o banco de dados 🔗
- **Spring Boot DevTools** para recarregamento automático durante o desenvolvimento 🔄
- **Validações básicas** ✔️ e **tratamento de exceções** ⚠️ implementados
- **API RESTful** com respostas em formato **JSON** 🌐
- **Swagger** para documentação da API e interface interativa 🌟


---

## Funcionalidades 🛠️

### Funcionalidades Implementadas
- **Gerenciar personagens (Ninjas)**: Criar, listar, buscar, atualizar e deletar ninjas.
- **Gerenciar habilidades (Jutsus)**: Criar, listar e deletar jutsus associados a cada ninja.
- **Exibir informações detalhadas de cada ninja**:  Nome, idade, aldeia, chakra e vida.
- **Mostrar os jutsus de cada ninja**:  Listar os jutsus disponíveis para cada personagem.
- **Aumentar o Chakra do ninja**:  Implementar lógica para aumentar o chakra.
- **Exibir atributos de ninjas das classes Genjutsu, Ninjutsus e Taijutsus**:  Diferenciar ninjas por suas habilidades.

---

## Testes 🧪

A aplicação inclui testes para garantir o funcionamento correto dos métodos e operações dos ninjas. Os testes estão localizados na pasta `src/test/java` e incluem as seguintes classes:

- **PersonagemTests**: Testes para validar a lógica de negócios do serviço de personagens.
- **PersonagemControllerTests**:  Testes para validar a API REST do controlador de personagens.
- **BatalhaTest**: Testes para a lógica de batalha (se aplicável).
- **PersonagemTest**: Testes gerais para validar os atributos e métodos da classe `Personagem`.
- **NinjaDeGenjutsuTest,NinjaDeTaijutsuTest, NinjaDeNinjutsuTest** : Testes relacionados a ninjas de diferentes classes.

---

## Tecnologias Utilizadas 💻

- **Java 23**: Linguagem de programação utilizada ☕
- **Spring Boot**: Framework para desenvolvimento de aplicações Java 🚀
- **Spring Data JPA**: Biblioteca para integração com o banco de dados 🔗
- **H2 Database**: Banco de dados em memória para persistência de dados 🗄️
- **Spring Boot DevTools**: Ferramenta para recarregamento automático durante o desenvolvimento 🔄
- **JUnit 5**: Framework para testes unitários 🧪
- **Mockito**: Biblioteca para simulação de objetos em testes 🧪
- **Springdoc OpenAPI Starter WebMVC UI**: Para documentação da API e interface Swagger 🌟

  ```xml
   <dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.1.0</version>
   </dependency>
  ```

---

## Estrutura do Projeto 🏗️

A estrutura do projeto está organizada da seguinte forma:

```plaintext
src/main/java/com/example/Naruto_DB
├── entity
│   ├── Jutsu.java
│   └── Personagem.java
|
|
├── dto
│   ├── JutsuDTO.java
│   └── PersonagemDTO.java
|
├── ninja
│   ├── Batalha.java
│   ├── Ninja.java
│   ├── NinjaDeGenjutsu.java
│   ├── NinjaDeNinjutsu.java
│   └── NinjaDeTaijutsu.java
|
├── repository
│   ├── JutsuRepository
│   └── PersonagemRepository
|
├── service
│   └── PersonagemService
|
├── Application.java
├── Main.java
|
├── resources
└── application.properties
___________________________________________

src/test/java/com/example/Naruto_DB
    ├── BatalhaTest.java
    ├── NinjaDeGenjutsuTest.java
    ├── NinjaDeNinjutsu.java
    ├── NinjaDeTaijutsuTest.java
    ├── PersonagemControllerTests.java
    ├── PersonagemServiceTests.java
    └── PersonagemTest.java

```
---

## Instruções para Rodar o Projeto 🔧

1. **Clone o repositório** 🧑‍💻
   ```bash
   git clone https://github.com/EzequielSR/POO_Naruto_DB.git
   cd POO_Naruto_DB

2. **Instale as dependências 🔄** <br>
    O projeto utiliza o Maven para gerenciamento de dependências. Para instalar as dependências, execute:
   ```bash
   mvn clean install
   ```

3. **Rodar o projeto ▶️** <br>
   Para rodar o projeto localmente, execute o seguinte comando:
   ```bash
   mvn spring-boot:run
   ```

4. **Testes de Integração 🧪** <br>
   Os testes podem ser executados com o seguinte comando:
   ```bash
   mvn test
   ```
