package org.zerock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice // 예외처리 목적
@Log4j2
public class CommonExceptionAdvice {
	// mvc에서 예외처리를 담당하는 공통적인 지원 클래스
	@ExceptionHandler(Exception.class) // 내장된 예외처리 객체로 사용
	public String except(Exception ex, Model model) {
		// 예외처리용 통로, 스프링의 데이터 관리용 객체 통로

		log.error("CommonExceptionAdvice.except()...");
		model.addAttribute("exception", ex);
		log.error("예외 발생 :" + ex.getMessage());
		log.error(model); // 모델에 저장된 예외문구 처리
		return "error_page";
	}// 예외처리도 스프링이 관리해야함 servlet-context.xml 에 scan을 해야한다.

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND) //404 오류의 대한 핸들링
	
	public String handle404(NoHandlerFoundException ex) {
		
		return "custom404"; //custom404.jsp 로 간다.
	}
	
	
	
}
