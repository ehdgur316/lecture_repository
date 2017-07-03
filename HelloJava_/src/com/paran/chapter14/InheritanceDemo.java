package com.paran.chapter14;

public class InheritanceDemo {
	public static void main(String[] args) {
		B instB = new B(10); // instB의 Type은 class B reference type
		A instA;
		
		instB.methodA(); // Overriding된 class B의 methodA() 실행
		//instB.salary = 1; // class B의 Instance로 Instance Member Variable 접근
		//instB.age = 1; // class B의 Instance로 부모 Class의 Instance Member Variable 접근
		
		instA = instB;
		instA.methodA(); // instA의 Instance는 class B이므로 class B의 methodA() 실행
		//instA.methodB(); // class A에는 methodB가 없으므로 class A type인 instA로는 실행 불가
		
		/*
		 * 부모 class에 있는 변수를 자식 class에서 재할당하여 사용
		 * 굉장히 권장하지 않는 방법
		 * 멤버 변수의 경우, JAVA의 다형성의 영향을 받지 않음
		 */
		System.out.println(instA.age); // class A의 age 값(=1) 출력
		System.out.println(((B)instA).age); // class B의 age 값(=2) 출력
	}
}

class A {
	public A(int age) {
		this.age = age; // 자식 class에서 호출하는 생성자 함수 super()의 원형
	}
	
	public int age;
	
	public void methodA() {
		System.out.println("methodA in A Class");
	}
}

class B extends A {
	public B(int age) {
		super(age); // 부모 class인 class A의 생성자 함수를 호출(매개변수 age)
		this.age = age; // 자기 자신의 Instance 변수에 매개변수 age 값을 할당
	}
	
	//public int salary;
	public int age;
	
	@Override
	public void methodA() {
		//super.methodA();
		System.out.println("methodA in B Class");
	}
	public void methodB() {
		System.out.println("methodB in B Class");
	}
	public void methodC() {
		System.out.println(super.age);
	}
}