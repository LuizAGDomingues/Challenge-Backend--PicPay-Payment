
# PicPay transaction JAVA

Projeto desenvolvido para fins educativos. Microserviço de pagamentos em JAVA com Spring utilizando banco de dados local, clean code e teste unitários. Este projeto teve como início um teste técnico antigo da empresa PicPay e foi feito seguindo seus objetivos.


## Referência

- [Repositório PICPAY](https://github.com/PicPay/picpay-desafio-backend)


## Stack utilizada

**Back-end:** Java


## Documentação da API

#### Criar usuário

```http
  POST /users
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `firstName` | `string` | **Obrigatório**. Primeiro nome do usuário |
| `lastName` | `string` | **Obrigatório**. Último nome do usuário |
| `document` | `string` | **Obrigatório**. Documento do usuário |
| `password` | `string` | **Obrigatório**. Senha do usuário |
| `email` | `string` | **Obrigatório**. Email do usuário |
| `userType` | `string` | **Obrigatório**. Tipo de do usuário (COMMON, MERCHANT) |
| `balance` | `number` | **Obrigatório**. Saldo em conta do usuário |

#### Criar transação

```http
  POST /transactions
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `senderId` | `string` | **Obrigatório**. ID do usuário que irá enviar o valor |
| `receiverId` | `string` | **Obrigatório**. ID do usuário que irá receber o valor |
| `value` | `number` | **Obrigatório**. Valor da transação |

#### Listar usuários

```http
  POST /users
```


## Autor

- [@LuizAGDomingues](https://github.com/LuizAGDomingues)

