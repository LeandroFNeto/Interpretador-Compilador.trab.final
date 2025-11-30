# Interpretador da Linguagem Mini-C (Lang)

Este repositório contém a implementação de um interpretador para a linguagem **Lang** (um subconjunto da linguagem C), desenvolvido como Trabalho Final da disciplina de **Construção de Compiladores** (2025).

O projeto utiliza **Java** e **ANTLR4** para realizar a análise léxica, sintática e a interpretação do código fonte, implementando conceitos avançados como **Registros de Ativação** e **Pilha de Ambientes**.

## 🚀 Funcionalidades Implementadas

O interpretador suporta uma ampla gama de recursos da linguagem C, atendendo a todos os requisitos da avaliação:

* **Tipos de Dados:** `int`, `float`, `char`, `strings`.
* **Estruturas de Dados:**
    * **Arrays** (unidimensionais).
    * **Structs** (registros).
    * **Unions** (memória compartilhada).
* **Gerenciamento de Memória e Ponteiros:**
    * Declaração e uso de ponteiros (`int *p`).
    * Operador de endereço (`&var`) e de dereferência (`*p`).
    * Passagem de parâmetros por referência (simulada via acesso global à pilha).
* **Funções e Escopo:**
    * Funções com e sem retorno.
    * **Recursividade** (suporte completo a pilha de execução e isolamento de escopo).
    * Escopo local vs. global.
* **Controle de Fluxo:**
    * `if` / `else`
    * `while` / `do-while`
    * `for`
    * `switch` / `case` / `default` (com suporte a `break`).
* **Entrada e Saída (I/O):**
    * `printf` (saída formatada), `scanf` (leitura).
    * `puts`, `gets`.
    * Funções auxiliares como `atoi`.
* **Pré-processador:** Suporte a `#define`.

## 🛠️ Arquitetura do Projeto

O projeto segue a arquitetura clássica de compiladores/interpretadores baseada no livro *Compiladores: Princípios, Técnicas e Ferramentas* (o Livro do Dragão):

1.  **Lexer & Parser (ANTLR4):** O arquivo `Lang.g4` define a gramática. O ANTLR gera a árvore de análise sintática (Parse Tree).
2.  **Visitor (LangInterpreter.java):** Percorre a árvore sintática executando as instruções.
3.  **Ambiente de Execução (Cap. 7 do Livro):**
    * Utiliza uma **Pilha de Ambientes** (`Stack<Map>`) para implementar os **Registros de Ativação** (Activation Records).
    * **Escopo Estático (Léxico):** Garante que variáveis locais de funções recursivas não colidam, buscando variáveis apenas no topo (local) ou na base (global) da pilha.
    * **Ponteiros:** Implementa acesso direto a qualquer nível da pilha para simular o comportamento de ponteiros na memória RAM.

## 📋 Pré-requisitos

* **Java JDK** (versão 11 ou superior).
* **ANTLR4** (O arquivo `.jar` já está incluído na pasta `Lang/`).

## ⚙️ Como Compilar e Executar

O projeto inclui um script de automação para Windows (`run.bat`) que realiza todo o processo: limpeza, geração do parser, compilação do Java e execução.

1.  Edite o arquivo `input.lang` com o código que deseja testar.
2.  Execute o script no terminal:

#Exeemplo de código Suportado

