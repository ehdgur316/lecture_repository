package com.paran.chapter09;

import com.paran.chapter07.Student;

/*
 * 상속받은 class의 규칙
 *  자식 class의 Instance를 생성할 때는 부모 class의 생성자함수도 호출
 *   기본생성자함수가 존재할 경우 기본생성자함수가 자동으로 호출
 *   기본생성자함수가 존재하지 않으면 호출할 생성자함수를 특정하지 못해 오류
 */
// chapter7에 존재하는 Student class 상속
public class UnivStudent extends Student{
	public UnivStudent(String name, String stdID, boolean isMilSer) {
		// 부모 class의 생성자함수를 호출(super -> 자식 class에서 부모 class에 접근)
		super(name, stdID, isMilSer);
	}
	
	/*
	 * protected로 선언된 isMilSer만 [다른 Package, 상속 class] 관계에서 호출 가능(visible)
	 * no modifier인 name, stdID는 [다른 Package, 상속 class] 관계에서 호출 불가(invisible)
	 */
	// Method Overriding
	public void showInfo() {
		// 부모 class에 있는 showInfo method를 호출
		super.showInfo();
		System.out.println("제대여부 : " + isMilSer);
	}
}
