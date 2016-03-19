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

## Utilização 

###Orientações

-> No sistema existe dois serviços implementados. O primeiro de gravação de mapas, e o segundo de pesquisa de rotas. 
Para se pesquisar uma rota, é necessário previamente gravar um mapa na base, para isso é necessário utilizar o serviço "gravaMapa", após o mapa persistido, utiliza-se o serviço "pesquisaRota"
para achar uma rota valida.

###entrada de dados 

-> Para a estrutura de entrada de dados foi optado pelo padrão JSON pela sua simplicidade e uso difundido.

### POST

http://Endereço servidor: porta/RestService2/rest/Rotas/gravaMapa

Gravar mapas:

Exemplo de requisição JSON para persistência de mapas

{

	"nomeMapa":"mapa SP",
	
	"rotas": [
	
	 {"p1" :"A" , "p2":"B" , "distancia":"10" },
	 
	 {"p1" :"B" , "p2":"D" , "distancia":"15" },
	 
	 {"p1" :"A" , "p2":"C" , "distancia":"20" },
	 
	 {"p1" :"C" , "p2":"D" , "distancia":"30" },
	 
	 {"p1" :"B" , "p2":"E" , "distancia":"50" },
	 
	 {"p1" :"D" , "p2":"E" , "distancia":"30" }
	 
	]
	
}

### POST

http://Endereço servidor: porta/RestService2/rest/Rotas/pesquisaRota

Pesquisar rota:

Exemplo de requisição JSON para pesquisa de rota

{

	"nomeMapa":"mapa SP",
	
	"vertice1":"A",
	
	"vertice2":"D",
	
	"autonomia":"10",
	
	"valorLitro":"2.5"
	
}

