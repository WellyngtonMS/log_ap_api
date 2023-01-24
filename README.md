## Tarefa 1: Desenvolver uma API

Você deverá desenvolver uma API (Restful) simples que receba uma requisição HTTP com uma string, e encontre o primeiro caractere Vogal, após uma consoante, onde a mesma é antecessora a uma vogal e que não se repita na string.

Premissas:

Não será possível reiniciar o fluxo da leitura da string.
Na tarefa 1 não poderá ser utilizado nenhuma lib, apenas código nativo na identificação da vogal.

Exemplo:

Input: aAbBABacafe
Output: e

No exemplo, ‘e’ é o primeiro caractere Vogal da stream que não se repete após a primeira Consoante ‘f’ o qual tem uma vogal ‘a’ como antecessora.

E o resultado do processamento deverá ser igual à:
```json
{
  "string": " aAbBABacafe",
  "vogal": "e",
  "tempoTotal": "10ms"
}
```

No desenvolvimento desta API foram utilizados as tecnologias:

- Spring Boot
- JavaSE 8
- Banco H2
- Maven
