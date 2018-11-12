create database agenciaportal;

insert into role values(1,'USER');
insert into role values(2,'ADMIN');

insert into product_type values( 1, 'passagens', 'Passagens');
insert into product_type values( 2, 'resort', 'Resort');
insert into product_type values( 3, 'tipo-com-acentuacao', 'Tipo com Acentua��o');

insert into products values('V001','Pacote Orlando',150,20);
insert into products values('V002','Pacote Los Angels',160,1);
insert into products values('V003','Pacote Dubai',170,0);
insert into products values('V004','Pacote Las Vegas',180,2);
insert into products values('V005','Pacote Cancun',190,5);
insert into products values('V006','Pacote Grecia',120,10);
insert into products values('V007','Pacote Bali',110,19);
insert into products values('V008','Pacote China',110,19);

insert into resorts values('R001','Catussaba Su�tes',150,20);
insert into resorts values('R002','Gran Hotel Stella Maris Resort',160,1);
insert into resorts values('R003','Transam�rica Comandatuba',170,0);
insert into resorts values('R004','Cana Brava All Inclusive Resort',180,2);
insert into resorts values('R005','Beach Park Wellness',190,5);
insert into resorts values('R006','Dom Pedro Laguna Beach',120,10);
insert into resorts values('R007','Acqua Beach Park Resort',110,19);
insert into resorts values('R008','Carmel Charme Resort',110,19);


