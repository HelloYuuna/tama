drop table PLAYER;
drop table ANIMAL_INFO;
drop sequence animal_seq;
drop table animal_type;
drop sequence type_seq;
drop table food;
drop sequence food_seq;

create table PLAYER (
                        playerId varchar2(30) PRIMARY KEY ,
                        playerPwd varchar2(20) NOT NULL
);

create table animal_type (
                             typeSeq number(1) PRIMARY KEY ,
                             lifespan number NOT NULL ,
                             species char(10) CHECK (species in ('앵무새', '강아지', '고양이'))
);
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
                             money number DEFAULT 1000 not null ,
                             logindate date default sysdate not null
);
create sequence animal_seq;

create table food (
                      foodSeq number PRIMARY KEY ,
                      typeSeq number(1) REFERENCES animal_type(typeSeq) ,
                      foodName varchar2(30) NOT NULL ,
                      price number NOT NULL
);
create sequence food_seq;

insert into food (foodSeq, typeSeq, foodName, price)
VALUES (food_seq.nextval, 1, '1.해바라기씨', 20);

insert into food (foodSeq, typeSeq, foodName, price)
VALUES (food_seq.nextval, 1, '2.기장', 10);

insert into food (foodSeq, typeSeq, foodName, price)
VALUES (food_seq.nextval, 1, '3.쌀밥', 30);

insert into food (foodSeq, typeSeq, foodName, price)
VALUES (food_seq.nextval, 1, '4.홍화씨', 50);

insert into food (foodSeq, typeSeq, foodName, price)
VALUES (food_seq.nextval, 1, '5.바나나', 100);

insert into food (foodSeq, typeSeq, foodName, price)
VALUES (food_seq.nextval, 2, '1.딸기', 70);

insert into food (foodSeq, typeSeq, foodName, price)
VALUES (food_seq.nextval, 2, '2.감말랭이', 30);

insert into food (foodSeq, typeSeq, foodName, price)
VALUES (food_seq.nextval, 2, '3.저키', 50);

insert into food (foodSeq, typeSeq, foodName, price)
VALUES (food_seq.nextval, 2, '4.강아지용 습신캔', 150);

insert into food (foodSeq, typeSeq, foodName, price)
VALUES (food_seq.nextval, 2, '5.강아지용 건식사료', 100);

insert into food (foodSeq, typeSeq, foodName, price)
VALUES (food_seq.nextval, 3, '1.츄르', 10);

insert into food (foodSeq, typeSeq, foodName, price)
VALUES (food_seq.nextval, 3, '2.닭가슴살(생식)', 80);

insert into food (foodSeq, typeSeq, foodName, price)
VALUES (food_seq.nextval, 3, '3.북어트릿', 20);

insert into food (foodSeq, typeSeq, foodName, price)
VALUES (food_seq.nextval, 3, '4.고양이용 습식캔', 150);

insert into food (foodSeq, typeSeq, foodName, price)
VALUES (food_seq.nextval, 3, '5.고양이용 건식사료', 100);

update ANIMAL_INFO
set logindate = '2022-06-06'
where playerId = 'hello';

commit ;

select * from animal_info;