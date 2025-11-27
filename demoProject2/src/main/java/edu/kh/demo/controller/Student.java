package edu.kh.demo.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private String studentNo; // 학생번호
	private String name;      // 이름
	private int age;		  // 나이
	
	
	
}
