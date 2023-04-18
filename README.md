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
    
    
Por enquanto a transação está sendo criada passando a quantidade, id do livro e id da pessoa na Url como mostrado a seguir

      http://localhost:8080/api/transacao/49-2-2
      
      
Projeto ainda está em desenvolvimento e ainda irá receber uma série de modificações como inserção de imagens, validações e notificação.

Testes automatizados também serão realizados neste projeto futuramente.
