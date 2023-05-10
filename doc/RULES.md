# Regras para ser seguida

### 1. Como devo organizar?
Bom, o recomendavel é que mantenha o mesmo padrão de 'arquitetura' mesmo que não concorde com o jeito que está. Nota-se também que existe alguns códigos de exemplo já para ser seguido se estiver com duvida sobre isso (Evite de criar coisas que não vá utilizar, exemplo getters e setters que não tem utilizadade). Outra coisa, evite o máximo de reinventar rotas, utilize tudo que a ferramenta/framework tem para o ferecer e facilita e lógico, sempre tente deixar a documentação que você utilizou de referência.

### 2. Posso adicionar novas dependências?
Sim, desde que não quebre o código ou entre em interferência com outras coisas do projeto.

### 3. OBS.
POR FAVOR, tente documentar as coisas com o próprio nome da classe ou métodos. Exemplo do que não fazer:

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
        *   Se algueém passar 1 + 1 vai returnar 2.
        */
        return primeiroValor + segundoValor;
    }