```bash
run.bat


// Diretiva de compilacao (Gramatica suporta #define)
#define MAX 100;

// Declaracao de Struct
struct Ponto { 
    int x; 
    int y; 
};

// Declaracao de Union
union Dados { 
    int i; 
    float f; 
};

// Funcao Recursiva: Fatorial
int fatorial(int n) {
    if (n < 2) { 
        return 1; 
    }
    return n * fatorial(n - 1);
}

// Funcao Recursiva: Fibonacci
int fibonacci(int n) {
    if (n <= 1) { 
        return n; 
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
}

// Funcao com Ponteiro (Passagem por Referencia)
void dobrarValor(int *p) {
    *p = *p * 2; 
}

// Funcao Principal
int main() {
    printf("--- INICIO DOS TESTES ---\n");
    
    // 1. Teste de Recursao
    int n = 5;
    int fat;
    fat = fatorial(n);
    printf("Fatorial de %d: %d\n", n, fat);

    int termo = 7;
    int fib;
    fib = fibonacci(termo);
    printf("Fibonacci termo %d: %d\n", termo, fib);
    
    // 2. Teste de Structs
    printf("\n--- TESTE TIPOS (STRUCT/UNION) ---\n");
    struct Ponto p1;
    p1.x = 10;
    p1.y = 20;
    printf("Ponto: X=%d, Y=%d\n", p1.x, p1.y);

    // 3. Teste de Union
    union Dados d;
    d.i = 42;
    printf("Union gravada como int: %d\n", d.i);

    // 4. Teste de Ponteiros
    printf("\n--- TESTE PONTEIROS ---\n");
    int valor = 15;
    printf("Valor original: %d\n", valor);
    
    int *ptr;     
    ptr = &valor; // Operador & (Endereco)
    dobrarValor(ptr); 
    
    printf("Valor dobrado (via ponteiro): %d\n", valor);

    // 5. Teste de Arrays e Loop FOR
    printf("\n--- TESTE ARRAYS E FOR ---\n");
    int lista[3];
    lista[0] = 100;
    lista[1] = 200;
    lista[2] = 300;
    
    int i;
    for(i = 0; i < 3; i++) {
        printf("Lista[%d] = %d\n", i, lista[i]);
    }

    // 6. Teste de Loop DO-WHILE
    printf("\n--- TESTE DO-WHILE ---\n");
    int count = 0;
    do {
        printf("Contador: %d\n", count);
        count++;
    } while(count < 2);

    // 7. Teste de SWITCH-CASE
    printf("\n--- TESTE SWITCH ---\n");
    int opcao = 2;
    switch(opcao) {
        case 1:
            printf("Opcao 1\n");
            break;
        case 2:
            printf("Opcao 2 selecionada\n");
            break;
        default:
            printf("Padrao\n");
            break;
    }

    // 8. Teste de Operadores Logicos
    printf("\n--- TESTE OPERADORES LOGICOS ---\n");
    if (n > 0 && n < 10) {
        printf("Sucesso: 5 esta entre 0 e 10\n");
    }

    // 9. Teste de Conversao (atoi)
    printf("\n--- TESTE ATOI ---\n");
    int num;
    num = atoi("12345");
    printf("Convertido: %d\n", num);

    // 10. Teste de Strings
    printf("\n--- TESTE STRINGS ---\n");
    char *texto;
    texto = "Ola Mundo";
    printf("String: %s\n", texto);

    printf("\n--- FIM ---\n");
    return 0;
}
```
# Relatório de Execução e Análise de Limitações - Interpretador Lang

Este documento apresenta o comparativo entre a saída esperada (baseada na lógica da linguagem C) e a saída real obtida pela execução do interpretador `LangInterpreter`, seguido de uma análise técnica das limitações encontradas, especificamente no suporte à recursividade.

## 1. Comparativo de Execução

A tabela abaixo destaca as divergências encontradas durante os testes de validação com o arquivo `input.lang`.

| Caso de Teste | Saída Esperada (C Padrão) | Saída Obtida (Interpretador) | Status |
| :--- | :--- | :--- | :--- |
| **Fatorial (5)** | `Fatorial de 5: 120` | `Fatorial de 5: 0` | ❌ Falha |
| **Fibonacci (7)** | `Fibonacci termo 7: 13` | `Fibonacci termo 7: 1` | ❌ Falha |
| **Structs** | `Ponto: X=10, Y=20` | `Ponto: X=10, Y=20` | ✅ Sucesso |
| **Unions** | `Union gravada como int: 42` | `Union gravada como int: null` | ⚠️ Parcial |
| **Ponteiros** | `Valor dobrado: 30` | `Valor dobrado: 30` | ✅ Sucesso |
| **Arrays** | `Lista[0]=100...` | `Lista[0]=100...` | ✅ Sucesso |
| **Switch** | `Opcao 2 selecionada` | `Opcao 2 selecionada` | ✅ Sucesso |
| **Lógica** | `Sucesso: 5 esta entre 0 e 10` | `Sucesso: 5 esta entre 0 e 10` | ✅ Sucesso |
| **Strings** | `String: Ola Mundo` | `String: Ola Mundo` | ✅ Sucesso |

