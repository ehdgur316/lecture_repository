package com.paran.chapter17;

public interface DoIt {
	void doSomething(int i, double x);
	int doSomethingElse(String s);
	default boolean didItWork(int i, double x, String s) {
		System.out.println("DoIt");
		return true;
	}
}

/*
 * DoIt interface를 상속받는 DoItPlus interface
 * DoIt interface가 가지고 있는 2개의 abstract 메서드를 상속받음
 * DoIt interface가 가지고 있는 default 메서드를 Override
 */
interface DoItPlus extends DoIt {
	
	@Override
	default boolean didItWork(int i, double x, String s) {
		/*
		 * interface의 default 메서드를 호출할 경우 지켜야 할 문법
		 *  [interface 명].super.[메서드]([매개변수], ...);
		 * 
		 * 이 문법을 지키지 않고 메서드만 호출할 경우 재귀함수의 무한루프
		 */
		DoIt.super.didItWork(i, x, s);
		System.out.println("DoItPlus");
		return true;
	}
}

/* 
 * DoItPlus interface를 구현하는 DoSomething class
 * DoItPlus interface가 상속받은 2개의 abstract 메서드를 구현
 */
class DoSomething implements DoItPlus {

	@Override
	public void doSomething(int i, double x) {
		// TODO Auto-generated method stub
		didItWork(1, 1.1, "a");
	}

	@Override
	public int doSomethingElse(String s) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

class Activator {
	public static void main(String[] args) {
		DoSomething obj = new DoSomething();
		// IS-A 관계에 의해 가능
		@SuppressWarnings("unused")
		DoIt obj1 = obj;
		/*
		 *  DoIt, DoItPlus 순차 출력
		 *   1. DoSomething class의 doSomething 메서드 실행
		 *   2. doSomething 메서드에서 interface(DoItPlus)의 didItWork 메서드 실행
		 *   3. DoItPlus interface의 didItWork 메서드에서 부모 interface인 DoIt interface의 didItWork 메서드 실행
		 *   4. DoIt interface의 didItWork 메서드에서 DoIt을 출력하는 구문을 실행하고 반환
		 *   5. DoItPlus interface의 didItWork 메서드에서 DoItPlus를 출력하는 구문을 실행하고 반환
		 *   6. 실행완료
		 */
		obj.doSomething(0, 0.0);
		// 실행 결과 없음 - DoSomething class의 doSomethingElse 메서드 실행, 반환
		obj.doSomethingElse("b");
	}
}