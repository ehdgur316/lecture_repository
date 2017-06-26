package com.paran.chapter2;

/*
 * github 작업 중 실수로 데이터 삭제함
 * 코드는 복원, 주석은 전부 삭제됨
 */

/*
 * 변수의 종류
 *  1. local variable
 *   class block을 제외한 다른 block 내에서 선언된 변수
 *   주로 메서드나 임의로 생성한 block 내의 변수
 *   
 *  2. instance member variable
 *   class block 내에서 선언된 변수 중 static 한정자가 없는 변수
 *   각각의 Instance마다 독립적인 값을 가짐
 *   
 *  3. class member variable
 *   class block 내에서 선언된 변수 중 static 한정자가 있는 변수
 *   class 또는 그 class로 생성한 모든 Instance가 공유하는 값을 가짐
 *  (변수의 유효 범위 이해 - visible/non-visible variable)
 */
public class Variable {
	int varType;
	
	/*
	 * final 한정자의 사용
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