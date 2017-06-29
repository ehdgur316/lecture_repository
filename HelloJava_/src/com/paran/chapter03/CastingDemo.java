package com.paran.chapter03;
/*
 * 암시적/명시적 형변환(Implicit/Explicit)
 *  1. 암시적 형변환
 *   변수 형태를 '어떤 변수'로 바꿀 건지 명시하지 않고 연산자 또는 기타 요인에 의해 변수의 형태를 변환하는 경우
 *   int num = 1.1f + 1; => num = 2.1f;
 *  2. 명시적 형변환
 *   바꾸고자 하는 변수 형태를 정확하게 명시하여 특정 변수로 형태를 변환하는 경우
 *   int num = (int)1.1f + 1; => num = 2
 *
 *
 *    < -------- Down Casting ---------
 * byte - short - int - long - float - double
 *    ----------- Up Casting --------->
 *
 * Up Casting : 본래 표현 가능한 변수 형태보다 표현 범위가 더 넓은 변수로 형태를 변환
 * Down Casting : 본래 표현 가능한 변수 형태보다 표현 범위가 더 좁은 변수로 형태를 변환
 * (class inheritance에서도 동일한 용어 사용. 단, 의미는 다름)
 * byte와 short은 연산시 int로 변환되어 출력됨 -> 특수한 경우
 */
public class CastingDemo {
	// 1. int, long, float type instance 변수 선언
	int num1;
	long num2;
	float num3;
	
	public static void main(String[] args) {
		// 2. CastingDemo class의 Instance 생성
		CastingDemo varTest = new CastingDemo();
		
		// 3. varTest Instance에 존재하는 3개의 instance 변수에 값 Assign
		varTest.num1 = 2147483647;           // 10000000000;(X) - Integer형 최대치 초과
		varTest.num2 = 9223372036854775807L; // 10000000000;(X) - Long형 Literal은 접미사 L(l) 필요
		varTest.num3 = 12.45F;               // 12.45;(X) - Float 형 Literal은 접미사 F(f) 필요
		
		short num4 = 10;
		short num5 = 20;
		// Short + Short = Integer - 결과값 변수를 int형으로 받거나 결과값을 int로 Up Casting
		//short result = num4 + num5;
		short result = (short)(num4 + num5);
		System.out.println(result);
	}
	
	// instance member function - instance member variable 사용 가능
	public void showInfo() {
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
	}
}
