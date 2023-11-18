# rede-social
Trabalho de Tópicos em Bancos de dados, onde precisa ser criado uma rede social simples usando Neo4j.

Para testar as APIs:
* Fazer o pull da imagem oficial do Neo4j no Docker:
```
docker run --name neo4j -p 7474:7474 -p 7687:7687 -d -e NEO4J_AUTH=neo4j/password neo4j
```
* Clonar este repositório, abrir a pasta em uma IDE e executar o seguinte comando no terminal:
```
mvn spring-boot:run
```
* Abrir no navegador a página do Swagger para testar a API, usando o seguinte link:
```
http://localhost:8080/swagger-ui/index.html#/
``` 
*Ou realizar requisições com Postman, Insomnia, ThunderClient, RESTCliente, etc...*

# Trabalho 4 - NEO4J

Faça uma rede social, onde cada nodo do grafo representa uma pessoa e as arestas são as amizades.

1) Implemente as operações CRUD para uma pessoa
2) Defina amizades entre as pessoas
3) Liste os amigos de uma determinada pessoa
4) Desfaça amizades existentes

Cada pessoa tem: cpf, nome, email, senha e data nascimento