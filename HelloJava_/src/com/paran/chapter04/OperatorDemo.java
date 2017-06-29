package com.paran.chapter04;

/*
 * 연산자
 *  1. 산술연산자(이항연산자)
 *   사칙연산(+, -, *, /), MOD연산(%)
 *   결합방향 : ->
 *  2. 논리연산자(!만 단항, 나머지는 이항연산자)
 *   AND(&&, 논리곱), OR(||, 논리합), NOT(!, 논리부정)
 *   결합방향 : ->, NOT(!)은 <-
 *  3. 대입연산자(이항연산자)
 *   Assign(=)
 *   결합방향 : <-
 *  4. 관계연산자(이항연산자)
 *   비교연산(<, >, <=, >=, ==, !=)
 *   결합방향 : ->
 *  5. 비트연산자(~만 단항, 나머지는 이항연산자)
 *   AND(&, 비트곱), OR(|, 비트합), XOR(^, 비트배타합), NOT(~, 비트부정[1's Complement])
 *     Bit Shift 연산자(일반 산술연산 *, /보다 시스템 처리속도가 빠름)
 *   <<(왼쪽으로 Shift), >>(오른쪽으로 Shift), >>>(왼쪽으로 Shift)
 *   >>연산은 빈 칸을 음수면 1, 양수면 0으로 채움
 *   <<, >>>연산은 빈 칸을 0으로 채움
 *   결합방향 : ->, NOT(~)은 <-
 *  6. 기타연산자
 *   부호연산자(+, -), 3항연산자, instanceof
 *   
 *  연산자 우선순위
 *   우선순위 0(우선순위를 무시하는 방법) - 괄호로 묶어 연산순서 제어
 *   우선순위 1(최상) - [ ](배열, Array), .(Instance 접근)
 *   우선순위 2 - [Var]++(후위증가연산), [Var]--(후위감소연산)
 *              후위증가/감소 연산 -> 선 사용, 후 증감
 *   우선순위 3 - ++[Var](전위증가연산), --[Var](전위감소연산),
 *              부호, 비트반전, 논리부정, Type Casting
 *              전위증가/감소 연산 -> 선 증감, 후 사용
 *   우선순위 4 - 산술연산 중 '승제'(*, /, %)
 *   우선순위 5 - 산술연산 중 '가감'(+, -)
 *   우선순위 6 - Bit Shift 연산
 *   우선순위 7 - 관계연산 중 '비교'(<, <=, >, >=), instanceof
 *   우선순위 8 - 관계연산 중 '동일'(==, !=)
 *   우선순위 9 - 비트곱(&)
 *   우선순위 10 - 비트 배타합(^)
 *   우선순위 11 - 비트합(|)
 *   우선순위 12 - 논리곱(&&)
 *   우선순위 13 - 논리합(||)
 *   우선순위 14 - 조건판단(?[조건]:[예외])
 *   우선순위 15(최하) - 대입연산(=) 및 대입연산을 활용한 복합대입연산
 *         (+=, -=, *=, /=, %=, &=, ^=, |=, <<=, >>=, >>>=)
 */
public class OperatorDemo {
	public static void main(String[] args) {
		StudentScore obj1 = new StudentScore("홍길동", 100, 80);
		StudentScore obj2 = new StudentScore("임꺽정", 50, 40);
		StudentScore obj3 = new StudentScore("변사또", 80, 80);
		
		obj1.showInfo();
		obj2.showInfo();
		obj3.showInfo();
		
		/*
		 * 관계연산자 >=, <=, 논리연산자 &&를 사용한 조건문 if
		 * 우선순위가 높은 관계연산자에 의해 양쪽 true, false 평가 후 그 결과를 논리곱
		 */
		if (obj1.getAvg() >= 90.0 && obj1.getAvg() <= 100.0) {
			obj1.showInfo();
		}
		if (obj2.getAvg() >= 90.0 && obj2.getAvg() <= 100.0) {
			obj2.showInfo();
		}
		if (obj3.getAvg() >= 90.0 && obj3.getAvg() <= 100.0) {
			obj3.showInfo();
		}
		
		/*
		 * 후위가감연산과 전위가감연산
		 */
		int a = 1;
		@SuppressWarnings("unused")
		int sum;
		sum = ++a + 3; // 먼저 a가 1 증가한 후 +3, 그 결과가 sum
		sum = a++ + 3; // a에 +3한 결과가 sum, 그 후에 a가 1 증가
		
		// 2는 2와 같은가? -> 불필요한 조건문(경고)
		//if (1 + 1 == 1 + 1) {
			System.out.println("같음");
		//}
		
		a += 1; // a = a + 1;
		a += 1 + 2; // a = a + (1 + 2);
	}
}

class StudentScore {
	int engScore;
	int korScore;
	String stdName;
	
	// Constructor
	public StudentScore(String stdName, int korScore, int engScore) {
		this.stdName = stdName;
		this.korScore = korScore;
		this.engScore = engScore;
	}
	
	public void showInfo() {
		System.out.println("======= 정보출력 시작 =======");
		System.out.println("이름 : \t" + stdName);
		System.out.println("영어점수 : \t" + engScore);
		System.out.println("국어점수 : \t" + korScore);
		System.out.println("======= 정보출력 종료 =======");
	}
	
	/*
	 * 산술연산자 +, /를 사용한 메서드
	 * 출력결과를 실수형으로 얻기 위해 나누는 값을 2.0으로
	 */
	public double getAvg() {
		return (engScore + korScore) / 2.0;
	}
}