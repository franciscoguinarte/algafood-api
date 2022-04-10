-- COZINHAS
insert into cozinha (id,nome) values (1,'Tailandesa');
insert into cozinha (id,nome) values (2,'Indiana');

-- RESTAURANTES
insert into restaurante (nome,taxa_frete,cozinha_id) values ('Tailandia Comidinhas', 123.41,1);
insert into restaurante (nome,taxa_frete,cozinha_id) values ('India Food', 22.41,2);

-- PERMISSAO
insert into permissao (nome,descricao) values ('Permissao nivel 1','Permite acessar os dados de banco');
insert into permissao (nome,descricao) values ('Permissao nivel 2','Permite acessar e modificar os dados de banco');

-- FORMA PAGAMENTO
insert into forma_pagamento (descricao) values ('Cartao de Credito');
insert into forma_pagamento (descricao) values ('Cartao de Debito');

-- ESTADO
insert into estado (id,nome) values (1,'Nova Deli');
insert into estado (id,nome) values (2,'Amazonas');

-- CIDADE
insert into cidade (nome,estado_id) values ('Bali',1);
insert into cidade (nome,estado_id) values ('Manaus',2);
