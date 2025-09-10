# Estrutura de Dados: Vetores

O **vetor** é uma estrutura de dados que armazena uma sequência de valores do mesmo tipo. Eles podem parecer rígidos, mas é essa rigidez que garante sua performance. Com essa estrutura, torna-se fácil prever onde cada valor está localizado.

Vamos imaginar a criação de um **vetor** de `inteiros` com `5` "espaços". Além disso, considere que cada inteiro ocupe um `tamanho 3` em memória — guarde as facas das críticas técnicas, estou usando uma abstração simplista, mas não menos precisa. Isso faz com que o computador reserve um espaço contínuo de memória, como, por exemplo, o `endereço de memória` de `20 a 34` (se o primeiro começa em 20, teremos 5 caixas de tamanho 3, ocupando as posições 20, 23, 26, 29 e 32). O **vetor**, por sua vez, armazena o endereço inicial de cada elemento.

> A criação dessas "caixas" com tamanho fixo justifica o porquê de um **vetor** possuir somente um tipo de dado. Caso tivesse tipos diferentes, as caixas teriam tamanhos diferentes, quebrando a lógica de acesso rápido.

Para que o computador busque o valor de uma das `caixas`, basta pegar o endereço inicial do vetor e somar o deslocamento (índice multiplicado pelo `tamanho do nosso inteiro`). Essa é a mágica dos **vetores**: por terem itens de um só tipo, todos armazenados um ao lado do outro, fica fácil e rápido recuperar qualquer valor. O ganho de performance não se limita à operação de leitura, mas também à de escrita. Ao comandar "guarde o valor *7* na caixa *1*", o sistema operacional consegue localizar facilmente onde ela se encontra.

Além disso, uma vez criado, um vetor tradicional não pode ter seu tamanho alterado.

Algumas linguagens de programação criam estruturas de dados baseadas em vetores, como listas dinâmicas. Essas abstrações permitem alterar o tamanho e, em alguns casos, adicionar tipos diferentes de dados, mas tudo isso tem um custo computacional. Quando elas "alteram" o tamanho de um vetor, o que realmente acontece nos bastidores é a criação de um novo vetor com o tamanho desejado e a cópia dos dados do antigo para o novo. Já quando permitem tipos diferentes, uma das estratégias é usar o tamanho do maior item como padrão para todas as "caixas". Para ficar um pouco mais palatável: se o primeiro item tem tamanho 2, o segundo 4 e o terceiro 6, o sistema criaria três caixas, todas com tamanho 6.

> Ao tentar quebrar a rigidez dos vetores, adicionamos uma carga computacional maior, consumindo mais recursos nas operações de escrita, leitura e no armazenamento dos valores.

## Adicionar

Existem algumas estratégias para adicionar elementos em um vetor. Pensando logicamente, podemos, por exemplo, usar um `for` percorrendo todo o vetor até localizar uma posição (*caixa*) vazia e colocar o valor nela:

```java
public void adicionar(String elemento) {
    for (int i = 0; i < this.elementos.length; i++) {
        if (this.elementos[i] == null) {
            this.elementos[i] = elemento;
            break;
        }
    }
}
```

À primeira vista essa solução parece boa, mas perceba que essa lógica tem um custo computacional relativamente alto. Sempre que adicionamos um item, precisamos percorrer o vetor procurando uma posição vazia, mesmo que já saibamos onde o próximo elemento deveria estar.

Uma solução mais eficiente é manter uma variável `tamanho`, que armazena o total de elementos já presentes no vetor. Assim, não precisamos percorrer todas as posições: basta inserir diretamente no índice correspondente ao `tamanho`. A lógica fica assim:

```java
public void adicionar(String elemento) {
    if (this.tamanho < this.elementos.length) {
        this.elementos[this.tamanho] = elemento;
        this.tamanho++;
    } else {
        throw new ArrayIndexOutOfBoundsException();
    }
}
```

Dessa forma não percorremos o vetor todas as vezes. Caso tentemos inserir além do limite, a função lançará uma exceção.

Outra alternativa é usar o mesmo princípio, mas, em vez de lançar uma exceção, retornar um valor booleano indicando se a inserção foi bem-sucedida:

```java
public boolean adicionar(String elemento) {
    if (this.tamanho < this.elementos.length) {
        this.elementos[this.tamanho] = elemento;
        this.tamanho++;
        return true;
    } else {
        return false;
    }
}
```

## Tamanho e toString

Podemos criar alguns métodos auxiliares para o nosso vetor. É comum vermos os métodos `size` e `toString` já implementados nas estruturas de dados fornecidas pelas linguagens de programação. Vamos criar os nossos.

O primeiro é o mais simples: no método `adicionar`, já criamos o atributo `tamanho`. Portanto, basta retorná-lo:

```java
public int tamanho() {
    return this.tamanho;
}
```

Já o método `toString` pode ser implementado de diferentes formas. Uma opção seria utilizar o método `toString` da classe utilitária `Arrays`. Outra seria concatenar as strings manualmente.

A primeira abordagem, apesar de prática, não é a mais interessante, pois exibiria todos os elementos do vetor, inclusive as posições que ainda não foram preenchidas.
A segunda opção (concatenar diretamente com `String`) também não é recomendada, pois em Java as strings são imutáveis. Isso significa que cada concatenação cria um novo objeto em memória, o que traz um custo desnecessário.

A solução mais eficiente é utilizar a classe `StringBuilder`, que permite a construção incremental de strings sem esse custo adicional. Veja o exemplo:

```java
@Override
public String toString() {
    var s = new StringBuilder();
    s.append("[");
    for (int i = 0; i < this.tamanho - 1; i++) {
        s.append(this.elementos[i]).append(", ");
    }
    s.append(this.elementos[this.tamanho - 1]).append("]");
    return s.toString();
}
```

## Referências

- [Loiane Groner - Estrutura de Dados e Algoritmos com Java](https://www.youtube.com/watch?v=N3K8PjFOhy4&list=PLGxZ4Rq3BOBrgumpzz-l8kFMw2DLERdxi&ab_channel=LoianeGroner)
- [Franklyn Sancho - Vetores e matrizes (Estrutura de dados)](https://franklyn-sanc.medium.com/vetores-e-matrizes-estrutura-de-dados-375c87832f34)
- [Ramon Sorage](https://medium.com/@rsorage/arrays-a-base-da-organiza%C3%A7%C3%A3o-de-dados-9749827e1e5f)
- [Ryan Sczayka](https://medium.com/@ryan_sczayka/estrutura-de-dados-arrays-e62b8359a27f)
