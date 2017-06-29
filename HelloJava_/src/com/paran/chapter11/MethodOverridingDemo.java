package com.paran.chapter11;

/*
 * Method Overloading
 *  같은 식별자를 가지고 있지만 다른 매개변수를 필요로 하는 메서드를 한 class 내에서 반복 선언하는 것
 *  사용하는 매개변수에 따라 호출되는 메서드가 결정됨
 * Method Overriding(Hiding Method)
 *  상속 관계의 두 class에서 부모 class에 선언된 Instance Method를
 *  자식 class에서 다른 형태로 다시 선언하는 것
 * This
 *  Class 자신을 가리키는 Class
 *  this.[변수명] 또는 this([변수명], ... ); 등의 방법으로 접근 가능
 * Super
 *  자식 class에서 부모 class의 멤버에 접근할 수 있는 명령
 *  super.[변수명] 또는 super([변수명], ...); 등의 방법으로 접근 가능
 */

/*
 * 다형성 관점에서의 Class Method
 *  Class Method는 Overriding 되지 않음
 */
public class MethodOverridingDemo {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Cat myCat = new Cat();
		/*
		 * 부모 class type의 변수는 자식 class type를 담을 수 있음
		 *  -> IS-A Relation(소속 관계)에 의해 (묵시적)형변환(UpCasting) 발생
		 *    (상속관계에서 명시적 형변환으로 DownCasting하는 것도 가능)
		 * 현재 상태
		 *  -> 메모리에 할당된 Cat Instance를 myCat과 myAnimal이 같이 참조
		 */
		Animal myAnimal = myCat;
		
		/*
		 * myAnimal에서 Instance Method 호출 -> Cat에 있는 Instance Method가 호출됨
		 * myAnimal의 type은 Animal이지만 myAnimal 자체는 Cat type의 변수를 담고있음
		 * Animal class의 Method에 주석처리하면 해당 코드 오류
		 * 부모 class의 Method 호출 -> Overriding된 자식 class의 Method가 대신 실행
		 * (Overriding - 부모 class의 Method 기능 대신 자식 class의 Method 기능을 재정의)
		 */
		myAnimal.testInstanceMethod();
		
		// Instance에서 Class Method 호출 -> 권장하지 않음(경고 - SuppressWarnings로 무시중)
		myCat.testClassMethod();	// Cat class의 Class Method 실행(Instance와 무관)
		myAnimal.testClassMethod();	// Animal class의 Class Method 실행(Instance와 무관)
		// 같은 Cat Instance를 참조하고 있지만 Class Method는 각자 type의 Class Method를 따름
		
		// 올바른 Class Method 호출 방법
		Animal.testClassMethod();
	}
}

// 부모 class(SuperClass)
class Animal {
	public static void testClassMethod() {
		System.out.println("The static method in Animal");
	}
	public void testInstanceMethod() {
		System.out.println("The instance method in Animal");
	}
}

// SuperClass인 Animal을 상속받은 자식 class(SubClass)
class Cat extends Animal {
	public static void testClassMethod() {
		System.out.println("The static method in Cat");
	}
	public void testInstanceMethod() {
		System.out.println("The instance method in Cat");
	}
}