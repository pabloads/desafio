# Projeto Desafio

Dowload

- Criar pasta para o projeto e abrir uma linha de comando.
- Criar o repositório git com o comando git init (Caso não tenha o Git instaldo na máquina, instale antes de fazer esse passo).
- Rodar o comando git clone git://github.com/pabloads/desafio.git
- Entrar na pasta desafio e rodar o comando mvn clean install (Caso não tenha o instaldo na máquina, instale antes de fazer esse passo).

Instalação

Banco de dados H2:
- Instalar o H2 caso, não tenha instalado. 
- Ao acessar http://localhost:8082/, escolher Generic H2 (Server) no campo Saved Settings.
- No campo JDBC colocar a seguinte URL: jdbc:h2:tcp://localhost/~/desafio
- Dexiar o User Name como sa e o Password em branco.
- Conectar e rodar o script abaixo:

- Executar o script abaixo:

CREATE CACHED TABLE "PUBLIC"."PESSOA"(
    "ID" INT  NOT NULL ,
    "NOME" VARCHAR,
    "EMAIL" VARCHAR,
    "SEXO" VARCHAR,
    "NATURALIDADE" VARCHAR,
    "NACIONALIDADE" VARCHAR,
    "CPF" VARCHAR NOT NULL,
    "DATA_CADASTRO" TIMESTAMP,
    "DATA_NASCIMENTO" DATE,
    "DATA_ATUALIZACAO" TIMESTAMP,
    "ENDERECO" VARCHAR
);

ALTER TABLE "PUBLIC"."PESSOA" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_8C" PRIMARY KEY("ID");
ALTER TABLE "PUBLIC"."PESSOA" ADD CONSTRAINT "PUBLIC"."UNIQUE_CPF" UNIQUE("CPF");



Tomcat:

- Necessário ter o o Tomcate instalado. Tutorial nesse link: https://tomcat.apache.org/tomcat-8.5-doc/setup.html
- Abrir a pasta do tomcate, onde foi feita a instalação e na pasta /bin executar o arquivo startup.sh para Linux ou startup.bat para Windows.
- Entrar no endereço http://localhost:8080/ e clicar no botão "Manager App". 
- Na seção WAR file to deploy carregar o desafio.war que foi gerado em .m2\repository\br\com\pablo\desafio\0.0.1\desafio-0.0.1. Após carregar, clicar em Deploy.
- A aplicão devera ser exibida na lista de aplicaçãos.

Iniciar aplicação:
- Na lista de aplicações do Tomanct clicar em /desafio ou então acessar http://localhost:8080/desafio/
