create table oauth_client_details (
	client_id varchar(255),
	resource_ids varchar(255),
	client_secret varchar(255),
	scope varchar(255),
	authorized_grant_types varchar(255),
	web_server_redirect_uri varchar(255),
	authorities varchar(255),
	access_token_validity integer,
	refresh_token_validity integer,
	additional_information varchar(255),
	autoapprove varchar(255),
	
	primary key (client_id)
) engine=innodb default charset=utf8;