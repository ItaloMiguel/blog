# Setup do projeto

[Voltar para a pasta principal](https://github.com/ItaloMiguel/cursinho)

###

### Rodar o projeto
Evite de rodar por make, por que não sei muito mexer com ele e pode conter bastante erros.
### Primeira maneira (Jeito mais simples)
Você vai precisar ter docker e docker-compose instalado em sua máquina.

Para iniciar o projeto por docker-compose basta rodar esse comando:

    $ docker-compose -f cursinho-dev.yaml up --build
    
Para parar o projeto:
    
    $ docker-compose -f cursinho-dev.yaml down



