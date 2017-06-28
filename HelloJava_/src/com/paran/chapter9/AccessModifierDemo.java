package com.paran.chapter9;

import com.paran.chapter7.Student;

public class AccessModifierDemo{
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Student stdObj = new Student("1", "1", true);
		/*
		 * 다른 Package 내의 no modifier 변수 접근 시도 -> invisible variable
		 *  modifier가 없으면 같은 Package 내에서만 접근 가능
		 */
		//stdObj.name = "홍길동";
		UnivStudent uStdObj = new UnivStudent("2", "2", true);
		uStdObj.showInfo();
	}
}