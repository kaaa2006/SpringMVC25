package org.test.service;

import java.util.List;

import org.test.domain.VO;
import org.test.mapper.TestBoardMapper;
import org.springframework.stereotype.Service;
import org.test.domain.VO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2

public class TestBoardServiceImpl implements TestBoardService  {

	private TestBoardMapper mapper; // db 쿼리용 객체 생성 (CRUD)

	@Override
	public void register(VO board) {
		// 객체가 넘어오면 매퍼를 이용해서 데이터베이스에 등록하겠다.

		log.info("BoardServiceImpl.register 메서드 실행");

		mapper.insertSelectKey(board);
		log.info("정상등록 후 리스트 출력 테스트...");
		mapper.getlist2();

	}

	@Override
	public VO get(Long bno) {
		// 게시물의 번호가 들어가면 매퍼 select문이 동작 해야한다.
		log.info("BoardServiceImpl.get메서드 실행");
		mapper.read(bno);
		return null;
	}

	@Override
	public boolean modify(VO board) {
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
	public List<VO> getList() {
		// getList 메서드가 호출되면 매퍼에 getList2()를 호출한다.

		log.info("BoardServiceImpl.getList 메서드 실행");

		return mapper.getlist2();
	}
}
