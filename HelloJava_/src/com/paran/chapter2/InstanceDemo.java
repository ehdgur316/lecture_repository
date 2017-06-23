package com.paran.chapter2;

public class InstanceDemo {
	public static void main(String[] args) {
		String msg = "Hello, Printer!";
		/*
		 * Data Type - Primitive / Reference
		 *  Primitive(기본) -> 기본적으로 제공하는 데이터 타입(int, char, boolean 등)
		 *  Reference(참조) -> 기본 데이터 타입을 제외한 다른 형태의 데이터 타입(Class명 등)
		 */
		// new [Constructor]([Parameter]);
		Printer ssPrinter = new Printer("Samsung", true);
		Printer hpPrinter = new Printer("HP", false);
		Printer epPrinter = new Printer("Epson", false);
		
		/*
		 * 생성자 호출 시 Heap 메모리에 각각의 독립적인 Instance가 생성
		 * 각 Instance의 식별자를 활용하여 Instance에 접근 가능
		 * (static의 경우 Heap 메모리가 아닌 Static 영역에 별도로 생성되므로
		 *  독립적인 Instance가 static 멤버 변수에 접근하여 동일한 값을 얻을 수 있음)
		 */
		ssPrinter.print(msg); // 식별자가 ssPrinter인 Instance 접근, print Instance 멤버 함수 호출
		hpPrinter.print(msg); // 식별자가 hpPrinter인 Instance 접근, print Instance 멤버 함수 호출
		epPrinter.print(msg); // 식별자가 epPrinter인 Instance 접근, print Instance 멤버 함수 호출
		
		/*
		 * Instance와 연관되지 않는, 단일 기능을 구현한 함수를 사용하고자 할 경우 Class 멤버 함수 활용
		 * Instance별로 다른 기능을 적용하는 함수를 사용하고자 할 경우 Instance 멤버 함수 활용
		 */
		//ssPrinter.print_A(msg); // Instance를 사용하여 Class 멤버 함수 호출 가능(허용하나 주의)
		Printer.print_A(msg); // Class를 사용하여 Class 멤버 함수 호출 가능(올바른 방법)
	}
}

class Printer {
	/* 
	 * 생성자 함수 선언
	 * 생성자 함수에 매개변수 설정 -> Instance 생성시 매개변수가 필요
	 */
	public Printer(String manufacture, boolean isColorPrinter) {
		/* 
		 * Shadowing -> 지역 변수와 멤버 변수의 이름이 동일할 때, 지역 변수에 의해 멤버 변수가 가려지는 현상
		 * (Printer의 멤버 변수 manufacture == Printer 생성자 함수의 매개변수 manufacture)
		 * this -> 생성자 함수에 의해 생성된 Instance 자신을 의미 (Shadowing 현상 해결 가능)
		 */
		this.manufacture = manufacture;
		this.isColorPrinter = isColorPrinter;
		/* 
		 * 즉, 생성자 Printer에 의해 생성된 Instance에
		 * 매개변수로 받은 manufacture, isColorPrinter를 활용하여
		 * 해당 Instance의 Instance 멤버 변수 manufacture, isColorPrinter의 값을 설정할 것
		 */ 
	}
	// static 선언되지 않은 멤버 변수 -> Instance 멤버 변수
	String manufacture; // 제조사 명칭
	boolean isColorPrinter; // 컬러 또는 흑백 프린터 구별
	
	// static 선언되지 않은 멤버 함수 -> Instance 멤버 함수
	public void print(String arg) { // Class 프린터의 동작
		if ( isColorPrinter == true) {
			System.out.println(manufacture + "\tColor Printer\t" + arg);
		}
		else {
			System.out.println(manufacture + "\t Mono Printer\t" + arg);
		}
	}
	
	// static 선언된 멤버 함수 -> Class 멤버 함수
	public static void print_A(String arg){
		System.out.println("Message : " + arg);
	}
}