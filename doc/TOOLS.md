# Tecnológia e Arquitetura

[Voltar para a pasta principal](https://github.com/ItaloMiguel/cursinho)

## Tecnológias
- ngnix
- pom.xml
- back-end:
    - java >= 17
    - spring boot 3.0.5
- front-end:
    - html
    - css
    - scss
    - javascript
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
A proposta central do projeto é que ele funcione em ambientes de containers, uma abordagem facilitada pelo uso de tecnologias como Docker e Docker Compose. Por que sugerir o uso do Docker? Simples: essa ferramenta simplifica significativamente a implementação do projeto. Com poucas linhas de código, você pode facilmente iniciar e encerrar o sistema. No entanto, vale ressaltar que, para testes mais leves, você tem a opção de simplesmente abrir uma ferramenta de desenvolvimento (IDE) e executar o código principal. Isso torna a experiência de desenvolvimento mais acessível, mesmo para aqueles que não estão familiarizados com a tecnologia de containers.

### 1. Tipo de arquitetura em Java
Nenhuma arquitetura específica foi adotada e por quê? Acredito que modelos como a [Arquitetura limpa](https://engsoftmoderna.info/artigos/arquitetura-limpa.html) ou [Arquitetura hexagonal](https://engsoftmoderna.info/artigos/arquitetura-hexagonal.html) são mais adequados para projetos grandes. Com meu conhecimento básico sobre arquitetura de software, optei por um caminho que me agradava, seguindo a prática de TDD e evitando a criação excessiva de pastas, algo comum em arquiteturas mais tradicionais do mercado.

### 2. Como se localizar
O arquivo executável principal está localizado [aqui](https://github.com/ItaloMiguel/cursinho/tree/master/src/main/java/br/com/blog/cursinho). Ao acessar este diretório, você encontrará um arquivo chamado CursinhoApplication.java, que funciona como o ponto de partida principal (o "main"). Ao criar novos códigos, é recomendável fazê-lo a partir deste diretório para que o Spring Boot possa reconhecê-los.

A estrutura do projeto segue uma organização específica: na pasta api, você deve colocar os controllers, factories, forms, mappers e repositories. Já na pasta shared, encontrará as configurações do Spring Boot, modelos/domínios, configurações de infraestrutura e configurações de segurança. Em resumo, essa divisão facilita a organização do projeto, permitindo compartilhar elementos essenciais em toda a aplicação.