package org.test.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.test.domain.VO;
import org.test.mapper.TestsBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class TestsBoardMapper {
	@Setter(onMethod_ = @Autowired)
	private TestBoardMapper mapper; //인터페이스에서 만든 객체 세터로 연결
	@Test
	public void testGetList() {
		
		mapper.getlist2().forEach(board -> log.info(board));
	}
	@Test
	public void testInsert() {
		
		VO board = new VO();
		board.setTitle("제발 오류 없어라");
		board.setContent("이번엔 누구냐");
		board.setWriter("김기원");
		
		mapper.insert(board);
		
		log.info(board);
	}
		@Test 
		public void testInsertSelectKey() {
			VO board = new VO();
			board.setTitle("이번엔 제발 나와라");
			board.setContent("내 게시물 번호는?" + board.getBno());
			board.setWriter("김기원");
			
			mapper.insertSelectKey(board);
			
			log.info(board);
			log.info("내가 만든 게시물의 번호는 :"+board.getBno());
		}
		@Test
		public void testRead() {
			
			VO board = mapper.read(1L); //1번 게시물 read 메서드로 보내고 객체를 받는다
			log.info(board);
		}
		@Test 
		public void testDelete() {
			int count = mapper.delete(3L);
			
			log.info("삭제된 갯수 출력" + count +"건");
		}
		@Test
		public void testUpdate() {
			VO board = new VO();
			board.setBno(5L);
			board.setTitle("수정한제목");
			board.setContent("수정된내용");
			board.setWriter("김수정");
			
			int count = mapper.update(board);
			log.info("수정된 갯수 :"+ count +"건");
			log.info("수정된 객체 출력" + board);
		}
}
