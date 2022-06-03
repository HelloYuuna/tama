drop table PLAYER;
drop table ANIMAL_INFO;
drop sequence animal_seq;
drop table animal_type;
drop sequence type_seq;
drop table food;
drop sequence food_seq;

select * from PLAYER;

create table PLAYER (
                        playerId varchar2(30) PRIMARY KEY ,
                        playerPwd varchar2(20) NOT NULL
);

insert into PLAYER
values ('tama1','111');
commit;

create table animal_type (
                             typeSeq number(1) PRIMARY KEY ,
                             lifespan number NOT NULL ,
                             species char(10) CHECK (species in ('앵무새', '강아지', '고양이'))
);
alter table animal_type
MODIFY species char(10);

create sequence type_seq;

insert into animal_type
values (type_seq.nextval, 31, '앵무새');
insert into animal_type
values (type_seq.nextval, 61, '강아지');
insert into animal_type
values (type_seq.nextval, 91, '고양이');

create table ANIMAL_INFO (
                             animalSeq number PRIMARY KEY ,
                             playerId varchar2(30) REFERENCES PLAYER(playerId) on delete cascade ,
                             birth date default sysdate NOT NULL ,
                             typeSeq number(1) REFERENCES animal_type(typeSeq) on delete cascade ,
                             animalName varchar2(30) NOT NULL ,
                             condition varchar2(10) default '보통' CHECK (condition in('좋음','보통','나쁨','병','사망')) ,
                             money number DEFAULT 1000
);
create sequence animal_seq;

create table food (
                      foodSeq number PRIMARY KEY ,
                      typeSeq number(1) REFERENCES animal_type(typeSeq) ,
                      foodName varchar2(30) NOT NULL ,
                      price number NOT NULL
);
create sequence food_seq;
