package com.paran.chapter3;
/*
 * 암시적/명시적 형변환(Implicit/Explicit)
 *  1. 암시적 형변환
 *   변수 형태를 '어떤 변수'로 바꿀 건지 명시하지 아니하고 연산자 또는 기타 요인에 의해 변수의 형태를 변환하는 경우
 *   int num = 1.1f + 1; => num = 2.1f;
 *  2. 명시적 형변환
 *   바꾸고자 하는 변수 형태를 정확하게 명시하여 특정 변수로 형태를 변환하는 경우
 *   int num = (int)1.1f + 1; => num = 2
 *
 *
 *    < -------- Down Casting ---------
 * byte - short - int - long - float - double
 *    ----------- Up Casting --------->

 * Up Casting : 본래 표현 가능한 변수 형태보다 표현 범위가 더 넓은 변수로 형태를 변환
 * Down Casting : 본래 표현 가능한 변수 형태보다 표현 범위가 더 좁은 변수로 형태를 변환
 * (class inheritance에서도 동일한 용어 사용. 단, 의미는 다름)
 */
public class CastingDemo {
	// 1. int, long, float type instance 변수 선언
	int num1;
	long num2;
	float num3;
	
	public static void main(String[] args) {
		// 2. CastiongDemo class의 Instance 생성
		CastingDemo vTest = new CastingDemo();
		
		// 3. vTest Instance에 존재하는 3개의 instance 변수에 값 Assign
		vTest.num1 = 10000000000;
		vTest.num2 = 10000000000;
		vTest.num3 = 12.45;
	}
}
