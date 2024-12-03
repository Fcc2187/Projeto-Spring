# Projeto-Spring Boot DSlist

Este projeto foi desenvolvido durante o aprendizado das videoaulas sobre o framework Spring Boot, ministradas pelo professor Nélio Alves do curso DevSuperior. O objetivo é criar uma aplicação simples de controle de jogos, focada principalmente na parte de backend, utilizando o Spring Boot. Embora o foco principal seja a construção da API RESTful para gerenciar jogos, também densenvolvi um frontend simples para ilustrar o funcionamento da aplicação.

## O que é o Projeto?

O projeto consiste em uma aplicação para gerenciamento de uma lista de jogos. Ele foi desenvolvido para entender como o Spring Boot funciona, como implementar uma arquitetura em camadas e como interagir com um banco de dados utilizando o padrão ORM (Object-Relational Mapping).

### Funcionalidades:
- **Backend:** A API RESTful permite a criação, leitura, atualização e exclusão de jogos na lista, bem como o controle de suas informações, como título, descrição e data de lançamento.
- **Frontend (simples):** Foi implementado um frontend básico(Html, CSS e JavaScript) para ilustrar como a API interage com o usuário, embora o foco principal seja o backend.

### Arquitetura em Camadas:
A aplicação segue uma estrutura baseada em camadas para promover uma separação de responsabilidades, facilitar a manutenção e melhorar a organização do código. As principais camadas implementadas são:

- **Controller:** Responsável por receber as requisições HTTP, processá-las e retornar as respostas. Ele atua como intermediário entre o frontend e as camadas de serviço.
- **Service:** Contém a lógica de negócio da aplicação. A camada de serviço é responsável por processar os dados e fornecer as informações necessárias para o controller.
- **Repository:** Responsável pela interação direta com o banco de dados, utilizando o padrão ORM para mapear as entidades para tabelas do banco de dados.

### Classes Entidades (Entities):
As **entidades** são representações de tabelas no banco de dados e são usadas para mapear os dados. No caso desse projeto, a principal entidade é a `GameList`, que representa uma lista de jogos, e a `Game`, que representa os jogos dentro dessas listas.

As entidades são mapeadas usando **JPA (Java Persistence API)**, permitindo que os objetos Java sejam salvos diretamente nas tabelas do banco de dados. Por exemplo, a classe `GameList` pode ter atributos como `id`, `name` e `games`, representando a ID da lista, o nome da lista e os jogos associados a ela, respectivamente.

### Projeções (Projections):
As **projeções** são usadas para criar representações específicas de entidades sem carregar todos os dados. Em vez de retornar toda a entidade `Game`, que pode conter muitos dados que não são necessários em todas as situações, o projeto usa **projeções** para retornar apenas as informações essenciais. Por exemplo, a `GameMinProjection` pode conter apenas os dados necessários para listar os jogos, como o ID, título e imagem.

Essas projeções são úteis para melhorar a performance, reduzindo o tráfego de dados entre a aplicação e o banco de dados, especialmente em operações de leitura.

### DTOs (Data Transfer Objects):
Os **DTOs (Data Transfer Objects)** são objetos utilizados para transportar dados entre as camadas da aplicação. Eles são úteis para não expor diretamente as entidades do banco de dados na API, proporcionando maior controle sobre os dados que são enviados ou recebidos.

Por exemplo, a `GameListDTO` é usada para representar os dados da lista de jogos de maneira simplificada, sem a necessidade de incluir toda a entidade `GameList` com seus detalhes. Isso ajuda a evitar sobrecarga de dados e melhora a performance da aplicação. Além disso, o uso de DTOs também facilita a validação e transformação dos dados antes de serem enviados ao cliente ou recebidos da API.

### Modelo de Domínio:
Abaixo está o modelo de domínio do sistema, que representa a estrutura das entidades e seus relacionamentos:

![Modelo de Domínio](https://github.com/user-attachments/assets/b6d656ed-99b1-4c33-9470-e02e3cf041bb)

### Tecnologias Usadas:
- **Spring Boot**: Framework principal utilizado para construção da aplicação.
- **JPA (Java Persistence API)**: Utilizado para a interação com o banco de dados, através do ORM.
- **H2 Database**: Banco de dados em memória para armazenar os jogos.
- **Thymeleaf (Frontend simples)**: Utilizado para renderizar páginas HTML no frontend, embora a interação com a API seja o foco principal.

## Conceitos Aprendidos:
- **Sistemas web e recursos**
- **Cliente/servidor, HTTP, JSON**
- **Padrão Rest para API web**
- **Estruturação de projeto Spring Rest**
- **Entidades e ORM**
- **Database seeding**
- **Padrão camadas** (Controller, Service, Repository)
- **Padrão DTO**

Esse projeto foi fundamental para entender o funcionamento do Spring Boot, a arquitetura em camadas e a construção de uma API RESTful robusta. Ele oferece uma boa base para a criação de aplicações mais complexas utilizando o Spring Framework.

