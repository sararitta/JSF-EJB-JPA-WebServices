create sequence seqdepartamento;

create table cadastroos (
cod numeric(6),
descricaoEquipamento varchar(200) not null,
marca varchar(200),
modelo varchar(200),
outros varchar(200),
descricaoProblemaInformado varchar(200),
descricaoProblemaDetectado varchar(200),
valorConserto numeric(10),
dtentrada date DEFAULT now(),
dtsaida date,
consertorealizado CHAR(1) NOT NULL DEFAULT 'N',
codcliente numeric(6),
primary key (cod),
CHECK (consertorealizado='S' or consertorealizado='N'));

create sequence seqfuncionario;

create table cliente (
cod numeric(6),
nome varchar(200) not null,
sobrenome varchar(100),
dtnascimento date not null,
endereco varchar(200) not null,
contatoCel varchar(12) not null,
contatoFixo varchar(12),
codOS numeric(6),
primary key (cod),
foreign key (codOS) references cadastroOS(cod));

create table usuario (
    cod  numeric(6),
    login varchar(20) unique,
    senha varchar(200),
    primary key (cod));
create sequence seqmensagem;

create table produto (
    cod  numeric(6),
    nome varchar(50) unique,
    marca varchar(200),
    modelo varchar(200),
valorCompra numeric(10) not null,
valorRevenda numeric(10),
    primary key (cod));


create table mensagem (
  cod numeric(6) default nextval('seqmensagem'),
  titulo varchar(50) not null,  
  texto varchar(200) not null,
  link varchar(300),
  codusuario numeric(6),
  primary key (cod),
  foreign key (codusuario) references usuario(cod));
create sequence sequpload;

create table upload (
  cod numeric(6) default nextval('sequpload'),
  nome varchar(200) not null,  
  contenttype varchar(200),
  conteudo bytea,
  primary key (cod));

insert into usuario values (1,'root','123');
insert into usuario values (2,'admin','123');

insert into mensagem (titulo ,texto, link)
values ('Mundos virtuais são tema de dissertação','Os mundos virtuais, embora não físicos, também são reais e podem ser úteis...','http://www.ucpel.tche.br/portal/index.php?secao=noticias&id=3373');

insert into mensagem (titulo ,texto, link)
values ('UCPel e Procergs firmam parceria','A Universidade Católica de Pelotas (UCPel) e a Companhia de Processamento de Dados...','http://www.ucpel.tche.br/portal/index.php?secao=noticias&id=3730');

insert into mensagem (titulo ,texto, link)
values ('COB exalta classificação do Basquete','O Comitê Olímpico Brasileiro recebeu com muita alegria a classificação da Seleção...','http://www.cbb.com.br/noticias/showrelease.asp?artigo=8875');

insert into mensagem (titulo ,texto, link,codusuario)
values ('Scala (linguagem de programação)','Scala (Scalable language) é uma linguagem de programação de propósito geral...','http://pt.wikipedia.org/wiki/Scala_%28linguagem_de_programa%C3%A7%C3%A3o%29',1);



