package com.paran.chapter13;

class StaticTest {
	static String name = "홍길동";
	String address = "대한민국 순천시 조례동";
	public void showAddress() {
		System.out.println(address);
	}
	// Class Member Function - Instance Member 접근 불가
	public static void showName() {
		System.out.println(name);
		//System.out.println(address); // Instance Member Variable 접근 - 오류
		//System.out.println(this.name); // this로 Class Member Variable 접근 - 오류
		//showAddress(); // Instance Member Function 호출 - 오류
		
		// Instance 생성 -> Class Member Function 내의 지역변수
		StaticTest obj = new StaticTest();
		// Instance를 생성하고 Instance로 Instance Member Variable/Function 접근 - 가능
		System.out.println(obj.address);
		obj.showAddress();
	}
}
