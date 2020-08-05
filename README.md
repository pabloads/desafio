# Projeto Desafio

Dowload

1 - Criar pasta para o projeto e abrir uma linha de comando.
2 - Criar o repositório git com o comando git init (Caso não tenha o Git instaldo na máquina, instale antes de fazer esse passo).
3 - Rodar o comando $ git clone git://github.com/pabloads/desafio.git
4 - Entrar na pasta desafio e rodar o comando mvn clean install (Caso não tenha o instaldo na máquina, instale antes de fazer esse passo).

Instalação

Tomcat:

1 - Necessário ter o o Tomcate instalado. Tutorial nesse link: https://tomcat.apache.org/tomcat-8.5-doc/setup.html
2 - Abrir a pasta do tomcate, onde foi feita a instalação e na pasta /bin executar o arquivo startup.sh para Linux ou startup.bat para Windows.
3 - Entrar no endereço http://localhost:8080/ e clicar no botão "Manager App". 
4 - Na seção WAR file to deploy carregar o desafio.war que foi gerado em .m2\repository\br\com\pablo\desafio\0.0.1\desafio-0.0.1. Após carregar, clicar em Deploy.
5 - A aplicão devera ser exibida na lista de aplicaçãos. Para acesar clicar no nome da mesma ou então acessar http://localhost:8080/desafio/


 
