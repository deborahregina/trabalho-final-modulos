CREATE TABLE VEM_SER.CLIENTE (
ID_CLIENTE INT NOT NULL,
NOME VARCHAR2(255) NOT NULL,
CPF VARCHAR2(11) UNIQUE NOT NULL,
PRIMARY KEY (ID_CLIENTE)
);

CREATE SEQUENCE SEQ_CLIENTE
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

SELECT * FROM CLIENTE c 


INSERT INTO CLIENTE 
(ID_CLIENTE,NOME,CPF)
VALUES (SEQ_CLIENTE.NEXTVAL,'Camile Lopes','01829543728');

INSERT INTO CLIENTE 
(ID_CLIENTE,NOME,CPF)
VALUES (SEQ_CLIENTE.NEXTVAL,'Adriele Beatriz','90952329050');

INSERT INTO CLIENTE 
(ID_CLIENTE,NOME,CPF)
VALUES (SEQ_CLIENTE.NEXTVAL,'Deborah Regina','71541605004');

INSERT INTO CLIENTE 
(ID_CLIENTE,NOME,CPF)
VALUES (SEQ_CLIENTE.NEXTVAL,'Maicon Gerardi','11224567891');


--- TABELA CONTATOS

CREATE TABLE CONTATO_CLIENTE(
ID_CONTATO INT NOT NULL,
ID_CLIENTE INT NOT NULL,
TIPO INT NOT NULL,
NUMERO VARCHAR2(9) NOT NULL,
DESCRICAO VARCHAR2(255),
PRIMARY KEY(ID_CONTATO),
CONSTRAINT FK_ID_CONTATO FOREIGN KEY ( ID_CLIENTE ) REFERENCES CLIENTE( ID_CLIENTE )
);

CREATE SEQUENCE SEQ_CONTATO_CLIENTE
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

INSERT INTO CONTATO_CLIENTE
(ID_CONTATO,ID_CLIENTE,TIPO,NUMERO,DESCRICAO)
VALUES (SEQ_CONTATO_CLIENTE.NEXTVAL,1,'1','998765436','WHATS');

INSERT INTO CONTATO_CLIENTE
(ID_CONTATO,ID_CLIENTE,TIPO,NUMERO,DESCRICAO)
VALUES (SEQ_CONTATO_CLIENTE.NEXTVAL,1,'1','998762000','CELULAR');

INSERT INTO CONTATO_CLIENTE 
(ID_CONTATO,ID_CLIENTE,TIPO,NUMERO,DESCRICAO)
VALUES (SEQ_CONTATO_CLIENTE.NEXTVAL,2,'2','445654839','RESIDENCIAL');

INSERT INTO CONTATO_CLIENTE 
(ID_CONTATO,ID_CLIENTE,TIPO,NUMERO,DESCRICAO)
VALUES (SEQ_CONTATO_CLIENTE.NEXTVAL,2,'2','900654839','WHATS');

INSERT INTO CONTATO_CLIENTE
(ID_CONTATO,ID_CLIENTE,TIPO,NUMERO,DESCRICAO)
VALUES (SEQ_CONTATO_CLIENTE.NEXTVAL,3,'1','963784765','WHATS');

INSERT INTO CONTATO_CLIENTE
(ID_CONTATO,ID_CLIENTE,TIPO,NUMERO,DESCRICAO)
VALUES (SEQ_CONTATO_CLIENTE.NEXTVAL,3,'2','500084765','CELULAR');

INSERT INTO CONTATO_CLIENTE
(ID_CONTATO,ID_CLIENTE,TIPO,NUMERO,DESCRICAO)
VALUES (SEQ_CONTATO_CLIENTE.NEXTVAL,4,'2','50002858','CELULAR');

INSERT INTO CONTATO_CLIENTE
(ID_CONTATO,ID_CLIENTE,TIPO,NUMERO,DESCRICAO)
VALUES (SEQ_CONTATO_CLIENTE.NEXTVAL,4,'2','40002858','WHATS');

