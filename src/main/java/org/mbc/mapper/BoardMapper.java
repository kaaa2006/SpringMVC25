package org.mbc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.mbc.domain.BoardVO;

public interface BoardMapper {
	//interface는 클래스와 다르게 메서드가 추상화처럼 되어 있다.
	// 추상메서드는 시그니쳐만 있으며 {실행문이 없다.} 그래서 ; 끝난다
	@Select("SELECT * FROM tbl_board WHERE bno > 0") // bno > 0pk 로 선언되어있어 인덱싱으로 빠른 추출
	public List<BoardVO> getList();
	
	// 위와 같이 어노테이션으로 간단한 쿼리문은 가능하나 복잡한 쿼리문은 버그가 좀 있다.
	// 그래서 xml를 이용하려면 sql문 처리를 진행한다.
	// xml을 이용하려면 resources폴더 아래쪽에 org 폴터 아래 mbc 아래 mapper 폴더를 만들고
	// 인터페이스와 이름이 같은 xml 파일을 생성한다.
	// 이것이 마이바티스 사용법이다.
	public List<BoardVO>getList2();
	
	// c: insert 두가지 기법 데이터를 삽입하는 쿼리문 
	// 1.insert 처리후에 결과 int로 받는 방법
	// 2.pk를 먼저 생성한 후 insert가 되는 방법 
	
	public void insert(BoardVO board); //xml에서 쿼리 작성
	
	public void insertSelectKey(BoardVO board); // xml에서 쿼리 작성
	
	public BoardVO read(Long bno); // xml에서 쿼리 작성
	// 번호가 들어가면 객체로 나온다.
	
	public int delete(Long bno); // xml에서 쿼리 작성
	// 번호가 들어가면 삭제후 몇개가 삭제 됐는지 리턴한다.
	
	public int update(BoardVO board); //xml에서 쿼리 작성
	// 번호가 들어가면 수정후 몇개가 수정 됐는지 리턴한다.
}
