 -- 계정생성 쿼리문
create user 'work'@'%' identified by 'work';


-- 권한설정 쿼리문
grant all privileges on work_db.* to 'work'@'%';


drop user if exists 'work_db';

create database work_db
	default character set utf8mb4
	collate utf8mb4_general_ci
	default encryption='n'
;


CREATE TABLE user (
	user_id	varchar(7)	primary key,
	department_id	int	NOT NULL,
	work_id	int	NOT NULL,
	pw	varchar(20)	NOT NULL,
	user_name	varchar(20)	NULL,
	user_address	varchar(20)	NULL,
	user_hp	varchar(20)	NULL,
	user_email	varchar(20)	NULL,
	hire_date	date	NULL
);


CREATE TABLE department (
	department_id		int			primary key,
	department_name		varchar(20),
    user_id	varchar(7)	NULL
);


CREATE TABLE work (
	work_id	int	primary key,
	user_id	varchar(20)	NOT NULL,
	state	varchar(20)	NULL,
	work_date	date	NULL
);

ALTER TABLE user ADD CONSTRAINT FK_department_TO_user_1 FOREIGN KEY (
	department_id
)
REFERENCES department (
	department_id
);

ALTER TABLE user ADD CONSTRAINT FK_work_TO_user_1 FOREIGN KEY (
	work_id
)
REFERENCES work (
	work_id
);

ALTER TABLE department ADD CONSTRAINT FK_user_TO_department_1 FOREIGN KEY (
	user_id
)
REFERENCES user (
	user_id
);

ALTER TABLE work ADD CONSTRAINT FK_user_TO_work_1 FOREIGN KEY (
	user_id
)
REFERENCES user (
	user_id
);

select *
from user;
select *
from department;

update user
set user_id = 'tttt',
	pw = 'tttt'
where department_id = 40;




insert into user
value ('jjw', 80, 'jjw', '정진우', '경기도 광주시' , '010-2222-3211' , 'kjw@naver.com', '2024/01/23');

insert into work
value (1, 'djfksdl', '근무', '2024-01-24');
insert into work
value (2, 'djfksdl', '근무', '2024-01-25');
insert into work
value (3, 'djfksdl', '근무', '2024-01-26');
insert into work
value (4, 'djfksdl', '근무', '2024-01-27');
insert into work
value (5, 'djfksdl', '근무', '2024-01-28');
insert into work
value (6, 'djfksdl', '휴가', '2024-02-01');


select *
from work;


select *
from user;



select *
from department;

insert into department
value (10, '영업1팀', null);

insert into department
value (20, '영업2팀', null);

insert into department
value (30, '영업3팀', null);

insert into department
value (40, '영업4팀', null);

insert into department
value (50, '영업5팀', null);

insert into department
value (60, '마케팅', null);

insert into department
value (70, null, '개발팀');

insert into department
value (80, null,  '인사팀');

insert into department
value (90, null,  '생산팀');

select department_id,
       department_name
from department;

select * from user;

insert into department
value (50, 'test', '영업4팀');

select user_id,
	   pw,
       department_id,
       user_name,
       user_address,
       user_hp,
       user_email,
       hire_date
from user;

select work_id,
	   user_id,
       state,
       date_format(work_date, '%Y-%m-%d') work_date
from work;

insert into work
value (null, 'seeu', '무단결근', '2024-01-15');

select *
from user;

insert into department
value (100, 'test', '영업99팀');







set foreign_key_checks = 0;

update department
set user_id = 'tttt',
	department_name = '사업부'
where department_id = 20;

set foreign_key_checks = 1;
ALTER TABLE work MODIFY work_id INT NOT NULL AUTO_INCREMENT FIRST;

select * 
from work w
left join user u on u.user_id = w.user_id;


select *
from work;

select *
from department;


select *
from user;


select *
from department;

delete from department
where department_id = 100;


delete from user
where user_id = 'yyy';



select user_id,
	   state,
	   date_format(work_date, '%Y-%m-%d') work_date
from work
where user_id=1;







