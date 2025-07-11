package org.mbc.service;

import java.util.List;

import org.mbc.domain.BoardVO;
import org.mbc.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service // 이 클래스는 서비스 계층임을 명시한다
@AllArgsConstructor // 생성자 자동 주입 (new VoardServiceImpl(mapper);
@Log4j2 // 로깅 처리용

public class BoardServiceImpl implements BoardService {
	// 조원이 실행문을 생성하는 용도로 활용된다. implements 를 사용후 구현클래스를 필수로 사용한다

	private BoardMapper mapper; // db 쿼리용 객체 생성 (CRUD)

	@Override
	public void register(BoardVO board) {
		// 객체가 넘어오면 매퍼를 이용해서 데이터베이스에 등록하겠다.

		log.info("BoardServiceImpl.register 메서드 실행");

		mapper.insertSelectKey(board);
		log.info("정상등록 후 리스트 출력 테스트...");
		mapper.getList2();

	}

	@Override
	public BoardVO get(Long bno) {
		// 게시물의 번호가 들어가면 매퍼 select문이 동작 해야한다.
		log.info("BoardServiceImpl.get메서드 실행");
		mapper.read(bno);
		return null;
	}

	@Override
	public boolean modify(BoardVO board) {
		// 프론트에서 객체가 넘어오면 매퍼를 통해서 update 쿼리가 실행된다.
		log.info("BoardServiceImpl.modify 메서드 실행");
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		// 프론트에서 번호가 넘어오면 매퍼를 통해서 delete 쿼리가 실행된다.
		log.info("BoardServiceImpl.remove 메서드 실행");

		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		// getList 메서드가 호출되면 매퍼에 getList2()를 호출한다.

		log.info("BoardServiceImpl.getList 메서드 실행");

		return mapper.getList2();
	}

}
