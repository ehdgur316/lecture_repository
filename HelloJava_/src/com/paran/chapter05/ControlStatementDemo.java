package com.paran.chapter05;

/*
 * 실행흐름 제어(Flow Control)
 * 메서드 실행 분류
 *  1. 동기함수
 *   흐름 제어에 의해 메서드의 반환값을 기다리는 경우(통상적인 Method)
 *  2. 비동기함수
 *   흐름 제어와는 별개로 메서드를 실행한 후 반환값을 기다리지 않는 경우(Socket Programming)
 */
public class ControlStatementDemo {
	public static void main(String[] args/*String args[] 도 허용*/) {
		/*
		 * 배열을 활용한 Instance 생성
		 * class의 배열 - class 이름에 배열 갯수 선언(Instance를 생성한 것이 아님)
		 * 각 class마다 Instance 생성 - Instance 배열 생성(class 배열로 각각의 Instance 접근가능)
		 */
		//참조(reference) 타입인 class의 Array(reference type)
		Student[] stdArr = new Student[3];
		stdArr[0] = new Student();
		stdArr[1] = new Student("임꺽정", "201600002", false);
		stdArr[2] = new Student("변사또", "201600003", true);
		
		/*
		 * private 선언된 Student class 내부의 Instance 변수에 접근
		 * Student class 외부(= ControlStatementDemo class)에서 접근 불가능
		 */
		//stdArr[0].name = "홍길동";
		//stdArr[0].stdID = "50019398483";
		//stdArr[0].isMilSer = false;
		
		/*
		 * 기본생성자 + public 메서드를 활용한 private instance 멤버 변수 접근 및 할당
		 */
		stdArr[0].setName("홍길동");
		stdArr[0].setID("201600001");
		stdArr[0].setIsMilSer(true);
		
		/*
		 * While 조건문을 활용한 Instance 전체 출력
		 * index 제어 실패시 OutofIndexException 발생 여지가 있음
		 */
		System.out.println("While 조건문 출력");
		int j = 0;
		while(j < stdArr.length) {
			stdArr[j].showInfo();
			j++;
		}
		
		/*
		 * do while 구문
		 */
//		do {
//			
//		} while(true);
		
		/*
		 * for 조건문과 if 조건문을 활용한 Instance 조건부 출력
		 * index 제어 실패시 OutofIndexException 발생 여지가 있음
		 */
		System.out.println("for, if 조건문 출력");
		for (int i = 0 ; i < stdArr.length ; i++) {
			if (stdArr[i].getIsMilSer()/*getIsMilSer() 반환값이 boolean, == true 없어도 됨*/) {
				stdArr[i].showInfo();
			}
		}
		
		/*
		 * for 구문의 다른 형태(for each 구문 - 배열의 각 구성요소 순차적 접근)
		 * for 구문에 비해 오류 발생 여지가 적고 안정적
		 */
		System.out.println("for each, if 조건문 출력");
		for (Student std : stdArr) {
			/*
			 * 조건문의 실행문이 한 줄일 경우 block 선언을 생략할 수 있음
			 */
			if (std.getIsMilSer()) std.showInfo();
			else continue;
		}
		
		/*
		 * if - else if - else 구문
		 */
//		if ( 1 > 2 ) {
//			
//		}
//		else if ( 2 > 3 ) {
//			
//		}
//		else {
//			
//		}
	}
}