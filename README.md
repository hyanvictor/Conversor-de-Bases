# 🔢 Calculadora de Bases Numéricas

Projeto desenvolvido em Java com o objetivo de estudar e aplicar conceitos de **bases numéricas, conversão de valores, algoritmos, validação de entradas e lógica de programação**.

O projeto permite trabalhar com números nas bases **binária, octal, decimal e hexadecimal**, realizando conversões entre elas.

> 🚧 Projeto em desenvolvimento.

---

## 📌 Sobre o projeto

A ideia surgiu a partir de uma atividade acadêmica da disciplina de Ciência da Computação, cujo conteúdo envolve:

- Sistemas de numeração;
- Conversão entre bases;
- Operações em diferentes bases;
- Código ASCII;
- Código BCD;
- Código Gray;
- EBCDIC;
- Excesso 3;
- Álgebra Booleana;
- Portas lógicas;
- Tabelas-verdade;
- Simplificação de expressões Booleanas;
- Mapas de Karnaugh.

Neste primeiro momento, o projeto está concentrado no desenvolvimento do **conversor de bases numéricas**, servindo também como exercício prático de programação em Java.

---

## 🎯 Objetivos

### Objetivo principal

Desenvolver uma aplicação capaz de converter números entre diferentes bases numéricas, utilizando algoritmos próprios para realizar as conversões.

### Objetivos secundários

- Praticar lógica de programação;
- Trabalhar com `String`, `char` e valores numéricos;
- Desenvolver algoritmos de conversão;
- Praticar estruturas de repetição e decisão;
- Trabalhar com listas e manipulação de dados;
- Aprender a validar entradas do usuário;
- Separar responsabilidades dentro do código;
- Desenvolver uma interface gráfica em Java;
- Praticar testes e tratamento de casos de erro.

---

# 🔢 Bases suportadas

Inicialmente, o sistema trabalhará com quatro bases:

| Base | Nome | Dígitos permitidos |
|------|------|--------------------|
| 2 | Binário | `0` e `1` |
| 8 | Octal | `0` a `7` |
| 10 | Decimal | `0` a `9` |
| 16 | Hexadecimal | `0` a `9` e `A` a `F` |

### Exemplos

```text
Binário:      101101
Octal:        55
Decimal:      45
Hexadecimal:  2D
```


⚙️ Como funciona

O sistema utiliza uma abordagem intermediária para realizar as conversões.

Em vez de implementar uma conversão específica para cada combinação de bases:

Binário → Octal
Binário → Hexadecimal
Octal → Binário
Hexadecimal → Octal
...

🖥️ Interface planejada

A interface deverá possuir campos separados para cada base:

<img width="410" height="206" alt="image" src="https://github.com/user-attachments/assets/6a632442-de7a-40dd-9531-17eeb97256ed" />


O usuário poderá inserir o valor em qualquer campo.

Por exemplo, ao inserir:

45

no campo decimal, os demais campos deverão ser atualizados automaticamente:

Binário:      101101
Octal:        55
Decimal:      45
Hexadecimal:  2D
🚨 Validação

Cada base possui um conjunto específico de caracteres permitidos.

Exemplo:

Binário
101010 → válido
102010 → inválido
Octal
127 → válido
128 → inválido
Decimal
12345 → válido
12A45 → inválido
Hexadecimal
2D → válido
AF → válido
2G → inválido

Quando uma entrada inválida for identificada, a interface deverá indicar o erro ao usuário.

Exemplo:

[ 2G ]

     ↑
   inválido
➕ Operações

Após a implementação das conversões, o projeto deverá receber suporte a operações matemáticas.

A ideia é permitir operações independentemente da base utilizada.

Por exemplo:

1010₂ + 2D₁₆

Internamente:

1010₂ → 10₁₀
2D₁₆  → 45₁₀

10 + 45 = 55

E o resultado poderá ser apresentado nas demais bases:

Decimal:      55
Binário:      110111
Octal:        67
Hexadecimal:  37

🧪 Testes planejados

Alguns casos utilizados para verificar os algoritmos:

Conversão para decimal:

1010₂ → 10₁₀
1011₂ → 11₁₀
55₈   → 45₁₀
2D₁₆  → 45₁₀
FF₁₆  → 255₁₀

Conversão a partir do decimal:

10₁₀  → 1010₂
11₁₀  → 1011₂
45₁₀  → 55₈
45₁₀  → 2D₁₆
255₁₀ → FF₁₆

Casos de borda:

0
1
7
8
9
10
15
16
255
256

Entradas inválidas:

102      → inválido em binário
128      → inválido em octal
12A      → inválido em decimal
2G       → inválido em hexadecimal

🛠️ Tecnologias:

Java
Java Collections
Interface gráfica Java (a definir entre Swing/JavaFX)

👨‍💻 Autor

Hyan

Projeto desenvolvido para fins acadêmicos e de estudo em Ciência da Computação.
