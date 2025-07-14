package org.test.domain;

import java.util.Date;

import lombok.Data;
@Data // 생성자 게터세터 toString 

public class VO {
	//vo는 게터 속성이 강함
	
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regDate; 
	private Date updateDate;
	
	

}
