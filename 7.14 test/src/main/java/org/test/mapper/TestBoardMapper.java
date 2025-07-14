package org.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.test.domain.VO;


public interface TestBoardMapper {
@Select("SELECT * FROM tbl_board WHERE bno > 0")

public List<VO> getList();

public List<VO> getlist2();

public void insert(VO board); //xml에서 쿼리 작성

public void insertSelectKey(VO board); // xml에서 쿼리 작성

public VO read(Long bno); // xml에서 쿼리 작성
// 번호가 들어가면 객체로 나온다.

public int delete(Long bno); // xml에서 쿼리 작성
// 번호가 들어가면 삭제후 몇개가 삭제 됐는지 리턴한다.

public int update(VO board); //xml에서 쿼리 작성
// 번호가 들어가면 수정후 몇개가 수정 됐는지 리턴한다.
}
