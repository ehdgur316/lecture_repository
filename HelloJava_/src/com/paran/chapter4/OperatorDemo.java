package com.paran.chapter4;

/*
 * 연산자
 *  1. 산술연산자(이항연산자)
 *   사칙연산(+, -, *, /), mod연산(%)
 *   결합방향 : ->
 *  2. 논리연산자(!만 단항, 나머지는 이항연산자)
 *   AND(&&, 논리곱), OR(||, 논리합), NOT(!, 논리부정)
 *  3. 대입연산자
 * 
 *  4. 관계연산자
 *   
 *  5. 비트연산자
 *   
 *  6. 기타연산자
 *   3항연산자, instanceof
 */
public class OperatorDemo {
	public static void gradingScore(StudentScore std) {
		if (std.getAvg() > 80)
			System.out.println(std.stdName + "의 평균 : " + std.getAvg() + ", 학점 : A");
		else if (std.getAvg() <= 80 && std.getAvg() > 60)
			System.out.println(std.stdName + "의 평균 : " + std.getAvg() + ", 학점 : B");
		else
			System.out.println(std.stdName + "의 평균 : " + std.getAvg() + ", 학점 : C");
	}
	
	public static void main(String[] args) {
		StudentScore obj1 = new StudentScore(80, 75, "Kim");
		StudentScore obj2 = new StudentScore(90, 80, "Lee");
		StudentScore obj3 = new StudentScore(60, 55, "Park");
		
		gradingScore(obj1);
		gradingScore(obj2);
		gradingScore(obj3);
	}
}

class StudentScore {
	int engScore;
	int korScore;
	String stdName;
	
	// Constructor
	public StudentScore(int engScore, int korScore, String stdName) {
		this.engScore = engScore;
		this.korScore = korScore;
		this.stdName = stdName;
	}
	
	public void showInfo() {
		System.out.println("======= 정보출력 시작 =======");
		System.out.println("이름 : " + stdName);
		System.out.println("영어점수 : " + engScore);
		System.out.println("국어점수 : " + korScore);
		System.out.println("======= 정보출력 종료 =======");
	}
	
	/*
	 * 산술연산자 +, / 사용
	 * 출력결과를 실수형으로 얻기 위해 나누는 값을 2.0으로
	 */
	public double getAvg() {
		return (engScore + korScore) / 2.0;
	}
}