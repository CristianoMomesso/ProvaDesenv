# Exercicio entregando mercadorias

## Tecnologias utilizadas

Maven - Foi utilizado o maven para o gerenciamento de dependência, buscando nos repositórios os jars necessários para a execução do sistema.    

JPA com hibernate - Para persistência dos dados, foi optado pelo uso de jpa com hibernate, pela facilidade de persistir objetos na base..

java 1.8.

Wildfly 8.2.1.Final.

RestEasy- Framework que implementa especificação para o JAX-RS.

Eclipse Mars.

SoapUI 5.2.1 - Interface para consumo de webservice. Optei por também realizar testes utilizando essa ide, pela facilidade de executar requisições em webservices.

MySql - Banco de dados.

Mochito- framework que auxilia na geração dos testes.

## Instalação

->Baixar ou clonar o projeto via git do endereço https://github.com/CristianoMomesso/ProvaDesenv.

->Para importar o projeto git pelo eclipse. Eu utilizei o pluggin do próprio eclipse.

->Adicionar na aba server o servidor de aplicação  Wildfly 8.2.1.Final. pode ser necessário instalar algumas extensões do jboss via eclipse market.

->Executar o comando mvn install para todos os projetos seguindo a específica ordem : DTO , DAO , Business, Service.

->No servidor de aplicação inserir Service para deploy.

## Arquitetura

-> Optei por dividir o sistema em camada sendo cada uma um projeto maven diferente.

->As camadas são:
	->Service: Cada que possui todos as chamadas dos serviços que serão espostos.
	->DTO: O padrão foi usado para não expor a camada de persistência para os serviços.
	->Business: Camda qeu possui todas as regras de negocio da geração de rotas.
	->Dao: Padrão utilizado para a persistencia de dados.

-> Todas as menssagens retornadas pelo sistema se encontram no arquivo de configuração localizado em "/Exercicio/conf/conf.properties"

