package com.paran.chapter01;
/* UTF-8 Encoded */

/* 
 * 객체(object) - 요소(field/member parameter) + 행위(method/member function)
 * 콘솔(console) - 표준 입출력 장치(input - keyboard, output - monitor) 
 */

/*
 * HelloJava class 선언
 * class -> 객체(instance)를 만들기 위한 양식
 * instance -> class의 양식에 따라 만들어진 객체
 * (class =! 객체 / instance == 객체)
 */
public class HelloJava {
	/*
	 * 멤버 변수, 멤버 함수
	 * Class 바로 아래에 기술되는 변수 또는 함수
	 * 
	 * 	Instance 멤버 변수, Instance 멤버 함수
	 * 	생성자에 의해 생성된 Instance마다 독립적으로 존재하는 변수 또는 함수
	 *  (static 한정자가 선언되지 않은 변수 또는 함수 -> Instance 과정을 거쳐야만 사용 가능)
	 *  Instance 멤버 함수의 경우, static으로 선언된 Class 멤버 변수/함수를 사용할 수 있음
	 * 
	 * 	Class 멤버 변수, Class 멤버 함수
	 * 	같은 Class에 의해 생성된 모든 Instance가 공유하는 변수 또는 함수
	 * 	(static 한정자가 선언된 변수 또는 함수 -> Instance를 만들지 않아도 사용가능)
	 *  Class 멤버 함수의 경우, 함수 외부에 존재하는 Instance 멤버 변수/함수를 사용할 수 없음
	 *  
	 * static 선언된 멤버 변수, 함수 -> Instance 영역의 멤버 변수, 함수와 공유
	 * (Instance와 Class는 서로 저장된 메모리 영역이 다름, Class 저장 영역은 공유되지만 Instance는 아님)
	 */
	String helloStr = "Hello, World!"; // Class Block에서 선언, Instance 없음 -> Instance 멤버 변수
	static int MAX_NUMBER = 10; // Class Block에서 선언, Instance 있음 -> Class 멤버 변수
	
	/*
	 * 기본 생성자 함수(constructor, 생성하지 않아도 내부적으로 존재)
	 * 생성자 함수 -> Instance를 생성하면서 실행되는 함수(생성하면서 실행되는 것 외에 호출 불가능)
	 * 생성자 함수는 Return Type이 존재하지 않음
	 */
	public HelloJava() {

	}
	
	/* 
	 * 사용자 정의 함수
	 * [객체 이름].[메서드 이름]의 형태로 임의로 호출 가능한 함수
	 */
	public static void printMsg(String arg) {
		System.out.println(arg);
	}
	
	/* 
	 * main 메서드 선언
	 * public static void main 으로 기술된 메서드 -> Entry Point(진입점)로 활용(불변 양식)
	 * public(접근자)
	 * static(한정자) -> 요소 또는 메서드의 인스턴스화 과정을 거칠 필요 없이 실행 가능
	 * (== static이 없는 요소 또는 메서드는 인스턴스화 과정을 거치지 않으면 사용 불가능)
	 * void main(String[] args) -> 메서드 특징
	 * [메서드 타입 = void] [메서드 식별자 = main]([메서드 변수(argument) = String[] args])
	 */
	public static void main(String[] args) {
		//String helloStr = "Hello, World!"; // Method Block에서 선언 -> 지역 변수
		/* 
		 * Instance 생성 과정
		 * 1. HelloJava obj -> HelloJava class의 지역변수(Local Parameter) obj 생성
		 * 2. new HelloJava() -> HelloJava의 Instance를 생성(new 명령 -> Instance 생성)
		 * 3. HelloJava Instance를 HelloJava 타입의 변수 obj에 할당
		 */
		//HelloJava obj = new HelloJava();
		
		/*
		 * 사용자 정의 함수 호출
		 * [객체 이름].[메서드 이름] 형태로 호출
		 */
		//obj.printMsg("Hello!");
		
		/*
		 * static으로 선언되지 않은 사용자 정의 함수
		 * 객체를 통해 실행되지 않았으므로 실행되지 않고 에러 발생
		 * 위와 같이 사용자 정의 함수를 호출하거나 함수 자체를 static으로 선언하면 해결 가능
		 */
		//printMsg("Hello!");
		
		/*
		 * static으로 선언된 사용자 정의 함수
		 * 객체를 생성하지 않고 함수만을 호출해도 실행할 수 있음
		 * 단, 매개변수로 Instance 멤버 변수를 사용할 수 없음
		 */
		//printMsg(helloStr);
		
		// Class 멤버 함수와 Class 멤버 변수를 사용한 것은 맞으나 매개변수 타입이 일치하지 않음
		printMsg(MAX_NUMBER + ""); // String 타입과 연산하여 강제로 형변환
	}
}