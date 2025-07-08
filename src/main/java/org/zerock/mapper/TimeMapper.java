package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	// 인터페이스는 추상메서드를 사용한다.
	// 추상: 메서드명만 존재하고 실행문이 없다.
	// 사용방법: 클래스에 implements 인터페이스명을 사용한다.

	@Select("SELECT sysdate FROM dual") // 주의사항 ;이 없음
	public String getTime();
	// 인터페이스에 선언된 메서드는 추상메서드로 실행문이 없다.
	// 관례 : sql 쿼리문은 대문자로 
	public String getTime2();         
	// 이 메서드가 호출되면 마이바티스에서 xml를 찾는다.
	//src/main/resources/org/zerock/mapper/TimeMapper.xml 를 찾는다. 
	
}
