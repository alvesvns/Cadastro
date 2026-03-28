# TelaCadastro - Sistema de Cadastro (Java Swing + Banco de Dados)

Aplicação desktop desenvolvida em **Java Swing**, com integração a banco de dados, destinada ao **cadastro e gerenciamento de pessoas**.

O sistema implementa validações completas, integração com API externa e operações CRUD completas, garantindo consistência e confiabilidade dos dados.

---

## 🚀 Tecnologias

- Java (JDK 8+)
- Java Swing
- JDBC
- MySQL
- Lombok
- API de CEP

---

## 📋 Funcionalidades

### 📌 Cadastro de usuários

Permite registrar usuários com os seguintes dados:

- Nome
- Data de nascimento
- CPF
- CEP
- Endereço
- Bairro
- Cidade
- UF

---

### 🔄 CRUD completo

O sistema possui todas as operações de gerenciamento:

- Criar cadastro
- Listar registros em tabela (JTable)
- Editar cadastro existente
- Excluir cadastro com confirmação

---

### ✅ Validações implementadas

- Validação de nome
- Validação de CPF (estrutura e consistência)
- Verificação de CPF já cadastrado no banco
- Validação de campos obrigatórios
- Validação de data de nascimento
- Regra de idade mínima (16 anos)

---

### 🌐 Integração com API

- Consulta automática de CEP
- Preenchimento automático de:
  - Endereço
  - Bairro
  - Cidade
  - UF

---

### 💬 Avisos ao usuário

- Mensagens de sucesso (ex: cadastro/editado com sucesso)
- Confirmação antes de exclusão
- Interface com botões de ação (Editar / Excluir)

---

## 📂 Estrutura do Projeto
>![Foto-Estrutura.png](images%2FFoto-Estrutura.png)

### 📌 Organização

- **dao** → acesso ao banco de dados
- **entity** → representação das entidades
- **infra** → conexão e configuração do banco
- **service** → regras de negócio e validações
- **ui** → interface gráfica (Swing)

---

## ⚙️ Pré-requisitos

- JDK 8 ou superior
- NetBeans (recomendado para swing)
- MySQL instalado

---

## 💻 IDE Recomendada

Este projeto é mais indicado para uso no **NetBeans**, pois:

- Suporte nativo ao Swing Designer
- Melhor manipulação de interfaces `.form`

⚠️ IntelliJ abre normalmente, mas não edita visualmente as telas.

---

## 🛠️ Configuração do Banco

Arquivo:


`infra/db.properties`


Exemplo:

```properties
db.url=jdbc:mysql://localhost:3306/seu_banco
db.user=seu_user
db.password=sua_senha
```

---

## 🗄️ Estrutura da Tabela

```sql
CREATE TABLE address (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cep VARCHAR(10),
    rua VARCHAR(150),
    bairro VARCHAR(100),
    cidade VARCHAR(100),
    uf VARCHAR(2)
);

CREATE TABLE person (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    cpf VARCHAR(14) UNIQUE,
    birth DATE,
    id_address INT,
    FOREIGN KEY (id_address) REFERENCES address(id)
);
```
---
## ▶️ Como executar
**NetBeans**
1. Abra o projeto
2. Pressione F6 (Run Project)

---
## 🔐 Regras de Negócio

- Idade mínima: 16 anos
- CPF deve ser válido e único

---

## 📦 Dependências

- lombok.jar
- mysql-connector-j  