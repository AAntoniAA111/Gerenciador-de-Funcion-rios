# 🏢 Sistema de Gerenciamento de Funcionários

Projeto desenvolvido em Java para gerenciar diferentes tipos de funcionários de uma empresa, aplicando os 4 pilares da **Programação Orientada a Objetos (POO)** integrados a um banco de dados **MySQL**.

---

## 📚 Conceitos Aplicados

| Pilar | Como foi aplicado |
|---|---|
| **Abstração** | Classe abstrata `Funcionarios` define o modelo base de todo funcionário |
| **Encapsulamento** | Atributos privados com getters e setters controlando o acesso |
| **Herança** | `Gerente`, `Desenvolvedor` e `Estagiario` herdam de `Funcionarios` |
| **Polimorfismo** | Método `calcularSalario()` se comporta diferente em cada classe filha |

---

## 🗂️ Estrutura do Projeto

```
src/
├── Funcionarios.java      # Classe abstrata base
├── Gerente.java           # Herda de Funcionarios + bônus percentual
├── Desenvolvedor.java     # Herda de Funcionarios + nível de senioridade
├── Estagiario.java        # Herda de Funcionarios + carga horária
├── ConexaoDB.java         # Gerencia a conexão com o banco MySQL
├── FuncionarioDAO.java    # CRUD com o banco de dados
└── Main.java              # Classe principal para testar o sistema
```

---

## 💰 Cálculo de Salário por Tipo

**Gerente**
```
salarioBase + (salarioBase * bonusPercentual / 100)
```

**Desenvolvedor**
```
Júnior  → salarioBase * 1.0
Pleno   → salarioBase * 1.2
Sênior  → salarioBase * 1.5
```

**Estagiário**
```
(salarioBase / 220) * cargaHoraria * 4
```

---

## 🗄️ Banco de Dados

O sistema utiliza **MySQL** com a seguinte estrutura de tabela:

```sql
CREATE DATABASE sistema_funcionarios;

USE sistema_funcionarios;

CREATE TABLE funcionarios (
    id               INT PRIMARY KEY AUTO_INCREMENT,
    nome             VARCHAR(100) NOT NULL,
    cpf              VARCHAR(14)  NOT NULL,
    salario_base     DOUBLE       NOT NULL,
    tipo             VARCHAR(20)  NOT NULL,
    bonus_percentual DOUBLE,
    senioridade      VARCHAR(10),
    carga_horaria    INT
);
```

---

## 🚀 Como Executar

### Pré-requisitos
- Java JDK 11 ou superior
- MySQL instalado e rodando
- Driver `mysql-connector-j 9.7.0` adicionado ao projeto

### Passo a passo

1. Clone o repositório:
```bash
git clone https://github.com/AAntoniAA111/Gerenciador-de-Funcion-rios.git
```

2. Crie o banco de dados com os comandos SQL acima

3. Configure suas credenciais em `ConexaoDB.java`:
```java
private static final String URL = "jdbc:mysql://localhost:3306/sistema_funcionarios";
private static final String USER = "seu_usuario";
private static final String PASSWORD = "sua_senha";
```

4. Adicione o driver MySQL ao projeto e execute a `Main.java`

---

## 🛠️ Tecnologias Utilizadas

- **Java** — linguagem principal
- **MySQL** — banco de dados
- **JDBC** — conexão Java com o banco
- **MySQL Connector/J 9.7.0** — driver oficial MySQL para Java

---

## 👨‍💻 Autor

Desenvolvido como projeto de estudo de **Programação Orientada a Objetos com Java**.
