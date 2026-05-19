CREATE DATABASE gerenciamento_funcionarios;
USE gerenciamento_funcionarios;

CREATE TABLE funcionarios(
id_funcionario INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR (100) NOT NULL,
cpf VARCHAR (14) NOT NULL,
salario_base DECIMAL (8,2) NOT NULL,
tipo VARCHAR (30) NOT NULL,
bonus_percentual DOUBLE,
senioridade VARCHAR (10),
carga_horaria INT
);



