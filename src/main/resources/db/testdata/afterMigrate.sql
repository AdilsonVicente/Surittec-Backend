set foreign_key_checks = 0;

delete from grupo;
delete from grupo_permissao;
delete from permissao;
delete from usuario;
delete from endereco;
delete from email;
delete from telefone;
delete from cliente;
delete from usuario_grupo;
delete from oauth_client_details;


set foreign_key_checks = 1;

alter table grupo auto_increment = 1;
alter table permissao auto_increment = 1;
alter table usuario auto_increment = 1;
alter table cliente auto_increment = 1;
alter table endereco auto_increment = 1;
alter table telefone auto_increment = 1;
alter table email auto_increment = 1;

insert into permissao (id, nome, descricao) values (1, 'ADMINISTRADOR', 'Permissão total no sistema');
insert into permissao (id, nome, descricao) values (2, 'CONSULTAR', 'Permissão de visualização dos dados');

insert into grupo (id, nome) values (1, 'Admin'), (2, 'Comum');

insert into grupo_permissao (grupo_id, permissao_id) values (1, 1), (1, 2), (2, 2); 

insert into usuario (id, nome, email, senha, data_cadastro) values
(1, 'admin', 'admin@surittec.com', '$2a$10$WBZWSPPeAmKLOdtF4cnMRubWaop6yviB7w97hujmKi9YvEhw3dp2W', utc_timestamp),
(2, 'comum', 'comum@surittec.com', '$2a$10$WBZWSPPeAmKLOdtF4cnMRubWaop6yviB7w97hujmKi9YvEhw3dp2W', utc_timestamp);

insert into usuario_grupo (usuario_id, grupo_id) values (1, 1), (1, 2), (2, 2);


insert into endereco (id, cep, logradouro, bairro, cidade, uf, complemento) values (1, '86860000', 'Rua Central', 'Central', 'Apucarana', 'PR', '');

insert into cliente (id, nome, cpf, endereco_id) values (1, 'surittec', '34567898721', 1);

insert into telefone (id, numero, cliente_id, tipoTelefone) values (1, '439965487895', 1, 'CELULAR');
insert into telefone (id, numero, cliente_id, tipoTelefone) values (2, '433456484949', 1, 'COMERCIAL');

insert into email (id, emailAddress, cliente_id) values (1, 'surittec@teste.com', 1);
insert into email (id, emailAddress, cliente_id) values (2, 'surittec2@teste.com', 1);

insert into oauth_client_details (
  client_id, resource_ids, client_secret, 
  scope, authorized_grant_types, web_server_redirect_uri, authorities,
  access_token_validity, refresh_token_validity, autoapprove
)
values (
  'surittec-web', null, '$2y$12$w3igMjsfS5XoAYuowoH3C.54vRFWlcXSHLjX7MwF990Kc2KKKh72e',
  'READ,WRITE', 'password', null, null,
  60 * 60 * 6, 60 * 24 * 60 * 60, true
);

insert into oauth_client_details (
  client_id, resource_ids, client_secret, 
  scope, authorized_grant_types, web_server_redirect_uri, authorities,
  access_token_validity, refresh_token_validity, autoapprove
)
values (
  'surittec', null, '$2y$12$w3igMjsfS5XoAYuowoH3C.54vRFWlcXSHLjX7MwF990Kc2KKKh72e',
  'READ,WRITE', 'authorization_code', null, null,
  null, null, true
);