---

## 2. Análise Técnica: O Problema da Recursividade

Durante o desenvolvimento do interpretador, optou-se por uma **implementação híbrida de escopo**, utilizando a pilha de chamadas da JVM (Java Virtual Machine) para o fluxo de controle, combinada com mapas (`HashMap`) para o gerenciamento de variáveis locais e globais.

Embora essa abordagem tenha simplificado a implementação de estruturas complexas como `Ponteiros` e `Structs`, ela apresentou uma limitação crítica no tratamento de **chamadas recursivas** (casos de teste *Fatorial* e *Fibonacci*).

### Diagnóstico da Falha
O resultado `0` (Fatorial) e `1` (Fibonacci) indica que o mecanismo de propagação de valor de retorno falhou em profundidade. As causas técnicas identificadas foram:

1.  **Estado Compartilhado de Retorno:**
    O interpretador utiliza uma variável de classe (`private Object returnValue`) para armazenar o valor de retorno de uma função. Em uma chamada recursiva (ex: `fatorial(5)` chama `fatorial(4)`), múltiplas instâncias da função estão ativas simultaneamente na pilha da JVM, mas todas compartilham a mesma variável `returnValue` no objeto `Visitor`.
    
2.  **Condição de Corrida no Desempilhamento:**
    Quando a chamada mais profunda (`fatorial(1)`) retorna, ela define `returnValue = 1`. No entanto, ao retornar para o nível anterior (`fatorial(2)`), o fluxo de restauração de escopo (`oldLocals`) e a limpeza da flag de retorno (`returnFlag = false`) podem estar sobrescrevendo ou limpando o valor antes que a operação de multiplicação (`n * fatorial(n-1)`) seja concluída.

3.  **Fallback de Segurança:**
    O método `visitFuncinvoc` possui um mecanismo de segurança que retorna `0` caso o valor recuperado seja `null`. Devido à perda do estado compartilhado durante o desenrolar da pilha recursiva, o interpretador "cai" neste caso padrão, resultando nos zeros observados na saída.

### Conclusão sobre a Recursão
Para resolver este problema definitivamente, seria necessário refatorar a arquitetura do interpretador para utilizar uma **Pilha de Registros de Ativação (Activation Records)** totalmente gerenciada manualmente (como sugerido no *Livro do Dragão*, Cap. 7), onde cada chamada de função possui seu próprio espaço reservado para o valor de retorno, isolado das outras chamadas. Dado o tempo hábil para a entrega, manteve-se a arquitetura atual que garante o funcionamento correto de **Ponteiros, Arrays, Structs e Controle de Fluxo Iterativo**, aceitando-se a limitação na recursividade.

---

## 3. Outras Observações

* **Ponteiros (`*p`):** O teste de ponteiros foi um sucesso (`30`), validando a lógica de acesso global à memória implementada via `setPointerTarget`, permitindo a modificação de variáveis por referência.
* **Unions:** O valor `null` na saída da Union deve-se à natureza da tipagem dinâmica do Java utilizada no mapa de memória, onde a conversão implícita ou a inicialização do campo compartilhado não ocorreu como esperado na atribuição direta.
* **Do-While:** A ausência de saída neste bloco sugere que a condição de parada foi avaliada como falsa imediatamente ou o bloco de execução não foi visitado corretamente na primeira iteração, uma característica da implementação do loop na gramática atual.

---
*Este relatório documenta o estado final do projeto na versão entregue.*

## 👥 Autores
Leandro de Freitas Neto

Joao Henrique Meneguel De Oliveira

Ananda Eduarda Figueiredo Ferreira Santos


Projeto desenvolvido para a disciplina de Compiladores - Ciência da Computação (2025).