SELECT * FROM CONTATO_CLIENTE
-------- TABELA ENDERE?OS

CREATE TABLE ENDERECO_CLIENTE(
ID_ENDERECO INT NOT NULL,
ID_CLIENTE INT NOT NULL,
LOGRADOURO VARCHAR2(255) NOT NULL,
NUMERO NUMBER NOT NULL,
BAIRRO VARCHAR2(255) NOT NULL,
CEP VARCHAR2(9) NOT NULL,
TIPO INT NOT NULL
PRIMARY KEY (ID_ENDERECO),
CONSTRAINT FK_ID_ENDERECO_CLIENTE FOREIGN KEY ( ID_CLIENTE ) REFERENCES CLIENTE( ID_CLIENTE )
);

ALTER TABLE ENDERECO_CLIENTE ADD TIPO INT ;

CREATE SEQUENCE SEQ_ENDERECO_CLIENTE
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

DELETE ENDERECO_CLIENTE 

INSERT INTO ENDERECO_CLIENTE 
(ID_ENDERECO,ID_CLIENTE,LOGRADOURO,NUMERO,BAIRRO,CEP,TIPO)
VALUES(SEQ_ENDERECO_CLIENTE.NEXTVAL,1,'RUA ARMINDO CRUZ',33,'MARAPONGA','64987-09',1);

INSERT INTO ENDERECO_CLIENTE 
(ID_ENDERECO,ID_CLIENTE,LOGRADOURO,NUMERO,BAIRRO,CEP,TIPO)
VALUES(SEQ_ENDERECO_CLIENTE.NEXTVAL,2,'AV. DESEMBARGADOR MOREIRA',53,'CENTRO','67845-87',1);

INSERT INTO ENDERECO_CLIENTE 
(ID_ENDERECO,ID_CLIENTE,LOGRADOURO,NUMERO,BAIRRO,CEP,TIPO)
VALUES(SEQ_ENDERECO_CLIENTE.NEXTVAL,3,'RUA JULIO CESAR',78,'BOCA DO RIO','41984-78',1);

INSERT INTO ENDERECO_CLIENTE 
(ID_ENDERECO,ID_CLIENTE,LOGRADOURO,NUMERO,BAIRRO,CEP,TIPO)
VALUES(SEQ_ENDERECO_CLIENTE.NEXTVAL,2,'AV. OSWALDO ARANHA',153,'CENTRO','40845-20',1);

INSERT INTO ENDERECO_CLIENTE 
(ID_ENDERECO,ID_CLIENTE,LOGRADOURO,NUMERO,BAIRRO,CEP,TIPO)
VALUES(SEQ_ENDERECO_CLIENTE.NEXTVAL,3,'RUA DOUTOR FLORES',178,'CIDADE BAIXA','57984-18',2);


SELECT * FROM ENDERECO_CLIENTE
-----TABELA FUNCIONARIOS

CREATE TABLE VEM_SER.FUNCIONARIO (
ID_FUNCIONARIO INT NOT NULL,
NOME VARCHAR (255) NOT NULL,
CARGO VARCHAR2 (255) NOT NULL,
SALARIO DECIMAL(6,2) NOT NULL,
PRIMARY KEY (id_FUNCIONARIO)
);


CREATE SEQUENCE SEQ_FUNCIONARIO
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;



INSERT INTO FUNCIONARIO 
(ID_FUNCIONARIO,NOME,CARGO,SALARIO)
VALUES (SEQ_FUNCIONARIO.NEXTVAL,'Jana?na','ATENDENTE',1200.00);

INSERT INTO FUNCIONARIO 
(ID_FUNCIONARIO,NOME,CARGO,SALARIO)
VALUES (SEQ_FUNCIONARIO.NEXTVAL,'Roberto','MOTOBOY',1000.00);


