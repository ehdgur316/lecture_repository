package com.paran.chapter17;

/*
 * Nested Inner Class에서의 Private Member 접근
 *  class를 외부로 노출시키고 싶지 않다는 의도가 있을 때 선언
 *  private와 Inner Class의 선언 위치가 같음 -> 같은 멤버로 간주
 *  Inner Class의 경우 private 접근 지정자 선언이 가능
 *  
 *  Inner Class의 종류
 *   1. Inner Class - 흔히 사용됨
 *    class의 멤버를 선언하는 block에서 다른 class를 선언하는 방식(멤버 변수 선언 위치에서 선언됨)
 *    Instance Inner Class의 경우, 외부 클래스의 인스턴스 생성 후, 그 인스턴스를 사용해 생성해야 함
 *     (Inner Class를 직접 접근할 수 없으므로)
 *    Static Inner Class의 경우, 외부 클래스의 인스턴스틀 생성하지 않고 Inner Class를 사용할 수 있음
 *   2. Method-Local Inner Class
 *    메서드 내부로 class를 선언하는 방식(지역변수 선언 위치에서 선언됨)
 *   3. Anonymous Inner Class - 중요(가장 흔히 사용됨)
 */
public class NestedClassDemo {
	private static int age;
	static class InnerClass {
		public void showAge() {
			System.out.println(age);
		}
	}
	
	public static void main(String[] args) {
		/*
		 * non-static inner class의 생성
		 * 1. 외부 클래스(outer)를 생성하고 그 외부 클래스에 내부 클래스를 생성(outer.new InnerDemo())
		 */
		OuterDemo outer = new OuterDemo(100);
		OuterDemo.InnerDemo inner = outer.new InnerDemo();
		System.out.println(inner.getNum());
		
		/*
		 * 2. 외부 클래스(outer)의 생성자로 내부 클래스를 같이 만들고 getter 메서드로 호출하여 사용
		 */
		OuterDemo outer1 = new OuterDemo(200);
		System.out.println(outer1.getInnerObj().getNum());
		
		OuterDemo.InnerDemo inner1 = outer.new InnerDemo();
		OuterDemo.InnerDemo inner2 = outer.new InnerDemo();
		
		/*
		 * OuterDemo outer의 num을 공유하는 두 Inner Class InnerDemo의 ++ 연산 -> 값 공유
		 */
		inner1.increaseNum();
		inner2.increaseNum();
		System.out.println(inner1.getNum());
		System.out.println(inner2.getNum());
		
		/*
		 * static inner class의 생성
		 *  외부 클래스를 거치지 않고 바로 내부 클래스를 직접 생성 가능
		 *  단, 외부 클래스의 Instance 멤버 변수에 접근하는 것은 불가능
		 */
		NestedClassDemo.InnerClass innerClass = new NestedClassDemo.InnerClass();
		innerClass.showAge();
	}
}

class OuterDemo {
	private int num;
	private InnerDemo innerObj;
	
	public class InnerDemo {
		public int getNum() {
			System.out.println("This is the getnum method of the inner class");
			return num;
		}
		
		public void increaseNum() {
			num++;
		}
	}
	
	public OuterDemo(int num) {
		this.num = num;
		innerObj = new InnerDemo();
	}
	
	public InnerDemo getInnerObj() {
		return innerObj;
	}
}