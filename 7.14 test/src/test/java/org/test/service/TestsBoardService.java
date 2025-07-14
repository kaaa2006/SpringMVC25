package org.test.service;

import static org.junit.Assert.assertNotNull;

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

public class TestsBoardService {

	@Setter(onMethod_ = @Autowired)
	private TestBoardService service; // 인터페이스를 필드로 선언
	// 인터페이스에 연결된 구현 클래스가 자동 연동된다. BoardServiceImpl

	@Test
	public void testExits() {

		log.info("--------------------------");
		log.info(service); // 인터페이스를 호출하여 보자
		log.info("--------------------------");
		assertNotNull(service); // 빈객체가 아님을 테스트 한다.
		// org.test.service.BoardServiceImpl@5c441290
		// 인터페이스를 호출했는데 구현 클래스가 호출됨을 확인한다.
		// 구현클래스에 구현메서드를 실행문에 작성하면 동작하는것을 확인 할 수 있다.

	}

	@Test
	public void testRegister() {
		VO board = new VO();
		board.setTitle("서비스에서 만든 제목");
		board.setContent("서비스에서 만든 내용");
		board.setWriter("서비스님");

		service.register(board);

		log.info("===============");
		log.info("생성된 게시물의 번호 :" + board.getBno());
		log.info("===============");

	}

	@Test
	public void testGetList() {
		log.info("===============");
		service.getList().forEach(board -> log.info(board));
		log.info("===============");

	}

	@Test
	public void testGet() {
		log.info("===============");
		log.info(service.get(8L));
		log.info("===============");

	}

	@Test
	public void testDelete() {
		log.info("===============");
		log.info("삭제된 결과 :" + service.remove(2L));
		log.info("===============");
	}
	@Test
	public void testUpdate() {
		
		VO board= service.get(4L); 
		
		if(board == null) {
			log.info("찾는 게시물이 없습니다.");
		}
		board.setTitle("서비스에서 수정된 제목");
		log.info("수정된 결과 출력 :" + service.modify(board));
		
	}
}
