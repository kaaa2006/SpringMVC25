--계정 암호 기본테이블,임시 테이블 생성 
create user book_ex identified by book_ex
default tablespace users temporary tablespace temp;
--접근권한과 dba권한 부여
grant connect, dba to book_ex
--오라클 포트 확인용
select dbms_xdb.gethttpport() from dual

exec dbms_xdb.sethttpport(9999) --cmd용
