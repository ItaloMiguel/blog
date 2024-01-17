# Regras para ser seguida

[Voltar para a pasta principal](https://github.com/ItaloMiguel/cursinho)

### 1. Como devo organizar?
Bem, é recomendável manter o mesmo padrão de 'arquitetura', mesmo que haja discordância em relação a ele. 
Note que existem alguns códigos de exemplo para seguir em caso de dúvidas 
(evite criar elementos sem utilidade, como getters e setters desnecessários).
Além disso, evite reinventar rotas; utilize todas as funcionalidades oferecidas pela ferramenta/framework para facilitar. 
E, claro, certifique-se de documentar as referências utilizadas.

### 2. Posso adicionar novas dependências?
Sim, contanto que não comprometa a integridade do código ou interfira em outras partes do projeto.

### 3. Como fazer os commits?
Para padronização de commits, recomendo seguir as diretrizes apresentadas neste 
[site](https://dev.to/vitordevsp/padronizacao-de-commit-com-commitlint-husky-e-commitizen-3g1n). 
Procure manter clareza nos commits, evitando excesso de detalhes. 
Se enfrentar dificuldades em expressar ideias de forma sucinta, considere o auxílio 
de ferramentas de inteligência artificial. Agradeço pela atenção.

### 4. OBS.
**POR FAVOR**, tente documentar as coisas com o próprio nome da classe ou métodos. Exemplo do que não fazer:

    /*  
    *   Soma do que?
    *   O que é val1 e val2?
    */
    public Double soma(Double val1, Double val2) {
        return val1 + val2;
    }

NÃO fiquei fazendo comentários desnecessários. Exemplo do que não fazer:
    
    
    /* 
    *   Aqui vai somar os valores passados.
    */
    public Double somarDoisValoresNumericos(Double primeiroValor, Double segundoValor) {
        /* 
        *   Se alguém passar 1 + 1 vai returnar 2.
        */
        return primeiroValor + segundoValor;
    }

