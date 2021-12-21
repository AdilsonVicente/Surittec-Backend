create table cliente (
	id bigint not null auto_increment,
	nome varchar(60) not null,
	cpf varchar(60) not null,
	endereco_id bigint not null,
	email_id bigint not null,
	telefone_id bigint not null,
	
	primary key (id)
) engine=InnoDB default charset=utf8;

create table cliente_email (
	cliente_id bigint not null,
	email_id bigint not null,
	
	primary key (cliente_id, email_id)
) engine=InnoDB default charset=utf8;

create table email (
	id bigint not null auto_increment,
	emailAddress varchar(60) not null,
	cliente_id bigint not null,
	
	primary key (id)
) engine=InnoDB default charset=utf8;

create table endereco (
	id bigint not null auto_increment,
	cliente_id bigint not null,
	cep varchar(80) not null,
	logradouro varchar(255) not null,
	bairro varchar(255) not null,
	cidade varchar(255) not null,
	uf varchar(255) not null,
	complemento varchar(255),
	
	primary key (id)
) engine=InnoDB default charset=utf8;

create table cliente_endereco (
	cliente_id bigint not null,
	endereco_id bigint not null,
	
	primary key (cliente_id, endereco_id)
) engine=InnoDB default charset=utf8;

create table telefone (
	id bigint not null auto_increment,
	numero varchar(60) not null,
	cliente_id bigint not null,
	tipoTelefone varchar(60) not null,
	
	primary key (id)
) engine=InnoDB default charset=utf8;

create table cliente_telefone (
	cliente_id bigint not null,
	telefone_id bigint not null,
	
	primary key (cliente_id, telefone_id)
) engine=InnoDB default charset=utf8;


alter table cliente_email add constraint fk_cliente_email_email
foreign key (email_id) references email (id);

alter table cliente_email add constraint fk_cliente_email_cliente
foreign key (cliente_id) references cliente (id);

alter table cliente_endereco  add constraint fk_cliente_endereco_endereco
foreign key (endereco_id) references endereco (id);

alter table cliente_endereco add constraint fk_cliente_endereco_cliente
foreign key (cliente_id) references cliente (id);

alter table cliente_telefone  add constraint fk_cliente_telefone_telefone
foreign key (telefone_id) references telefone (id);

alter table cliente_telefone add constraint fk_cliente_telefone_cliente
foreign key (cliente_id) references cliente (id);



