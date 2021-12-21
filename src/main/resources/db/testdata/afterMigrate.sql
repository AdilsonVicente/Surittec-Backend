set foreign_key_checks = 0;

delete from grupo;
delete from grupo_permissao;
delete from permissao;
delete from usuario;
delete from usuario_grupo;
delete from oauth_client_details;

set foreign_key_checks = 1;

alter table grupo auto_increment = 1;
alter table permissao auto_increment = 1;
alter table usuario auto_increment = 1;

insert into permissao (id, nome, descricao) values (1, 'ADMINISTRADOR', 'Permissão total no sistema');
insert into permissao (id, nome, descricao) values (2, 'CONSULTAR', 'Permissão de visualização dos dados');

insert into grupo (id, nome) values (1, 'Admin'), (2, 'Comum');

insert into grupo_permissao (grupo_id, permissao_id) values (1, 1), (2, 2); 

insert into usuario (id, nome, email, senha, data_cadastro) values
(1, 'Admin', 'admin@surittec.com', '123456', utc_timestamp),
(2, 'Comum', 'comum@surittec.com', '123456', utc_timestamp);

insert into usuario_grupo (usuario_id, grupo_id) values (1, 1), (2, 2);

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
