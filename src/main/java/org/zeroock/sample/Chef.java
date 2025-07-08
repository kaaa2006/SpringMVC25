package org.zeroock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component //스프링이 의존성 처리해줌 
@Data	   	//dto처리용 게터세터 ,to string equals등		

public class Chef {
	
	private String name;
	private int age;
	
	              
	
	
	
}
