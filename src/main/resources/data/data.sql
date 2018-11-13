create database agenciaportal;

insert into role values(1,'USER');
insert into role values(2,'ADMIN');

insert into product_type values( 1, 'Passagens', 'passagens');
insert into product_type values( 2, 'Resort', 'resort');
insert into product_type values( 3, 'Tipo com Acentuação', 'tipo-com-acentuacao');

insert into products values('S001','Pacote Orlando',150,20, 1);
insert into products values('S002','Pacote Los Angels',160,1, 1);
insert into products values('S003','Pacote Dubai',170,0, 1);
insert into products values('S004','Pacote Las Vegas',180,2, 1);
insert into products values('S005','Pacote Cancun',190,5, 1);
insert into products values('S006','Pacote Grecia',120,10, 1);
insert into products values('S007','Pacote Bali',110,19,1);
insert into products values('S008','Pacote China',110,19,2);