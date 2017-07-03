package com.paran.chapter13;

public class TenaryOperatorDemo {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		/*
		 *  3항 연산자 - [조건식] ? [true일 때 반환값] : [false일 때 반환값]
		 *  단, 반환값은 변수 타입에 일치되어 사용하여야 함
		 *  3항 연산자 자체를 복수로 중첩하여 사용할 수도 있음
		 */
		String result = 1 > 3 ? "Big" : 1 > 2 ? "Big" : "Small";
		System.out.println(result);
	}
}
