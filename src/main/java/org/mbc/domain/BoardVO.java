package org.mbc.domain;

import java.util.Date;

import lombok.Data;

@Data // import, lombok,data (생성자, 게터세터, toString 등...)
public class BoardVO {
// VO 읽기전용 속성이 강한 객체로 게터위주의 객체이다.
// DTO 게터세터 모두 가지고 활용하는 객체	

	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regDate; 
	private Date updateDate;

}
