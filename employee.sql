사원테이블

employee테이블
id varchar2(10)not null
pass varchar2(10)not null
name varchar2(24)
lev char(1)default'A'
enter DATE
gender char(1)default'1'
phone varchar2(30)
primary key(id)

CREATE TABLE EMPLOYEES(
id varchar2(10)not null primary key,
pass varchar2(10) not null,
name varchar2(24),
lev char(1) default'A',
enter date,
gender char(1)default'1',
phone varchar2(30)

);