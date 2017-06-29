package com.paran.chapter11;

/*
 * Reference data type에서의 equal(==) 연산자
 *  두 변수의 '값'이 같냐 다르냐를 보는 것이 아닌, 두 변수가 '참조하고 있는 대상'이 같냐 다르냐를 판별
 */
public class StringDemo {
	public static void main(String[] args) {
		// 문자열을 선언하여 String을 생성하는 경우 -> 같은 문자열이 있으면 String Constant Pool에서 참조
		String str1 = "A";
		String str2 = "B";
		String str3 = "A";
		// new를 사용하여 String을 생성하는 경우 -> Heap 메모리 영역에 새로운 문자열을 생성하고 참조
		String str4 = new String("A");
		
		if (str1 == str2) { // false - 참조 대상이 서로 다름(A와 B)
			System.out.println("1");
		}
		
		if (str1 == str3) { // true - 참조 대상이 서로 같음(A)
			System.out.println("2");
		}
		
		if (str1 == str4) { // false - 참조 대상이 서로 다름
			System.out.println("3"); // (String Constant Pool의 A와 Heap 메모리의 A)
		}
	}
}
