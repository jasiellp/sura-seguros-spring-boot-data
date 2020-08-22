# Seguros SURA 

[![N|Solid](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQm108yLpChuDwpHS6FM_a20dOIqJsY6QOKLCpGp6lmFDaJapP5&s)](https://nodesource.com/products/nsolid)

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

Desafio Sura seguros 

  - Utilzacao de spring Data jpa
  - Desenvolvimento Orientado a test
  - Base de Dados  Postgresql Java 8

  
### Instalacao 

Compile utiliando o maven com o comando abaixo:
```sh
$ mvn clean install -X
```
### Executando 

Execute o comando abaixo, certifique-se de passar as credenciais da base de dados:
```sh
export DATABASE_URL=postgres://iolgtiocldpyil:rwrwerwerwetwt.aws@ec2-54-91-178-234.compute-1.amazonaws.com:5532/fsfdsfs
```
Apos a criacao da variavel o jar estara pronto para execucao
```sh
$ java -Dserver.port=$PORT $JAVA_OPTS -jar target/spring-boot-data-jpa-sura-seguros-1.0.jar
```



