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
		Student[] stuArr = new Student[3];
		
		stuArr[0] = new Student("홍길동", 100);
		stuArr[1] = new Student("임꺽정", 40);
		stuArr[2] = new Student("변사또", 50);
		
		/*
		 * Nested Class(Interface)의 호출 예제 - 함수형 프로그래밍
		 * 익명의 Interface를 메서드 호출 단계에서 재정의하는 것이 가능
		 */
		checkGreaterThanFifty(stuArr, new IInterface() {
			public boolean test(Student stu) {
				if (stu.score >= 50) return true;
				return false;
			}
		});
	}
	
	/*
	 * Nested Class의 선언 예제
	 */
	public static void checkGreaterThanFifty(Student[] stuArr, IInterface tester) {
		for (Student stu : stuArr) {
			if (tester.test(stu)) {
				System.out.println(stu.name);
			}
		}
	}
}
