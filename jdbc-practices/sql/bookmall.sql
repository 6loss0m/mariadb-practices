use bookmall;
show tables;

drop table orders_book;
drop table cart;
drop table book;
drop table orders;
drop table members;
drop table category;


desc members;

select * from members;
insert into members(id, name, password) values('a123','홍길동', password('1234'));
insert into members(id, name, password) values('b234','최길주', password('1234'));
insert into members(id, name, password) values('c345','고길동', password('1234'));

select * from category;
insert into category values(null, '소설');
insert into category values(null, '수필');
insert into category values(null, '컴퓨터/IT');
insert into category values(null, '인문');
insert into category values(null, '경제');
insert into category values(null, '예술');

desc book;
alter table book rename column catrgory_no to category_no;
select * from book;
insert into book(title, price, category_no) values('도시와 그 불확실한 벽', 17550, 1);
insert into book(title, price, category_no) values('메리골드 마음 세탁소', 13500, 1);
insert into book(title, price, category_no) values('SQL 자격검정 실전문제', 13500, 3);
