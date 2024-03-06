## Projeto de importação de arquivos de texto com dados do DNE (Diretório Nacional de Endereços dos Correios) para o banco de dados do cliente

Este projeto é de uma aplicação Java que automatiza um processo de inserção manual de dados em massa no banco de dados.

Visto que o cliente possui os dados de endereços do DNE dentro de tabelas em seu próprio banco de dados e realizava a alimentação dos dados de forma manual, tornou-se 
necessário desenvolver uma importação de dados automática a partir de arquivos de texto fornecidos pelo DNE para alimentar as tabelas do banco do cliente, permitindo 
que o cliente tenha sempre a base de dados atualizada, com economia de tempo e recursos.

### Funcionalidade

A API recebe uma requisição POST contendo três parâmetros:
- O ID da tabela que será alimentada
- Uma descrição da importação
- O arquivo de texto fornecido pelo DNE, referente à tabela que o usuário quer alimentar

Após a requisição, haverá a inserção de um registro que identifica a importação em uma tabela do banco de dados do cliente, com o status "em andamento". 
Depois disso, se iniciará a leitura do arquivo e a alimentação da tabela com os dados, linha por linha, mediante realização de inserts ou updates.

Após o término do processo, o registro que identifica a importação será atualizado com status, como "importação com sucesso", "erro de importação" ou "importação incompleta".

### Principais técnicas e tecnologias utilizadas
- Java 17
- Programação orientada a objetos (OO)
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Docker
- Maven
