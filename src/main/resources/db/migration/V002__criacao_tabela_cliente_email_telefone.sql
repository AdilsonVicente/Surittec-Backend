create table endereco (
	id bigint not null auto_increment,
	cep varchar(80) not null,
	logradouro varchar(255) not null,
	bairro varchar(255) not null,
	cidade varchar(255) not null,
	uf varchar(255) not null,
	complemento varchar(255),
	
	primary key (id)
) engine=InnoDB default charset=utf8;

create table cliente (
	id bigint not null auto_increment,
	nome varchar(60) not null,
	cpf varchar(60) not null,
	endereco_id bigint not null,
	
	primary key (id)
) engine=InnoDB default charset=utf8;

create table email (
	id bigint not null auto_increment,
	emailAddress varchar(60) not null,
	cliente_id bigint not null,
	
	primary key (id)
) engine=InnoDB default charset=utf8;

create table telefone (
	id bigint not null auto_increment,
	numero varchar(60) not null,
	cliente_id bigint not null,
	tipoTelefone varchar(60) not null,
	
	primary key (id)
) engine=InnoDB default charset=utf8;


alter table telefone add constraint fk_telefone_cliente
foreign key (cliente_id) references cliente (id);

alter table email add constraint fk_email_cliente
foreign key (cliente_id) references cliente (id);

alter table cliente  add constraint fk_cliente_endereco
foreign key (endereco_id) references endereco (id);


