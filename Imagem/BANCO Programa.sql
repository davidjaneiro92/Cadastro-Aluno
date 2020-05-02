CREATE DATABASE DB_CADASTRO_ALUNO;
USE DB_CADASTRO_ALUNO;

CREATE TABLE DADOS_PESSOAL(
RGM  INT(20) NOT NULL,
NOME VARCHAR(100) NOT NULL,
DATA_NACIMENTO DATE NOT NULL,
CPF INT(15) NOT NULL,
EMAIL VARCHAR(100),
ENDERECO VARCHAR(100) NOT NULL,
MUNICIPIL VARCHAR(15) NOT NULL,
UF CHAR(2) NOT NULL,
CELULAR char(15) NOT NULL,
CONSTRAINT PK_RGM_DADOS_PESSOAL PRIMARY KEY (RGM),
CONSTRAINT FK_RGM_DADOS_PESSOAL 
FOREIGN KEY (RGM) REFERENCES DADOS (RGM)
);

CREATE TABLE DADOS(
RGM  INT(20)NOT NULL,
CURCO VARCHAR(100)NOT NULL,
CAMPO VARCHAR(20),
PERILDO VARCHAR(15),
CONSTRAINT PK_RGM_DADOS PRIMARY KEY (RGM),
CONSTRAINT FK_RGM_DADOS 
FOREIGN KEY (RGM) REFERENCES NOTAS_FALTAS (RGM)
);
CREATE TABLE NOTAS_FALTAS(
RGM  INT(20)NOT NULL,
DICIPLINA VARCHAR(70)NOT NULL,
SEMESTRE VARCHAR(7),
NOTA VARCHAR(3),
FALTA INT(2),
CONSTRAINT PK_NOTAS_FALTAS PRIMARY KEY (RGM)
);

