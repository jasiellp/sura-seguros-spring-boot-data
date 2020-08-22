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


## Code Coverage

![Screenshot](codeCoverage.png)


## Swagger
 [Swagger](http://sura-seguros.herokuapp.com/swagger)

 
## Meta

[Jasiel Pereira de Sant ana](https://twitter.com/jasiellp) – jasiellp@hotmail.com

Distribuído sob a licença XYZ. Veja `LICENSE` para mais informações.

[https://github.com/yourname/github-link](https://github.com/othonalberto/)

## Contributing

1. Faça o _fork_ do projeto (<https://github.com/jasiellp/brasil-p/fork>)
2. Crie uma _branch_ para sua modificação (`git checkout -b feature/fooBar`)
3. Faça o _commit_ (`git commit -am 'Add some fooBar'`)
4. _Push_ (`git push origin feature/fooBar`)
5. Crie um novo _Pull Request_

[npm-image]: https://img.shields.io/npm/v/datadog-metrics.svg?style=flat-square
[npm-url]: https://npmjs.org/package/datadog-metrics
[npm-downloads]: https://img.shields.io/npm/dm/datadog-metrics.svg?style=flat-square
[travis-image]: https://img.shields.io/travis/dbader/node-datadog-metrics/master.svg?style=flat-square
[travis-url]: https://travis-ci.org/dbader/node-datadog-metrics
[wiki]: https://github.com/seunome/seuprojeto/wiki
