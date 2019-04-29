drop table jdbctest;

drop sequence jdbctest_no_seq;

create table jdbctest
(
no number primary key,
name varchar2(12),
id varchar2(16),
joindate date default sysdate
);

create sequence jdbctest_no_seq
start with 1 increment by 1;

select * from jdbctest;

select name, id, to_char(joindate,'yyyy.mm.dd hh24:hh:mi')
from jdbctest;

