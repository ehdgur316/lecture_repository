package com.paran.chapter17;

class Student {
	String name;
	int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

/*
 * interface -> 상수와 abstract 메서드만으로 구성된 class
 */
interface IInterface {
	public abstract boolean test(Student stu);
}

public class NestedDemo {
	public static void main(String[] args) {
		AnonymousInner inner = new AnonymousInner() {
			public void myMethod() {
				System.out.println("This is an example of anonymous inner class");
			}
		};
		inner.myMethod();
		
		Student[] stuArr = new Student[3];
		
		stuArr[0] = new Student("홍길동", 100);
		stuArr[1] = new Student("임꺽정", 40);
		stuArr[2] = new Student("변사또", 50);
		
		/*
		 * Nested Class(Interface)의 호출 예제 - 함수형 프로그래밍
		 * 익명의 Interface를 메서드 호출 단계에서 재정의하는 것이 가능(Anonymous Inner Class)
		 */
		checkGreaterThanFifty(stuArr, new IInterface() {
			public boolean test(Student stu) {
				if (stu.score >= 50) return true;
				return false;
			}
//			public void showInfo(){
//				System.out.println("Anonymous Inner Class");
//			}
		});
	}
	
	public static void checkGreaterThanFifty(Student[] stuArr, IInterface tester) {
		for (Student stu : stuArr) {
			if (tester.test(stu)) {
				System.out.println(stu.name);
				// 당연히 안됨
				//tester.showInfo();
			}
		}
	}
}

abstract class AnonymousInner {
	public abstract void myMethod();
}