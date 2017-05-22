INSERT INTO cliente (nome) values ('Fulano de Tal'), ('Ciclano de Tal'), ('Beltrano de Tal');

INSERT INTO produto (nome, preco) values ('Prod A', 12.1), ('Prod B', 234.55), ('Prod C', 21.3);

INSERT INTO pedidovenda (cliente_id) values (1),(2);

INSERT INTo itempedidovenda (qtd, pedidovenda_id, produto_id) values (12,1,1), (2,1,2), (23,2,1);