package com.paran.chapter14;

/*
 * 상속과 class member variable/method
 *  상속의 대상은 instance member variable/method
 *  class member와는 다른 개념임을 인지할 것
 *  
 * 상속받은 자식 class에서 할 수 있는 것
 *  1. 상속받은 field는 즉시 호출 가능
 *  2. 부모 class에서 할당되지 않은 field라도 새로 할당해서 사용할 수 있음
 *  3. 상속받은 method는 즉시 사용 가능
 *  4. 부모 class가 갖고있는 field를 자식 class에서 동일한 식별자로 재정의하여 사용할 수 있음
 *    (단, 부모 class의 field는 숨겨짐(hiding)) - 권하지 않는 사용법
 *  5. 부모 class가 갖고있는 method를 자식 class에서 동일한 signature로 재정의하여 사용할 수 있음
 *    (method signature - 메서드명, parameter 타입과 종류 / method overriding)
 *  6. 부모 class가 갖고있는 static method를 자식 class에서 동일한 signature로 재정의하여 사용할 수 있음
 *    (단, 부모 class의 static method는 숨겨짐(hiding) / method overriding이 아님)
 *  7. 부모 class가 갖고있지 않은 새로운 메서드를 자식 class에서 정의할 수 있음
 *  8. 자식 class의 생성자는 부모 class의 생성자를 반드시 먼저 호출해야 함
 *    (단, 기본 생성자 함수의 경우 호출하지 않아도 됨)
 */
public class InheritanceDemo {
	public static void main(String[] args) {
		B instB = new B(10); // instB의 Type은 class B reference type
		A instA;
		C instC = new C(15);
		
		instB.methodA(); // Overriding된 class B의 methodA() 실행
		//instB.salary = 1; // class B의 Instance로 Instance Member Variable 접근
		//instB.age = 1; // class B의 Instance로 부모 Class의 Instance Member Variable 접근
		
		instA = instB; /* instA = instC도 할당가능(최상위 부모 class A)
					    * 마찬가지로 Object type 변수에 모든 class를 할당할 수 있음(모든 class의 부모)
					   	*/
		
		instA.methodA(); // instA의 Instance는 class B이므로 class B의 methodA() 실행
		//instA.methodB(); // class A에는 methodB가 없으므로 class A type인 instA로는 실행 불가
		
		/*
		 * 부모 class에 있는 변수를 자식 class에서 재할당하여 사용
		 * 굉장히 권장하지 않는 방법
		 * 멤버 변수의 경우, JAVA의 다형성의 영향을 받지 않음
		 */
		System.out.println(instA.age); // class A의 age 값 출력
		System.out.println(((B)instA).age); // class B의 age 값 출력
		
		System.out.println(instC.age); // class C의 age 값 출력
	}
}

class A {
	/*
	 * 부모 class에서 별도의 역할이 있는 생성자 함수를 선언할 경우
	 * 이를 상속한 모든 자식 class 함수는 자신의 생성자 함수를 통해 부모 생성자 함수를 호출해야함
	 */
	public A(int age) {
		this.age = age; // 자식 class에서 호출하는 생성자 함수 super()의 원형
	}
	
	public int age;
	
	public void methodA() {
		System.out.println("methodA in A Class");
	}
}

class B extends A {
	/*
	 * 상속 관계의 class에서 부모 class가 다른 매개변수를 요구하는 생성자 함수가 있을 경우
	 * 자식 class에서 기본 생성자 함수를 사용할 수 없고
	 * 부모 class의 생성자 함수를 호출하는 자식 class의 생성자 함수를 따로 선언해줘야 함
	 */
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

class C extends B {
	// class C의 부모 class인 class B의 생성자 함수 호출 필요
	public C(int age) {
		super(age);
		// TODO Auto-generated constructor stub
		this.age = age;
	}
	
	public int age;
}