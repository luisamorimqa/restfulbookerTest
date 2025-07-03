# restfulbookerTest

Projeto de automação de testes da API [Restful Booker](https://restful-booker.herokuapp.com/) utilizando **Java**, **RestAssured** e **JUnit**.

## 🚀 Tecnologias utilizadas

- Java 11  
- Maven  
- RestAssured  
- JUnit 5  
- JSON  
- Faker  
- Allure (opcional)

## 📁 Estrutura do projeto

📦 restfulbookerTest
┣ 📂data # Dados fake e massa de testes
┣ 📂dto # Objetos de transferência (Data Transfer Objects)
┣ 📂endpoint # Requisições para os endpoints da API
┣ 📂tests # Classes de testes automatizados
┣ 📜pom.xml # Gerenciador de dependências (Maven)
## 🧪 Funcionalidades testadas

- Criação de reservas (`POST /booking`)
- Consulta de reservas (`GET /booking/{id}`)
- Atualização total de reservas (`PUT /booking/{id}`)
- Atualização parcial de reservas (`PATCH /booking/{id}`)
- Exclusão de reservas (`DELETE /booking/{id}`)
- Autenticação via token (`POST /auth`)

## ✅ Pré-requisitos

- Java 11 ou superior  
- Maven 3.6+  
- IDE (IntelliJ, Eclipse, VS Code, etc)

## ⚙️ Como executar os testes

1. Clone o repositório:
```bash
git clone https://github.com/luisamorimqa/restfulbookerTest.git
cd restfulbookerTest
mvn test
mvn allure:serve
