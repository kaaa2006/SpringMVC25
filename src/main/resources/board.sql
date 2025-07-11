-- 시퀀스 객체 생성
create sequence seq_board;
-- 시퀀스 삭제 (추후에 활용)
drop sequence seq_board;

create table tbl_board(
	bno number(10,0),				-- 게시물번호 (시퀀스)
	title varchar2(200) not null,	-- 제목
	content varchar2(2000) not null,-- 게시물 내용	board와 연결
	writer varchar2(50) not null,	-- 게시물 작성자 (차후 member와 연동)
	regdate date default sysdate,	-- 게시물작성일 (자동으로 db날짜 입력)
	updatedate date default sysdate -- 게시물 변경날짜 (자동으로 db날짜 입력)
);-- board 테이블 생성


alter table tbl_board add constraint pk_board primary key (bno);
-- tbl_board 구조변경(수정) 기본기를 bno로 지정함.
insert into TBL_BOARD (bno, title, content, writer) 
values (seq_board.nextval,'테스트제목1','테스트내용2','user00');
insert into TBL_BOARD (bno, title, content, writer) 
values (seq_board.nextval,'테스트제목2','테스트내용2','user00')
insert into TBL_BOARD (bno, title, content, writer) 
values (seq_board.nextval,'테스트제목3','테스트내용3','user00')
insert into TBL_BOARD (bno, title, content, writer) 
values (seq_board.nextval,'테스트제목4','테스트내용4','user00')


insert into TBL_BOARD (bno, title, content, writer) 
values (seq_board.nextval,'테스트제목5','테스트내용5','user00')
insert into TBL_BOARD (bno, title, content, writer) 
values (seq_board.nextval,'테스트제목6','테스트내용6','user00')
insert into TBL_BOARD (bno, title, content, writer) 
values (seq_board.nextval,'테스트제목7','테스트내용7','user00')

select * from TBL_BOARD;
