# e-commerce_API_Rest

Esse projeto tem como objetivo criar uma API Rest que faça o cadastro de produtos, 
usuários e transações para que o usuário possa escolher o produto, a quantidade e a forma de pagamento

Você pode cadastrar uma pessoa informando os dados a seguir no formato JSON

          {
      "nome": "João da Silva",
      "nascimento": "1990-01-01",
      "cpf": "123.456.789-00",
      "email": "joao.silva@gmail.com",
      "telefone": "(11) 1234-5678",
      "saldo": 1500.00
    }
    

E cadastrar um livro com o JSON a seguir

          {
      "nome": "Clean code",
      "preco": 49.9,
      "categoria": "LIVRO",
      "genero": "TERROR",
      "quantidade": 50,
      "escritor": "Tom Hanks",
      "editora": "Programmer"
    }
    
    
Para criar uma transação, você precisa passar o seguinte JSON com o método de requisição Post.

                {
            "idPessoa": 1,
            "lista": [
              {
                "idLivro": 1,
                "quantidade": 1,
                "precoUnitario": 49.9,
                "precoTotal": 99.8
              },
              {
                "idLivro": 2,
                "quantidade": 1,
                "precoUnitario": 49.9,
                "precoTotal": 99.8
              }
            ]
          }

A Entidade Transacao possui uma sub entidade chamada ItemTransacao que permite a compra de vários livros em uma única transação.
      
Para criar a transação, os DTOs que recebem os dados para criação da transação não permite que o idLivro, quantidade, precoUnitario e precoTotal cheguem com valores Null ou vazio.



Projeto ainda está em desenvolvimento e ainda irá receber uma série de modificações como inserção de imagens, notificação, validações de DTOs para as demais Entidades.

Testes automatizados também serão realizados neste projeto futuramente.
