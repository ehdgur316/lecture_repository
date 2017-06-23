package com.paran.chapter2;

/*
 * github 작업 중 실수로 데이터 삭제함
 * 코드는 복원, 주석은 전부 삭제됨
 */
public class Variable {
	int varType;
	
	/*
	 * static 한정자의 사용
	 *  1. 멤버 변수에 사용 - 상수(불변의 값) 선언
	 *  2. 메서드에 사용 - Overriding 불가 메서드 선언(inheritance 연관)
	 *  3. class에 사용 - Extends 불가 class 선언(inheritance 연관)
	 */
	final static int MAX_NO = 5;
	static int MAX_NUM = 10;
	
	public static void main(String[] args){
		System.out.println(MAX_NO);
		System.out.println(MAX_NUM);
		
		//MAX_NO = 6;
		MAX_NUM = 11;
	}
	
	public final void showInfo() {
			System.out.println(varType);
	}
}

class Animal {
	public void breathe() {
		System.out.println("동물 호흡");
	}
}

class Person extends Animal {
	public void breathe() {
		System.out.println("사람 호흡");
	}
	public static void main(String[] args) {
		Person human = new Person();
		human.breathe();
	}
}