package edu.kh.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

// Spring EL 같은 경우 DTO 객체 출력할 때 getter 가 필수 작성 되어있어야 함!
// -> ${Student.name} == ${Student.getName()}
// 내부적으로 해당 DTO 의 Getter 를 호출하고 있기 때문!

@Controller
@RequestMapping("example") // /example로 시작하는 모든 요청을 해당 컨트롤러에 매핑
@Slf4j // lombok 라이브러리가 제공하는 로그 객체 자동생성 어노테이션
public class ExampleController {
	
	/* Servlet 내장 객체 범위
	 * page < request < session < application
	 * 
	 * Model (org.springframework.ui.Model)
	 * - Spring 에서 데이터 전달 역할을 하는 객체
	 * 
	 * - 기본 scope : request
	 * 
	 * - @SessionAttribute 와 함께 사용 시 session scope 변환
	 * 
	 * [기본 사용법]
	 * model.addAttribute("key", value);
	 * 
	 * */
	
	@GetMapping("ex1") // /example
	public String ex1(HttpServletRequest req, Model model) {
		
		req.setAttribute("test1", "HttpServletRequest로 전달한 값");
		model.addAttribute("test2", "Model로 전달한 값"); // request scope
		
		// 단일 값(숫자, 문자열) Model을 이용해서 html로 전달
		model.addAttribute("productName", "마이크");
		model.addAttribute("price", 20000);
		
		// 복수 값(배열, List) Model 을 이용해서 html 로 전달
		List<String> fruitList = new ArrayList<>();
		fruitList.add("사과");
		fruitList.add("딸기");
		fruitList.add("바나나");
		
		model.addAttribute("fruitList", fruitList);
		
		// DTO 객체 Model 을 이용해서 html 로 전달
		Student std = new Student();
		std.setStudentNo("12345");
		std.setName("홍길동");
		std.setAge(22);
		
		model.addAttribute("std", std);
		
		// List<Student> 객체 Model 을 이용해서 html 로 전달
		List<Student> stdList = new ArrayList<>();
		stdList.add(new Student("11111", "김일번", 20));
		stdList.add(new Student("22222", "조미현", 30));
		stdList.add(new Student("33333", "김상번", 35));
		
		model.addAttribute("stdList", stdList);
		
		// src/main/resources/templates/exmaple/ex1.html 로 forward
		return "example/ex1";
	}
	
	
	
	
	
	
	
	
	
}
