package org.zerock.controller;


import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j2;

@Controller // serlvelt-component.xml context:component-scan
			// base-package="org.zerock.controller"
@RequestMapping("/sample/*") // http://192.168.111.104:80/controller/sample/모든것에 반응한다.
@Log4j2 // 사용시 resources 폴더에 log4j2.xml 필수
public class SampleController {
	@RequestMapping("") //// http://192.168.111.104:80/controller/sample/
	public void basic() {
		log.info("SampleController.basic() 메서드 실행");
		log.info("리턴이 void 이기 때문에 basic.jsp 파일을 찾습니다.");
		log.info("현재/WEB-INF.viwe/basic.jsp가 없음으로 크롬에 오류가 납니다.");
		// 리턴이 void임 :파일 [/WEB-INF/views/sample.jsp]을(를) 찾을 수 없습니다.
		// 기본적으로 url에 경로에 대한 jsp를 찾으려고 한다.

	}// basic 메서드 종료

	@RequestMapping(value = "/basic", method = { RequestMethod.GET, RequestMethod.POST })
	// http://192.168.111.104:80/controller/sample/basic -> get메서드와 post메서드에 동작을
	// 하겠다.
	public void basicGet() {
		log.info("SampleController.basicGet() 메서드 실행");
		log.info("get 방식 post 방식 둘다 반응한다.");
	} // basicGet 메서드 종료

	@GetMapping("/basicOnlyGet/")
	public void basicGet2() {
		log.info("SampleController.basicGet() 메서드 실행");
		log.info("get 방식 반응한다.");
	} // basicGet2 메서드 종료

	@PostMapping("/basicOnlyPost/")
	public void basicPost2() {
		log.info("SampleController.basicGet() 메서드 실행");
		log.info(" post 방식  반응한다.");
	} // basicPost2 메서드 종료

	@GetMapping("/ex01") // http://192.168.111.104:80/controller/sample.ex01?name=kkw&age=33
	public String ex01(SampleDTO dto) {// sampleDTO dto= new SampleDTO();
		log.info("SampleController.ex01() 메서드 실행");
		log.info("get 방식 반응한다.");
		log.info("입력 dto 확인:" + dto);

		return "mbcex01"; // /WEB-INF/views/ex01.jsp -> serlvet-contexr.xml이 하는 일
	}// ex01 메서드 종료

	@GetMapping("/ex02") // http://192.168.111.104:80/controller/sample/ex02
	public String ex02(@RequestParam("owner") String name, @RequestParam("age") int age) {
		// 프론트 변수와 백엔드의 변수가 다를때!!! (초보자는 일치 시켜라)
		log.info("name :" + name);
		log.info("age :" + age);

		return "ex02";
	}@GetMapping("/ex02List")
	// http://192.168.111.104:80/controller/sample/ex02List?ids111&ids222&ids333....
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		// 리스트로 넘어오는 데이터 처리해보자
		
		log.info("리스트로 넘어온 데이터 처리: " + ids);
		log.info("리스트로 2번째 넘어온 데이터 확인: " + ids.get(1));
		

		return "ex02List";
	}
	@GetMapping ("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		//url 경로에 배열로 들어오는 파라미터
		// /ex02Bean?list[0].name=kkw&list[2].age=33
		
		log.info("list SampleDTOs :" + list);
		
		return "ex02Bean";
	}
	@GetMapping ("/ex03")
	public String ex03(TodoDTO todo) {
	
		log.info("todo :" + todo);
		
		return "ex03";
		
	}
	@GetMapping ("/ex04") 	// http://192.168.111.104:80/controller/sample/ex04

	public String ex04(SampleDTO dto,@ModelAttribute("page") int page) {
		//@ModelAttribute ("page") 안쓰면 백엔드엔 전달 되지만 프론트에는 전달이 안됨
		// 스프링에서 기본적으로 제공되는 model 객체를 사용하게 설정한다.
		log.info("dto :"+ dto);	// name,age 
		log.info("page :"+ page);

		
		return "/sample/ex04"; //viwes/sample/ex04.jsp 를 찾는다.
	}
	@GetMapping ("ex05")
	public void ex05() {
		log.info("SampleController.ex05메서드 실행");
		
		// 리턴이 void인 경우에는 자동으로 [/WEB-INF/views/sample/ex05.jsp] 를 찾는다.
		// 초보자 void 사용 금지 
	}
	@GetMapping ("ex06")
	public @ResponseBody SampleDTO ex06() {
			//@ResponseBody SampleDTO  응답바디에 객체를 받아 리턴을 한다.
		
		log.info("SampleController.ex06메서드 실행");
		
		SampleDTO dto = new SampleDTO();
		dto.setName("kkw");
		dto.setAge(33);
		
		return dto;
	}
	@GetMapping ("ex07")
	public ResponseEntity<String> ex07(){
		// ResponseEntity<String> 응답헤더 (200ok ,404,304)를 만들어 리턴한다.
		log.info("SampleController.ex07 메서드 실행");
		
		String msg = "{\"name\":\"kkw\"}"; //json으로 {name:kkw}
		
		HttpHeaders header = new HttpHeaders() ;
		header.add("Content-type","application/json;charset=UTF-8");
		return new ResponseEntity<String>(msg,header,HttpStatus.OK);
		//msg 에는 json , header에는 json 타입/ 200은 ok
	}
}
