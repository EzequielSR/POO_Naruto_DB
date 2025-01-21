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

---

## Funcionalidades 🛠️

### Funcionalidades Implementadas
- **Exibir as informações de cada ninja** 🖼️
- **Mostrar o nome dos jutsus de cada ninja** 🌀
- **Aumentar o Chakra do ninja** ⚡
- **Mostrar a idade do ninja** 🎂
- **Exibir os atributos de ninjas das classes Genjutsu, Ninjutsu e Taijutsu** 🔥

---

## Testes 🧪

A aplicação inclui testes para garantir o funcionamento correto dos métodos e operações dos ninjas. Os testes estão localizados na pasta `src/test/java` e incluem as seguintes classes:

- **NinjaDeGenjutsuTest**: Testes relacionados a ninjas da classe Genjutsu.
- **NinjaDeTaijutsuTest**: Testes relacionados a ninjas da classe Taijutsu.
- **NinjaDeNinjutsuTest**: Testes relacionados a ninjas da classe Ninjutsu.
- **PersonagemTest**: Testes gerais para validar os atributos e métodos da classe `Personagem`.
- **BatalhaTest**: Testes para a lógica de batalha.

---

## Tecnologias Utilizadas 💻

- **Java 23**: Linguagem de programação utilizada ☕
- **Spring Boot**: Framework para desenvolvimento de aplicações Java 🚀
- **Spring Data JPA**: Biblioteca para integração com o banco de dados 🔗
- **H2 Database**: Banco de dados em memória para persistência de dados 🗄️
- **Spring Boot DevTools**: Ferramenta para recarregamento automático durante o desenvolvimento 🔄
- **JUnit 5**: Framework para testes unitários 🧪

---

## Estrutura do Projeto 🏗️

A estrutura do projeto está organizada da seguinte forma:

```plaintext
src/main/java/com/example/Naruto_DB
├── entity
│   ├── Jutsu.java
│   ├── Personagem.java
│   └── PersonagemJutsu.java
|
├── ninja
│   ├── Batalha.java
│   ├── Ninja.java
│   ├── NinjaDeGenjutsu.java
│   ├── NinjaDeNinjutsu.java
│   └── NinjaDeTaijutsu.java
|
├── repository
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
