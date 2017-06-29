package com.paran.chapter07;

import com.paran.chapter07.Student;

public class ClassInstanceDemo {
	@SuppressWarnings("unused") // if 조건문 내의 Dead Code 경고 비활성화
	public static void main(String[] args) {
		/*
		 * Null로 초기화한 Reference 변수에 접근할 경우
		 *  Compile 단계 오류 없음. Runtime 단계 NullPointerException 발생
		 */
		Student obj = null;
		// if 조건을 활용한 NullPointerException 검사
		if ( obj != null ) System.out.println(obj.getIsMilSer());
		
		obj = new Student("1", "1", true);
		obj.name = "홍길동";
	}
}
