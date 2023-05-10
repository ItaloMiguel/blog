# Tecnológia e Arquitetura

[Voltar para a pasta principal](https://github.com/ItaloMiguel/cursinho)

## Tecnológias
- Spring boot 3.0.5
- ngnix
- pom.xml
- Java >= 17
- database:
    - postgres
    - h2 (banco de dados em memória para teste)
- automações:
    - shellScript
    - makefile (está em processo)
- containers:
    - docker 
    - docker-compose
- testes
    - integração
    - persistência
    - unitário

## Arquitetura
A ideia do projeto é ser rodado em containers utilizando docker e dockerc-compose. Por que recomendo que você use docker? Porque é onde você vai aproveitar o máximo do projeto, sem muitas dificuldade e com poucos códigos você consegue subir e derrubar o projeto, mas nada te impede de subir em modo teste, que é apenas abrir uma ide e rodar o código main.

### 1. Tipo de arquitetura em Java
Nenhuma arquitetura específica foi utilizada e por quê? Eu acho que [Arquitetura limpa](https://engsoftmoderna.info/artigos/arquitetura-limpa.html) ou [Arquitetura hexagonal](https://engsoftmoderna.info/artigos/arquitetura-hexagonal.html) fazem sentido apenas para grandes projetos, então com meu leve conhecimento sobre arquitetura de software achei um jeito que que me agradasse seguindo a prática de [TDD](https://pt.wikipedia.org/wiki/Test-driven_development) e sem precisar criar muitas pastas (como geralmente acontece com as aquiteturas padrão do mercado).


### 2. Como se localizar
O executável main se encontra [aqui](https://github.com/ItaloMiguel/cursinho/tree/master/src/main/java/br/com/blog/cursinho). Ao entrar nele você vai notar que existe um executável e duas pasta, a pasta `api` é onde vai colocar os controller, factory, forms, mapps e repository, já onde está `shared` é onde você vai encontrar as configurações do spring boot, model/domain, configurações de infra e configurações de segurança.

    