SELECT * FROM FUNCIONARIO f 


------TABELA PEDIDOS

CREATE
TABLE VEM_SER.PEDIDO (
ID_PEDIDO INT NOT NULL,
ID_CLIENTE INT  NOT NULL,
PRIMARY KEY (ID_PEDIDO),
VALOR_TOTAL DECIMAL(5,2) DEFAULT NULL,
STATUS VARCHAR2(15) DEFAULT NULL,
CONSTRAINT FK_ID_PEDIDO FOREIGN KEY ( ID_CLIENTE ) REFERENCES CLIENTE( ID_CLIENTE )
);

CREATE SEQUENCE SEQ_PEDIDO
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

INSERT INTO PEDIDO
(ID_PEDIDO,ID_CLIENTE)
VALUES (SEQ_PEDIDO.NEXTVAL,1);

INSERT INTO PEDIDO
(ID_PEDIDO,ID_CLIENTE)
VALUES (SEQ_PEDIDO.NEXTVAL,2);

INSERT INTO PEDIDO
(ID_PEDIDO,ID_CLIENTE)
VALUES (SEQ_PEDIDO.NEXTVAL,3);

INSERT INTO PEDIDO
(ID_PEDIDO,ID_CLIENTE)
VALUES (SEQ_PEDIDO.NEXTVAL,1);

SELECT * FROM PEDIDO
----TABELA PRODUTOS

CREATE
TABLE VEM_SER.PRODUTO (
ID_PRODUTO INT NOT NULL,
TIPO_PRODUTO INT NOT NULL,
NOME VARCHAR2(255) NOT NULL,
PRECO DECIMAL(5,2) NOT NULL,
PRIMARY KEY (ID_PRODUTO)
);

CREATE SEQUENCE SEQ_PRODUTO
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

INSERT INTO PRODUTO 
(ID_PRODUTO, TIPO_PRODUTO, NOME, PRECO)
VALUES (SEQ_PRODUTO.NEXTVAL,'2','COCA COLA 1 LITRO',5.00);

INSERT INTO PRODUTO 
(ID_PRODUTO,TIPO_PRODUTO, NOME, PRECO)
VALUES (SEQ_PRODUTO.NEXTVAL,'2','GUARANA 1 LITRO',4.50);

INSERT INTO PRODUTO 
(ID_PRODUTO, TIPO_PRODUTO, NOME, PRECO)
VALUES (SEQ_PRODUTO.NEXTVAL,'1','PIZZA CALABRESA',20.00);

INSERT INTO PRODUTO 
(ID_PRODUTO, TIPO_PRODUTO, NOME, PRECO)
VALUES (SEQ_PRODUTO.NEXTVAL,'1','PIZZA FRANGO COM CATUPIRY',30.00);


SELECT * FROM PRODUTO 
------TABELA PEDIDO _ PRODUTOS
CREATE
TABLE VEM_SER.PEDIDO_PRODUTO (
ID_PEDIDO INT NOT NULL,
ID_PRODUTO INT  NOT NULL,
QUANTIDADE INT NOT NULL,
PRIMARY KEY (ID_PEDIDO,ID_PRODUTO),
 CONSTRAINT FK_PEDIDO_PRODUTO FOREIGN KEY (ID_PEDIDO) REFERENCES PEDIDO (ID_PEDIDO),
 CONSTRAINT FK_PRODUTO_PEDIDO FOREIGN KEY (ID_PRODUTO) REFERENCES PRODUTO (ID_PRODUTO) 
);

INSERT INTO PEDIDO_PRODUTO (ID_PEDIDO, ID_PRODUTO, QUANTIDADE)
VALUES (1,1,2);

INSERT INTO PEDIDO_PRODUTO (ID_PEDIDO, ID_PRODUTO, QUANTIDADE)
VALUES (1,2,3);

SELECT * FROM PEDIDO_PRODUTO