-- ddl
use webdb;

drop table member;

create table member(
	no int auto_increment,
    email varchar(200) not null,
    password varchar(64) not null,
    name varchar(100) not null,
    dept varchar(100),
    PRIMARY KEY(no)
);

desc member;

alter table member add column juminbunho char(13) not null;

desc member;

alter table member drop column juminbunho;
desc member;

alter table member add column juminbunho char(13) not null after email;
desc member;

alter table member change column department dept varchar(200) not null;
desc member;

alter table member add self_intro text;
desc member;

-- 
-- dml
--

-- insert
insert 
	into member
    values(null, 'gsjang0807@naver.com', password('1234'), '장은영', '개발팀');
select * from member;

insert into member(email, name, dept, password)
	values ('gsjang0807@naver.com', '장은영1', '개발팀1', password('1234'));
select * from member;

-- update
update member
	set email='gsjang0807@gmail.com'
    where no = 2;
select * from member;

-- delete
delete 	
	from member
	where no = 2;
select * from member;

-- transaction begin
-- 데이터 변경과 관련된 dml중에 insert, update, delete가 transaction 대상

set autocommit = 0;
select @@autocommit from dual;

insert into member(email, name, dept, password)
	values ('gsjang0807@naver.com', '장은영1', '개발팀1', password('1234'));
select * from member;

select no, email, dept from member;

commit;

select no, email, dept from member;


