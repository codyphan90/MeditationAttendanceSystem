
create table if not exists persistent_logins (
  username varchar_ignorecase(100) not null,
  series varchar(64) primary key,
  token varchar(64) not null,
  last_used timestamp not null
  );

INSERT INTO USER  VALUES ( 1, 1, null, 'Admin', '$2a$10$fTbfbqSI0voIRsw1Nrmhj.AoaTuw79uF835uS/UKMyA.tShv9F2AS');
INSERT INTO USER  VALUES ( 2, 1,null, 'Faculty', '$2a$10$fTbfbqSI0voIRsw1Nrmhj.AoaTuw79uF835uS/UKMyA.tShv9F2AS');
INSERT INTO USER  VALUES ( 987013, 1, 11001000987013, 'Viet Anh Phan', '$2a$10$fTbfbqSI0voIRsw1Nrmhj.AoaTuw79uF835uS/UKMyA.tShv9F2AS');

INSERT INTO ROLE VALUES ( 1, 'ADMIN');
INSERT INTO ROLE VALUES ( 2, 'USER');
INSERT INTO ROLE VALUES ( 3, 'FACULTY');

INSERT INTO USER_ROLE VALUES (1,1);
INSERT INTO USER_ROLE VALUES (2,3);
INSERT INTO USER_ROLE VALUES (987013,2);

