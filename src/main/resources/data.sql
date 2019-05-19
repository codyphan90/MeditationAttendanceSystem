
create table if not exists persistent_logins (
  username varchar_ignorecase(100) not null,
  series varchar(64) primary key,
  token varchar(64) not null,
  last_used timestamp not null
  );

INSERT INTO USER  VALUES ( 1, 1, null, null,'Admin', '$2a$10$fTbfbqSI0voIRsw1Nrmhj.AoaTuw79uF835uS/UKMyA.tShv9F2AS');
INSERT INTO USER  VALUES ( 2, 1,null, 'Feb2019','User', '$2a$10$fTbfbqSI0voIRsw1Nrmhj.AoaTuw79uF835uS/UKMyA.tShv9F2AS');
INSERT INTO USER  VALUES ( 3, 1,null, null,'Faculty', '$2a$10$fTbfbqSI0voIRsw1Nrmhj.AoaTuw79uF835uS/UKMyA.tShv9F2AS');
INSERT INTO USER  VALUES ( 987013, 1, 11001000987013, 'Feb2019','Viet Anh Phan', '$2a$10$fTbfbqSI0voIRsw1Nrmhj.AoaTuw79uF835uS/UKMyA.tShv9F2AS');

INSERT INTO ROLE VALUES ( 1, 'ADMIN');
INSERT INTO ROLE VALUES ( 2, 'USER');
INSERT INTO ROLE VALUES ( 3, 'FACULTY');

INSERT INTO USER_ROLE VALUES (1,1);
INSERT INTO USER_ROLE VALUES (2,2);
INSERT INTO USER_ROLE VALUES (3,3);

insert into Student values(123,'NOV 2018','Dawit','Asefa');
insert into Student values(124,'Aug 2018','Andulem','Mulgeta');
insert into Student values(125,'FEB 2018','Henok','Tesfaye');
insert into Student values(126,'MAY 2019','Honere','kinsowa');
insert into Student values(127,'NOV 2018','Chirstoph','Mutagezi');
insert into Student values(128,'Aug 2018','Luwis','Celestian');
insert into Student values(129,'MAY 2019','Bekine','Renuka');
insert into Student values(130,'Aug 2018','Mohantruj','Jessy');
insert into Student values(131,'MAY 2017','Elsa','Tefera');
insert into Student values(132,'Aug 2018','Beti','Kassahun');
insert into Student values(133,'Feb 2018','sarolina','beyines');
insert into Student values(134,'Aug 2018','Mohantruj','Renuka');

insert into TM values(1,'2019-05-10','Tm-Check','123');
insert into TM values(2,'2019-04-11','Tm-Check','124');
insert into TM values(3,'2019-03-11','Tm-Check','123');
insert into TM values(4,'2019-02-11','Tm-Check','124');
insert into TM values(5,'2019-05-11','Tm-Check','125');
insert into TM values(6,'2019-05-11','Tm-Check','126');
insert into TM values(7,'2019-04-11','Tm-Check','124');
insert into TM values(8,'2019-05-11','Tm-Check','127');