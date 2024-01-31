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
	user_id				varchar(20)		primary key,
	department_id		int,
	pw					varchar(20)		NOT NULL,
	user_name			varchar(20),
	user_address		varchar(20),
	user_hp				varchar(20),
	user_email			varchar(20),
	hire_date			datetime
);
ALTER TABLE department ADD CONSTRAINT FK_user_TO_user_1 FOREIGN KEY (
	user_id
)
REFERENCES user (
	user_id
);



CREATE TABLE department (
	department_id		int			primary key,
    user_id				varchar(20),
	department_name		varchar(20)
);
ALTER TABLE user ADD CONSTRAINT FK_department_TO_user_1 FOREIGN KEY (
	department_id
)
REFERENCES department (
	department_id
);



CREATE TABLE work (
	work_id			int					primary key		 auto_increment,
	user_id			varchar(20)			NOT NULL,
	state			varchar(20),
	work_date		datetime
);

ALTER TABLE work ADD CONSTRAINT FK_user_TO_work_1 FOREIGN KEY (
	user_id
)
REFERENCES user (
	user_id
);

insert into user
value ('yoo', 10, 'yoo', '유영수', '경기도 하남시' , '010-1234-5678' , 'yoo@naver.com', '2024/01/02');

insert into user
value ('mola', 30, 'mola', 'mola', '서울 강동구' , '010-5555-4444' , 'mola@naver.com', '2024/01/05');

insert into user
value ('yhr', 20, 'yhr', '유혜련', '경기도 하남시' , '010-8888-8888' , 'yhr@naver.com', '2024/01/11');

insert into user
value ('yhy', 20, 'yhy', '유혜영', '경기도 광주' , '010-3333-4444' , 'yhy@naver.com', '2024/01/16');

insert into department
value (10, 'test', '영업1팀');

insert into department
value (30, 'test', '영업2팀');

insert into department
value (40,  'test','영업3팀');

insert into department
value (20, 'test', '마케팅');

select department_id,
	   user_id,
       department_name
from department;

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
value (null, 'yhy', '무단결근', '2024-01-27');

insert into department
value (10, 'test', '영업1팀');

update department
set user_id = null,
	department_name = null
where department_id = 100;